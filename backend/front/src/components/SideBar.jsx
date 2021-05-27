import { faGlobe } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { Component } from "react";
import { Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
class SideBar extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <>
        {this.props.expanded && (
          <Nav className={"flex-column my-sidebar my-sidebar-expanded"}>
            <Nav.Item>
              <Nav.Link as={Link} to="/countries">
                <FontAwesomeIcon icon={faGlobe} />
                &nbsp;Countries
              </Nav.Link>
            </Nav.Item>
          </Nav>
        )}
        {!this.props.expanded && (
          <Nav className={"flex-column my-sidebar my-sidebar-collapsed"}>
            <Nav.Item>
              <Nav.Link as={Link} to="/countries">
                <FontAwesomeIcon icon={faGlobe} size="2x" />
              </Nav.Link>
            </Nav.Item>
          </Nav>
        )}
      </>
    );
  }
}

export default SideBar;
