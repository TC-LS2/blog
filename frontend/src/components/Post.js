import React from 'react';
import { PageHeader } from 'react-bootstrap';

import NewPostComment from '../containers/NewPostComment';
import PostCommentsList from '../containers/PostCommentsList';
import PostStepsList from '../containers/PostStepsList';
import PostAuthorLabel from '../containers/PostAuthorLabel';
import ViewLink from '../containers/ViewLink';

export default function Post(props) {
  return (
    <div>
      <PageHeader>
        {props.post.title}
        <small>
          {' by '}
          <PostAuthorLabel post={props.post} />
        </small>
      </PageHeader>
      {props.post.body}
      <br />
      <br />
      <ViewLink text="« Back" root="posts" />
      <br />
      <br />
      <PostStepsList postId={props.post.id} />
      <PostCommentsList postId={props.post.id} />
      <NewPostComment postId={props.post.id} />
    </div>
  );
}
