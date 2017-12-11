export const CREATE_COMMENT = 'CREATE_COMMENT';
export function createComment(comment, post) {
  return {
    type: CREATE_COMMENT,
    post,
    comment,
  };
}

export const CREATE_COMMENT_FULFILLED = 'CREATE_COMMENT_FULFILLED';
export function createCommentFulfilled(payload) {
  return {
    type: CREATE_COMMENT_FULFILLED,
    payload,
  };
}

export const DELETE_COMMENT = 'DELETE_COMMENT';
export function deleteComment(commentId) {
  return {
    type: DELETE_COMMENT,
    commentId,
  };
}

export const DELETE_COMMENT_FULFILLED = 'DELETE_COMMENT_FULFILLED';
export function deleteCommentFulfilled(payload) {
  return {
    type: DELETE_COMMENT_FULFILLED,
    payload,
  };
}

export const FETCH_COMMENTS = 'FETCH_COMMENTS';
export function fetchComments(postId) {
  return {
    type: FETCH_COMMENTS,
    postId,
  };
}

export const FETCH_COMMENTS_FULFILLED = 'FETCH_COMMENTS_FULFILLED';
export function fetchCommentsFulfilled(payload) {
  return {
    type: FETCH_COMMENTS_FULFILLED,
    payload,
  };
}
