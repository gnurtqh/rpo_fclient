import React, { Component } from "react";

class Pagination extends Component {
  constructor(props) {
    super(props);
    this.state = {
      pageLimit: this.props.pageLimit,
      totalRecords: this.props.totalRecords,
      pageNeighbours: this.props.pageNeighbours,
      currentPage: 1,
      totalPage: Math.ceil(this.props.totalRecords / this.props.pageLimit),
    };
  }
  fetchPageNumbers = (totalPages) => {
    const currentPage = this.state.currentPage;
    const pageNeighbors = this.state.pageNeighbours;
    const totalNumbers = this.state.pageNeighbours * 2 + 3;
    const totalBlocks = totalNumbers + 2;
  };
  goToPage = (page) => {
    const { onPageChanged = (f) => f } = this.props;
    this.setState({ currentPage: page }, () => onPageChanged(page));
  };
  render() {
    const totalRecords = this.props.totalRecords;
    const totalPages = Math.ceil(
      this.props.totalRecords / this.state.pageLimit
    );
    if (!totalRecords || totalPages === 1) return null;
    const { currentPage } = this.state;
    const pages = this.fetchPageNumbers(totalPages);
    return <div></div>;
  }
}

export default Pagination;
