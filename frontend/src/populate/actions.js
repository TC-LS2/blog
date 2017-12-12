export const DO_POPULATE = 'DO_POPULATE';
export function doPopulate() {
  return {
    type: DO_POPULATE,
  };
}

export const FETCH_POPULATES_FULFILLED = 'FETCH_POPULATES_FULFILLED';
export function fetchPopulatesFulfilled(payload) {
  return {
    type: FETCH_POPULATES_FULFILLED,
    payload,
  };
}
