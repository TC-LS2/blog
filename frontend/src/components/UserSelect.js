import React, { Component } from 'react';

export default class UserSelect extends Component {
  onChange = e => {
    const id = +e.target.value;
    const selectedUser = this.props.users.find(user => user.id === id);
    this.props.onChange(selectedUser || {});
  };

  render() {
    const user = this.props.user;
    const users = this.props.users;
    const className = this.props.className;

    return (
      <select value={user.id} onChange={this.onChange} className={className}>
        <option value="">—</option>
        {users.map(user => (
          <option value={user.id} key={user.id}>
            {user.name}
          </option>
        ))}
      </select>
    );
  }
}
