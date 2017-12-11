import React from 'react';

import PostAuthorLabel from '../containers/PostAuthorLabel';
import ViewLink from '../containers/ViewLink';

export default function ListPosts(props) {
  return (
    <ul>
      {props.posts.map(post => (
        <div key={post.id}>
          <h3 style={{ marginBottom: 0 }}>
            <ViewLink text={post.title} root="post" id={post.id} />
          </h3>
          {' by '}
          <PostAuthorLabel post={post} />
        </div>
      ))}
    </ul>
  );
}
