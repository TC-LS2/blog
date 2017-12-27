import { createSelector } from 'reselect';

export function getUserLikes(state, user) {
  return state.likes.filter(like => like.giverId === user.id);
}

export const getLikesList = createSelector([getUserLikes], likes =>
  Object.values(likes).sort((a, b) => b.id - a.id),
);


