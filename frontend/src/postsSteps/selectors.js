import { createSelector } from 'reselect';

export function getPostSteps(state) {
  return state.postSteps;
}

export const getStepsList = createSelector([getPostSteps], postSteps =>
  Object.values(postSteps),
);

function getPostId(state, { postId }) {
  return postId;
}

export const getPostStepsList = createSelector(
  [getStepsList, getPostId],
  (postStepsList, postId) =>
    postStepsList.filter(postSteps => postSteps.postId === postId),
);
