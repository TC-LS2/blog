import {
  FETCH_RATINGS,
  FETCH_RATINGS_FULFILLED,
} from './actions';

export default function comments(state = {}, action) {
  switch (action.type) {
    case FETCH_RATINGS: {
      console.log("FETCH_RATINGS")
      return {
        ...state,
        [action.payload.id]: action.payload,
      };
    }

    case FETCH_RATINGS_FULFILLED: {
      console.log("FETCH_RATINGS_FULFILLED")
      const newState = {};
      action.payload.forEach(rating => (newState[rating.id] = rating));
      return newState;
    }

    default:
      console.log("DEFAULT")
      return state;
  }
}
