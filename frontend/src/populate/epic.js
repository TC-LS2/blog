import ajax from '../api';

import { DO_POPULATE } from './actions';
import {
  fetchCommentsFulfilled,
  fetchPostsFulfilled,
  fetchUsersFulfilled,
  fetchDenunciesFullfilled,
} from '../actions';

export function doPopulateEpic(action$) {
  return action$
    .ofType(DO_POPULATE)
    .switchMap(action =>
      ajax
        .get('/populate')
        .mergeMap(result => [
          fetchCommentsFulfilled(result.response.comments),
          fetchPostsFulfilled(result.response.posts),
          fetchUsersFulfilled(result.response.users),
          fetchDenunciesFullfilled(result.response.denuncies),
        ]),
    );
}

export default doPopulateEpic;
