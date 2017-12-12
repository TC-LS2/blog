


export const FETCH_PERTINENCES = 'FETCH_PERTINENCES';
export function fetchPertinences() {
  return {
    type: FETCH_PERTINENCES,
  };
}

export const FETCH_PERTINENCES_FULFILLED = 'FETCH_PERTINENCES_FULFILLED';
export function fetchPertinencesFulfilled(payload) {
  return {
    type: FETCH_PERTINENCES_FULFILLED,
    payload,
  };
}
