export const CREATE_POST = 'CREATE_POST';
export function createPost(post) {
  return {
    type: CREATE_POST,
    post,
  };
}

export const CREATE_POST_FULFILLED = 'CREATE_POST_FULFILLED';
export function createPostFulfilled(payload) {
  return {
    type: CREATE_POST_FULFILLED,
    payload,
  };
}

export const FETCH_POSTS = 'FETCH_POSTS';
export function fetchPosts() {
  return {
    type: FETCH_POSTS,
  };
}

export const FETCH_POSTS_FULFILLED = 'FETCH_POSTS_FULFILLED';
export function fetchPostsFulfilled(payload) {
  return {
    type: FETCH_POSTS_FULFILLED,
    payload,
  };
}
