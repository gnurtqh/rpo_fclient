import { faEdit, faPlus, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { Component } from "react";
import { Pagination } from "react-bootstrap";
import BackendService from "../services/BackendService";
import Alert from "./Alert";

class CountryList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: undefined,
      countries: [],
      selected_countries: [],
      show_alert: false,
      checkedItems: [],
      hidden: false,
      page: 1,
      limit: 5,
      totalCount: 0,
    };
    this.refreshCountry = this.refreshCountry.bind(this);
    this.updateCountryClicked = this.updateCountryClicked.bind(this);
    this.addCountryClicked = this.addCountryClicked.bind(this);
    this.onDelete = this.onDelete.bind(this);
    this.closeAlert = this.closeAlert.bind(this);
    this.handleCheckChange = this.handleCheckChange.bind(this);
    this.handleGroupCheckChange = this.handleGroupCheckChange.bind(this);
    this.setChecked = this.setChecked.bind(this);
    this.deleteCountriesClicked = this.deleteCountriesClicked.bind(this);
    this.onPageChange = this.onPageChange.bind(this);
  }
  onPageChange(cp) {
    this.refreshCountries(cp - 1);
  }

  setChecked(v) {
    let checkedCopy = Array(this.state.countries.length).fill(v);
    this.setState({ checkedItems: checkedCopy });
  }
  handleCheckChange(e) {
    const idx = e.target.name;
    const isChecked = e.target.checked;
    let checkedCopy = [...this.state.checkedItems];
    checkedCopy[idx] = isChecked;
    this.setState({ checkedItems: checkedCopy });
  }
  handleGroupCheckChange(e) {
    const isChecked = e.target.checked;
    this.setChecked(isChecked);
  }

  deleteCountriesClicked() {
    let x = [];
    this.state.countries.map((t, idx) => {
      if (this.state.checkedItems[idx]) {
        x.push(t);
      }
      return 0;
    });
    if (x.length > 0) {
      var msg;
      if (x.length > 1) msg = `Are you want to delete ${x.length} countries?`;
      else msg = "Are you want to delete all countries?";
      this.setState({ show_alert: true, selected_countries: x, message: msg });
    }
  }
  onDelete() {
    BackendService.deleteCountries(this.state.selected_countries)
      .then(() => this.refreshCountry())
      .catch(() => {});
  }
  closeAlert() {
    this.setState({ show_alert: false });
  }
  refreshCountry() {
    BackendService.retrieveAllCountries()
      .then((res) => {
        this.setState({ countries: res.data, hidden: false });
      })
      .catch(() => {
        this.setState({ hidden: true });
      })
      .finally(() => this.setChecked(false));
  }
  refreshCountries(cp) {
    console.log("cp2", this.state.page);
    BackendService.retrieveAllCountries(cp, this.state.limit)
      .then((res) => {
        this.setState({
          countries: res.data.content,
          totalCount: res.data.totalElements,
          page: cp,
          hidden: false,
        });
      })
      .catch(() => {
        this.setState({ totalCount: 0, hidden: true });
      })
      .finally(() => this.setChecked(false));
  }
  componentDidMount() {
    this.refreshCountries(0);
  }
  updateCountryClicked(id) {
    this.props.history.push(`/countries/${id}`);
  }
  addCountryClicked() {
    this.props.history.push(`/countries/-1`);
  }
  render() {
    if (this.state.hidden) return null;
    return (
      <div className="m-4">
        <div className="row my-2 mr-0">
          <Pagination
            totalRecords={this.state.totalCount}
            pageLimit={this.state.limit}
            pageNeighbours={1}
            onPageChange={this.onPageChange}
          />
          <h3>Countries</h3>
          <button
            className="btn btn-outLine-secondary ml-auto"
            onClick={this.addCountryClicked}
          >
            <FontAwesomeIcon icon={faPlus} />
            &nbsp;Add
          </button>
          <button
            className="btn btn-outLine-secondary ml-2"
            onClick={this.deleteCountriesClicked}
          >
            <FontAwesomeIcon icon={faTrash} />
            &nbsp;Delete
          </button>
        </div>
        <div className="row my-2 mr-0">
          <table className="table table-sm">
            <thead className="thead-light">
              <tr>
                <th>Name</th>
                <th>
                  <div className="btn-toolbar pb-1">
                    <div className="btn-group ml-auto">
                      <input
                        type="checkbox"
                        onChange={this.handleGroupCheckChange}
                      />
                    </div>
                  </div>
                </th>
              </tr>
            </thead>
            <tbody>
              {this.state.countries &&
                this.state.countries.map((country, index) => (
                  <tr key={country.id}>
                    <td>{country.name}</td>
                    <td>
                      <div className="btn-toolbar">
                        <div className="btn-group ml-auto">
                          <button
                            className="btn btn-outLine-secondary btn-sm btn-toolbar"
                            onClick={() =>
                              this.updateCountryClicked(country.id)
                            }
                          >
                            <FontAwesomeIcon icon={faEdit} fixedWidth />
                          </button>
                        </div>
                        <div className="btn-group ml-2 mt-1">
                          <input
                            type="checkbox"
                            name={index}
                            checked={
                              this.state.checkedItems.length > index
                                ? this.state.checkedItems[index]
                                : false
                            }
                            onChange={this.handleCheckChange}
                          />
                        </div>
                      </div>
                    </td>
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
        <Alert
          title="Delete"
          message={this.state.message}
          ok={this.onDelete}
          close={this.closeAlert}
          modal={this.state.show_alert}
          cancelButton={true}
        />
      </div>
    );
  }
}

export default CountryList;
