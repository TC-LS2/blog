export const FETCH_LIKES = 'FETCH_LIKES';
export function fetchLikes() {
  return {
    type: FETCH_LIKES,
  };
}

export const FETCH_LIKES_FULFILLED = 'FETCH_LIKES_FULFILLED';
export function fetchLikesFulfilled(payload) {
  return {
    type: FETCH_LIKES_FULFILLED,
    payload,
  };
}
