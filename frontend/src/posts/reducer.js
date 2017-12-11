import { CREATE_POST_FULFILLED, FETCH_POSTS_FULFILLED } from './actions';

export default function posts(state = {}, action) {
  switch (action.type) {
    case CREATE_POST_FULFILLED: {
      const post = action.payload;
      return {
        ...state,
        [post.id]: post,
      };
    }

    case FETCH_POSTS_FULFILLED: {
      const newState = {};
      action.payload.forEach(post => {
        newState[post.id] = post;
      });
      return newState;
    }
    default:
      return state;
  }
}
