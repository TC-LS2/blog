import React, { Component } from 'react';
import { Button, ControlLabel, FormControl, FormGroup } from 'react-bootstrap';

export default class PostInput extends Component {
  constructor(props) {
    super(props);

    this.state = { title: '', body: '' };
  }

  disabled() {
    const { title, body } = this.state;
    return !(title && body);
  }

  onSubmit = e => {
    e.preventDefault();
    if (this.disabled()) return;

    this.props.onSubmit({
      ...this.state,
      authorId: this.props.authorId,
    });
    this.setState({ title: '', body: '' });
  };

  onChange = e => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <form onSubmit={this.onSubmit}>
        <FormGroup controlId="postTitle">
          <ControlLabel>Title</ControlLabel>
          <FormControl
            type="text"
            name="title"
            placeholder="Your post title"
            value={this.state.title}
            onChange={this.onChange}
          />
        </FormGroup>

        <FormGroup controlId="postBody">
          <ControlLabel>Body</ControlLabel>
          <FormControl
            componentClass="textarea"
            name="body"
            placeholder="Your amazing story"
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
