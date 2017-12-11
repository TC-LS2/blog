import { FETCH_USERS_FULFILLED } from './actions';

export default function users(state = {}, action) {
  switch (action.type) {
    case FETCH_USERS_FULFILLED: {
      const newState = {};
      action.payload.forEach(user => {
        newState[user.id] = user;
      });
      return newState;
    }

    default:
      return state;
  }
}
