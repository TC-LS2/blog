import { combineEpics } from 'redux-observable';

import ajax from '../api';

import{
  CREATE_DENUNCIA,
  createDenunciaFulfilled, FETCH_DENUNCIES, fetchDenunciesFullfilled,
} from './actions';

export function createDenunciaEpic(action$,store){
  return action$.
    ofType(CREATE_DENUNCIA)
    .mergeMap(action =>
      ajax
        .post("/denuncies", action.denuncia)
        .map(result => createDenunciaFulfilled(result.response)),
    );
}

export function fetchDenunciesEpic(action$){

  return action$
    .ofType(FETCH_DENUNCIES)
    .switchMap(action =>
      ajax.get('/denuncies').map(result => fetchDenunciesFullfilled(result.response))
    );
}

export default combineEpics(
  createDenunciaEpic,
  fetchDenunciesEpic,
)
