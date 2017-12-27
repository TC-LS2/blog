import React from 'react';
import { PageHeader } from 'react-bootstrap';

import ViewLink from '../containers/ViewLink';

export default function Post(props) {
  return (
    <div>
      <PageHeader>{props.user.name}</PageHeader>
      <ul>
        <li>
          <strong>Name: </strong>
          {props.user.name}
        </li>
        <li>
          <strong>Email: </strong>
          {props.user.email}
        </li>
        <ViewLink text="Report" root="newDenuncia"/>
      </ul>
      <ViewLink text="« Back" root="users" />
    </div>
  );
}
