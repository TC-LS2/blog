import React from 'react';

import ViewLink from '../containers/ViewLink';

export default function CommentsList(props) {
  return (
    <ul>
      {props.users.map(user => (
        <li key={user.id}>
          {user !== props.currentUser && (
            <span
              style={{ cursor: 'pointer' }}
              onClick={() => props.setCurrentUser(user.id)}
              role="img"
              aria-label="delete"
            >
              🛎️ &nbsp;
            </span>
          )}
          <ViewLink text={`${user.name} »`} root="user" id={user.id} />
          <br />
        </li>
      ))}
    </ul>
  );
}
