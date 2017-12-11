export const FETCH_USERS = 'FETCH_USERS';
export function fetchUsers() {
  return {
    type: FETCH_USERS,
  };
}

export const FETCH_USERS_FULFILLED = 'FETCH_USERS_FULFILLED';
export function fetchUsersFulfilled(payload) {
  return {
    type: FETCH_USERS_FULFILLED,
    payload,
  };
}
