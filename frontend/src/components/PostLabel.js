import React from 'react';

import PostAuthorLabel from '../containers/PostAuthorLabel';
import ViewLink from '../containers/ViewLink';

export default function PostLabel(props) {
  return (
    <span>
      <ViewLink text={props.post.title} root="post" id={props.post.id} />
      <small>
        {' — '} <PostAuthorLabel post={props.post} />
      </small>
    </span>
  );
}
