import React from 'react';
import { Media } from 'react-bootstrap';

import CommentCommenterLabel from '../containers/CommentCommenterLabel';

export default function like(props) {
    return (
        <div>
            <BotoLike />
            <BotoDisLike />
        </div>
    );
}