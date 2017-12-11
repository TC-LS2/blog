import {
  CREATE_COMMENT_FULFILLED,
  DELETE_COMMENT_FULFILLED,
  FETCH_COMMENTS_FULFILLED,
} from './actions';

export default function comments(state = {}, action) {
  switch (action.type) {
    case CREATE_COMMENT_FULFILLED: {
      return {
        ...state,
        [action.payload.id]: action.payload,
      };
    }

    case DELETE_COMMENT_FULFILLED: {
      const newState = { ...state };
      delete newState[action.payload.id];
      return newState;
    }

    case FETCH_COMMENTS_FULFILLED: {
      const newState = {};
      action.payload.forEach(comment => (newState[comment.id] = comment));
      return newState;
    }

    default:
      return state;
  }
}
