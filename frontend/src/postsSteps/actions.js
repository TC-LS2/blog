export const FETCH_POSTSTEPS = 'FETCH_POSTSTEPS';
export function fetchPostSteps(postId) {
  return {
    type: FETCH_POSTSTEPS,
    postId,
  };
}

export const FETCH_POSTSTEPS_FULFILLED = 'FETCH_POSTSTEPS_FULFILLED';
export function fetchPostStepsFulfilled(payload) {
  return {
    type: FETCH_POSTSTEPS_FULFILLED,
    payload,
  };
}
