import React from 'react';

import CommentPostLabel from '../containers/PostStepsPostLabel';

export default function PostStepsWithPostList(props) {
  return (
    <ul>
      {props.comments.map(postSteps => (
        <li key={postSteps.id}>
          <h5 style={{ marginBottom: 0 }}>
            <PostStepsPostLabel postSteps={postSteps} />
          </h5>
          <p>
            {postSteps.text}
          </p>
        </li>
      ))}
    </ul>
  );
}
