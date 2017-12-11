import React from 'react';

export default function UserLabel(props) {
  return (
    <span>
      {props.user.name} ({props.user.email})
    </span>
  );
}
