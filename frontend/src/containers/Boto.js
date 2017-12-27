import React, { Component } from 'react';

export default class Boto extends Component {
    onClick = ev => this.props.onClick(ev.target.value);
    render() {
        const { value } = this.props;
        return (
            <button
                disabled={!this.props.enabled}
                onClick={this.onClick}
                className={this.props.className}
            >
                {value}
            </button>
        );
    }
}