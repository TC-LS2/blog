import React from 'react';

import CommentPostLabel from '../containers/CommentPostLabel';

export default function CommentsWithPostList(props) {
  return (
    <ul>
      {props.comments.map(comment => (
        <li key={comment.id}>
          <h5 style={{ marginBottom: 0 }}>
            <CommentPostLabel comment={comment} />
          </h5>
          <p>
            {comment.body}
            &nbsp;<span
              style={{ cursor: 'pointer' }}
              onClick={() => props.onDelete(comment.id)}
              role="img"
              aria-label="delete"
            >
              🗑
            </span>
          </p>
        </li>
      ))}
    </ul>
  );
}
