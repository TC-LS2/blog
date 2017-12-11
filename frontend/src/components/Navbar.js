import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';

import CurrentUserName from '../containers/CurrentUserName';
import ViewLink from '../containers/ViewLink';
import ViewNavItem from '../containers/ViewNavItem';

export default function MainNavbar() {
  return (
    <Navbar>
      <Navbar.Header>
        <Navbar.Brand>
          <ViewLink text="Posts" root="posts" className="navbar-brand" />
        </Navbar.Brand>
        <Navbar.Toggle />
      </Navbar.Header>
      <Navbar.Collapse>
        <Nav>
          <ViewNavItem root="newPost">[ New ]</ViewNavItem>
          <ViewNavItem root="myPosts">[ My Posts ]</ViewNavItem>
          <ViewNavItem root="myComments">[ My Comments ]</ViewNavItem>
        </Nav>
        <Nav pullRight>
          <ViewNavItem root="users">
            [ Users (I'm <CurrentUserName />) ]
          </ViewNavItem>
          &nbsp;&nbsp;&nbsp;&nbsp;
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}
