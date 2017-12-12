import { FETCH_PERTINENCES_FULFILLED } from './actions';

export default function pertinences(state = {}, action) {
  switch (action.type) {
    case FETCH_PERTINENCES_FULFILLED: {
      const newState = {};
      action.payload.forEach(pertinensa => {
        newState[pertinensa.id] = pertinensa;
      });
      return newState;
    }
    default:
      return state;
  }
}
