import { combineEpics } from 'redux-observable';

import ajax from '../api';
import { FETCH_USERS, fetchUsersFulfilled } from './actions';

export function fetchUsersEpic(action$) {
  return action$
    .ofType(FETCH_USERS)
    .switchMap(action =>
      ajax.get('/users').map(result => fetchUsersFulfilled(result.response)),
    );
}

export default combineEpics(fetchUsersEpic);
