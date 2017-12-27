import { combineEpics } from 'redux-observable';

import ajax from '../api';
import {
  CREATE_INTERACTION,
  createInteractionFulfilled,
} from './actions';
import { setView } from '../actions';

export function createInteractionEpic(action$, store) {
  return action$
    .ofType(CREATE_INTERACTION)
    .mergeMap(action =>
      ajax
        .post(`/likes`, action.post)
        .mergeMap(result => [
          createInteractionFulfilled(result.response),
          setView('interaction', result.response.id),
        ]),
    );
}

export default combineEpics(createInteractionEpic);
