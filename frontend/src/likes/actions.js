export const SHOW_LIKES = 'SHOW_LIKES';
export function showLikes(payload) {
  return {
    type: SHOW_LIKES,
    payload
  };
}

