import { combineEpics } from 'redux-observable';

import ajax from '../api';

import {
  CREATE_RATING,
  createRatingFulfilled,
  FETCH_RATINGS,
  fetchRatingsFulfilled,
} from './actions';

export function createRatingEpic(action$, store) {
  return action$
    .ofType(CREATE_RATING)
    .mergeMap(action =>
      ajax
        .post(`/ratings`, action.comment)
        .map(result => createRatingFulfilled(result.response)),
    );
}

export function fetchRatingsEpic(action$) {
  console.log("ratingsEpic")
  return action$
    .ofType(FETCH_RATINGS)
    .mergeMap(action =>
      ajax
        .get(`/ratings/${action.userId}`)
        .map(result => fetchRatingsFulfilled(result.response)),
    );
}

export default combineEpics(
  createRatingEpic,
  fetchRatingsEpic,
);
