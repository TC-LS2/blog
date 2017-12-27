import {
  createInteraction,
  CREATE_INTERACTION,
  createInteractionFulfilled,
  CREATE_INTERACTION_FULFILLED,
  fetchPosts,
  FETCH_POSTS,
  fetchPostsFulfilled,
  FETCH_POSTS_FULFILLED,
} from '../actions';

describe('createInteraction', () => {
  it('should create an action of type CREATE_INTERACTION', () => {
    const action = createInteraction();
    expect(action).toMatchObject({
      type: CREATE_INTERACTION,
    });
  });

  it('should have the field post', () => {
    const VALUE = {};
    const action = createInteraction(VALUE);
    expect(action).toMatchObject({
      interaction: INTERACTION,
    });
  });
});

describe('createPostFulfilled', () => {
  it('should create an action of type CREATE_INTERACTION_FULFILLED', () => {
    const action = createInteractionFulfilled();
    expect(action).toMatchObject({
      type: CREATE_INTERACTION_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = createInteractionFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});


