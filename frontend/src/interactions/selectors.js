import { createSelector } from 'reselect';

export function getInteractions(state) {
  return state.interaction;
}

export const getCommentsList = createSelector([getInteractions()], interactions =>
  Object.values(interactions),
);

function getPostId(state, { postId }) {
  return postId;
}

export const getPostInteractionsList = createSelector(
  [getInteractionsList, getPostId],
  (interactionsList, postId) =>
    interactionsList.filter(interaction => interaction.postId === postId),
);
