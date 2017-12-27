import React from 'react';
import { Media } from 'react-bootstrap';
import Boto from '../containers/Boto';
import { connect } from 'react-redux';

import CommentCommenterLabel from '../containers/CommentCommenterLabel';

const onLikeClick = () => ({

});

const BtnLike = connect(
  state => ({
    value: 'Like',
  }),
  {
    onClick: onLikeClick,
  },
)(Boto);

const onDislikeClick = () => ({

});

const BtnDislike = connect(
  state => ({
    value: 'Dislike',
  }),
  {
    onClick: onDislikeClick,
  },
)(Boto);

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
            <p>Likes: {comment.likes} </p>
            <p>Dislikes: {comment.dislikes} </p>
            <BtnLike />
            <br />
            <BtnDislike />
          </Media.Body>
        </Media>
      ))}
    </div>
  );
}
