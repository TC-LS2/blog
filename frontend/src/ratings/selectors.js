import { createSelector } from 'reselect';

export function getRatings(state) {
  console.log(state);
  return state.ratings;
}

export const getRatingsList = createSelector([getRatings], ratings =>
  Object.values(ratings),
);
