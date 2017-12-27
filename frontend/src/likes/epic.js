import { combineEpics } from 'redux-observable';
import api from '../api';

export function newLikeEpic(action$, store) {
    return action$
        .ofType(NEW_LIKE)
        .mergeMap(action =>
            ajax
                .post(`/likes`, action.like)
                .mergeMap(result => [
                    fetchLikesFulfilled(result.response)
                ]),
    );
}

export function newDisLikeEpic(action$, store) {
    return action$
        .ofType(NEW_DISLIKE)
        .mergeMap(action =>
            ajax
                .post(`/likes`, action.like)
                .mergeMap(result => [
                    fetchLikesFulfilled(result.response)
                ]),
    );
}