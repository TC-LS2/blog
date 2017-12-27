import { combineEpics } from 'redux-observable';

import ajax from '../api';

import {
  FETCH_POSTSTEPS,
  fetchPostStepsFulfilled,
} from './actions';

export function fetchPostPostStepsEpic(action$) {
  return action$
    .ofType(FETCH_POSTSTEPS)
    .mergeMap(action =>
      ajax
        .get(`/posts/${action.postId}/postSteps`)
        .map(result => fetchCommentsFulfilled(result.response)),
  );
}

export default combineEpics(
  fetchPostPostStepsEpic,
);
