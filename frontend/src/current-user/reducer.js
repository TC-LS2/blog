import { FETCH_USERS_FULFILLED } from '../actions';
import { SET_CURRENT_USER } from './actions';

export default function currentUserReducer(state = null, action) {
  switch (action.type) {
    case FETCH_USERS_FULFILLED: {
      if (state == null) return action.payload[0].id;
      return state;
    }

    case SET_CURRENT_USER: {
      return action.currentUser;
    }

    default:
      return state;
  }
}
