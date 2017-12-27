import { FETCH_LIKES_FULFILLED } from './actions';

export default function users(state = {}, action) {
  switch (action.type) {
    case FETCH_LIKES_FULFILLED: {
      const newState = {};
      action.payload.forEach(like => {
        newState[like.id] = like;
      });
      return newState;
    }

    default:
      return state;
  }
}
