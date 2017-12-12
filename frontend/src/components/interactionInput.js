import React, { Component } from 'react';
import { Button, ControlLabel, FormControl, FormGroup } from 'react-bootstrap';

export default class PostInput extends Component {
  constructor(props) {
    super(props);

    this.state = { value: '' };
  }

  disabled() {
    const { value } = this.state;
    return !value;
  }

  onSubmit = e => {
    e.preventDefault();
    if (this.disabled()) return;

    this.props.onSubmit({
      ...this.state,
      likerId: this.props.likerId,
      postId: this.props.postId,
    });
    this.setState({ value: true });
  };

  onChange = e => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <form onSubmit={this.onSubmit}>
        <FormGroup controlId="postBody">
          <ControlLabel>Your comment:</ControlLabel>
          <FormControl
            componentClass="textarea"
            name="body"
            placeholder="What do you think about this article?"
            value={this.state.body}
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
