export const CREATE_INTERACTION = 'CREATE_INTERACTION';
export function createInteraction(interaction) {
  return {
    type: CREATE_INTERACTION,
    interaction,
  };
}

export const CREATE_INTERACTION_FULFILLED = 'CREATE_POST_FULFILLED';
export function createInteractionFulfilled(payload) {
  return {
    type: CREATE_INTERACTION_FULFILLED,
    payload,
  };
}
