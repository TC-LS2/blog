import {CREATE_DENUNCIA_FULFILLED, FETCH_DENUNCIES_FULFILLED} from "./actions";

export default function posts(state = {}, action) {
  switch (action.type) {
    case CREATE_DENUNCIA_FULFILLED: {
      const denuncia = action.payload;
      return {
        ...state,
        [denuncia.id]: denuncia,
      };
    }

    case FETCH_DENUNCIES_FULFILLED: {
      const newState = {};
      action.payload.forEach(denuncia => {
        newState[denuncia.id] = denuncia;
      });
      return newState;
    }
    default:
      return state;
  }
}
