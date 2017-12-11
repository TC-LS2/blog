import { combineEpics } from 'redux-observable';

import ajax from '../api';

import {
  CREATE_COMMENT,
  createCommentFulfilled,
  DELETE_COMMENT,
  deleteCommentFulfilled,
  FETCH_COMMENTS,
  fetchCommentsFulfilled,
} from './actions';

export function createPostCommentEpic(action$, store) {
  return action$
    .ofType(CREATE_COMMENT)
    .mergeMap(action =>
      ajax
        .post(`/comments`, action.comment)
        .map(result => createCommentFulfilled(result.response)),
    );
}

export function deletePostCommentEpic(action$, store) {
  return action$
    .ofType(DELETE_COMMENT)
    .mergeMap(action =>
      ajax
        .delete(`/comments/${action.commentId}`)
        .map(result => deleteCommentFulfilled(result.response)),
    );
}

export function fetchPostCommentsEpic(action$) {
  return action$
    .ofType(FETCH_COMMENTS)
    .mergeMap(action =>
      ajax
        .get(`/posts/${action.postId}/comments`)
        .map(result => fetchCommentsFulfilled(result.response)),
    );
}

export default combineEpics(
  createPostCommentEpic,
  deletePostCommentEpic,
  fetchPostCommentsEpic,
);
