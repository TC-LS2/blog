import { createSelector } from 'reselect';

export function getAllPertinences(state) {
  return state.pertinences;
}

export function getPertinences(state, { userId }) {
  return getPertinences(state)[userId] || {};
}

export const getPertinencesList = createSelector([getPertinences], pertinences =>
  Object.values(pertinences),
);
