export const CREATE_RATING = 'CREATE_RATING';
export function createRating(rating, post, user) {
  return {
    type: CREATE_RATING,
    rating,
    post,
    user,
  };
}

export const CREATE_RATING_FULFILLED = 'CREATE_RATING_FULFILLED';
export function createRatingFulfilled(payload) {
  return {
    type: CREATE_RATING_FULFILLED,
    payload,
  };
}

export const FETCH_RATINGS = 'FETCH_RATINGS';
export function fetchRatings(userId) {
  return {
    type: FETCH_RATINGS,
    userId,
  };
}

export const FETCH_RATINGS_FULFILLED = 'FETCH_RATINGS_FULFILLED';
export function fetchRatingsFulfilled(payload) {
  return {
    type: FETCH_RATINGS_FULFILLED,
    payload,
  };
}

