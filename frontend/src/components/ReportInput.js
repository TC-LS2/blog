import React, { Component } from 'react';
import { Button, ControlLabel, FormControl, FormGroup } from 'react-bootstrap';

export default class ReportInput extends Component {
  constructor(props) {
    super(props);

    this.state = { reason: '' };
  }

  disabled() {
    const { reason } = this.state;
    return !(reason );
  }

  onSubmit = e => {
    e.preventDefault();
    if (this.disabled()) return;

    this.props.onSubmit({
      ...this.state,
      authorId: this.props.authorId,
    });
    this.setState({ reason: '' });
  };

  onChange = e => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <form onSubmit={this.onSubmit}>
        <FormGroup controlId="reason">
          <ControlLabel>Reason to report</ControlLabel>
          <FormControl
            type="text"
            name="reason"
            placeholder="Your reason"
            value={this.state.reason}
            onChange={this.onChange}
          />
        </FormGroup>

        <Button type="submit" disabled={this.disabled()}>
          Submit
        </Button>
      </form>
    );
  }
}
