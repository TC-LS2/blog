import React from 'react';

import { Label } from 'react-bootstrap';

export default function PopulateList(props) {
    return (
        <ul>
            {props.populates.map(populate => (
                <div key={populate.id}>
                    <Label
                        bsStyle="primary">
                        Rating: {populate.rating}
                    </Label>,
                    <Label
                        bsStyle="primary">
                        Comment: {populate.commentId}
                    </Label>,
                    <Label
                        bsStyle="primary">
                        User: {populate.userId}
                    </Label>
                </div>
            ))}
        </ul>
    );
}