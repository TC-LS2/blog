import { combineEpics } from 'redux-observable';

import ajax from '../api';
import {
  CREATE_REPORT, createReportFulfilled,
  FETCH_REPORTS, fetchReportsFulfilled
} from './actions';
import { setView } from '../actions';

export function createReportEpic(action$, store) {
  return action$
    .ofType(CREATE_REPORT)
    .mergeMap(action =>
      ajax
        .post(`/reports`, action.report)
        .mergeMap(result => [
          createReportFulfilled(result.response),
          setView('report', result.response.id),
        ]),
    );
}

export function fetchReportsEpic(action$) {
  return action$
    .ofType(FETCH_REPORTS)
    .switchMap(action =>
      ajax.get('/reports').map(result => fetchReportsFulfilled(result.response)),
    );
}

export default combineEpics(createReportEpic, fetchReportsEpic);
