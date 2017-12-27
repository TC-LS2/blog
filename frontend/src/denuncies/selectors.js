import {createSelector} from 'reselect';

export function getDenuncies(state) {
  return state.denuncies;
}

export const getDenunciesList = createSelector([getDenuncies], denuncies =>
  Object.values(denuncies),
);

