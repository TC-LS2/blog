import { createSelector } from 'reselect';

export function getUsers(state) {
  return state.users;
}

export function getUser(state, { userId }) {
  return getUsers(state)[userId] || {};
}

export const getUsersList = createSelector([getUsers], users =>
  Object.values(users),
);
