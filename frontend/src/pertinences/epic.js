import { combineEpics } from 'redux-observable';

import ajax from '../api';
import {
  FETCH_PERTINENCES,
  fetchPertinencesFulfilled,
} from './actions';
import { setView } from '../actions';

export function fetchPertinencesEpic(action$) {
  return action$
    .ofType(FETCH_PERTINENCES)
    .switchMap(action =>
      ajax.get(`/pertinences`).map(result => fetchPertinencesFulfilled(result.response)),
    );
}

export default combineEpics(fetchPertinencesEpic);
