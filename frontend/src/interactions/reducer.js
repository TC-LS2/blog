import { CREATE_INTERACTION_FULFILLED, FETCH_INTERACTION_FULFILLED } from './actions';

export default function posts(state = {}, action) {
  switch (action.type) {
    case CREATE_INTERACTION_FULFILLED: {
      const interaction = action.payload;
      return {
        ...state,
        [interaction.id]: interaction,
      };
    }

    case FETCH_INTERACTION_FULFILLED: {
      const newState = {};
      action.payload.forEach(interaction => {
        newState[interaction.id] = interaction;
      });
      return newState;
    }
    default:
      return state;
  }
}
