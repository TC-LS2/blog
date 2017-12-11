import React from 'react';
import { Media } from 'react-bootstrap';

import CommentCommenterLabel from '../containers/CommentCommenterLabel';

export default function CommentsList(props) {
  return (
    <div>
      {props.comments.map(comment => (
        <Media key={comment.id}>
          <Media.Body>
            <Media.Heading>
              <CommentCommenterLabel comment={comment} /> says:
            </Media.Heading>
            <p>{comment.body}</p>
          </Media.Body>
        </Media>
      ))}
    </div>
  );
}
