import { combineEpics } from 'redux-observable';

import ajax from '../api';
import {
  CREATE_POST,
  createPostFulfilled,
  FETCH_POSTS,
  fetchPostsFulfilled,
} from './actions';
import { setView } from '../actions';

export function createPostEpic(action$, store) {
  return action$
    .ofType(CREATE_POST)
    .mergeMap(action =>
      ajax
        .post(`/posts`, action.post)
        .mergeMap(result => [
          createPostFulfilled(result.response),
          setView('post', result.response.id),
        ]),
    );
}

export function fetchPostsEpic(action$) {
  return action$
    .ofType(FETCH_POSTS)
    .switchMap(action =>
      ajax.get('/posts').map(result => fetchPostsFulfilled(result.response)),
    );
}

export default combineEpics(fetchPostsEpic, createPostEpic);
