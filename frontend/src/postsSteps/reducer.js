import {
  FETCH_POSTSTEPS_FULFILLED,
} from './actions';

export default function postSteps(state = {}, action) {
  switch (action.type) {
    case FETCH_POSTSTEPS_FULFILLED: {
      const newState = {};
      action.payload.forEach(postSteps => (newState[postSteps.id] = postSteps));
      return newState;
    }

    default:
      return state;
  }
}
