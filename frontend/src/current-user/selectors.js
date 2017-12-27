import { createSelector } from 'reselect';
import { getPostsList, getUser, getCommentsList } from '../selectors';

export function getCurrentUser(state) {
  return getUser(state, { userId: state.currentUser });
}

export function getCurrentUserId(state) {
  return state.currentUser;
}

export const getCurrentUserCommentsList = createSelector(
  [getCommentsList, getCurrentUserId],
  (commentsList, currentUserId) =>
    commentsList.filter(comment => comment.commenterId === currentUserId),
);

export const getCurrentUserPostsList = createSelector(
  [getPostsList, getCurrentUserId],
  (postsList, currentUserId) =>
    postsList.filter(post => post.authorId === currentUserId),
);

export const getInteractionList = createSelector(
  [get]
)
