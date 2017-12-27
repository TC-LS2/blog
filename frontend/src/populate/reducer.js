import { DO_POPULATE, FETCH_POPULATES_FULFILLED } from './actions';

export default function populates(state = {}, action) {
    switch (action.type) {
        case DO_POPULATE: {
            return state;
        }
        case FETCH_POPULATES_FULFILLED: {
            const newState = {};
            console.log(action);
            action.payload.forEach(populate => {
                newState[populate.id] = populate;
            });
            return newState;
        }
        default:
            return state;
    }
}