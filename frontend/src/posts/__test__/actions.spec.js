import {
  createPost,
  CREATE_POST,
  createPostFulfilled,
  CREATE_POST_FULFILLED,
  fetchPosts,
  FETCH_POSTS,
  fetchPostsFulfilled,
  FETCH_POSTS_FULFILLED,
} from '../actions';

describe('createPost', () => {
  it('should create an action of type CREATE_POST', () => {
    const action = createPost();
    expect(action).toMatchObject({
      type: CREATE_POST,
    });
  });

  it('should have the field post', () => {
    const POST = {};
    const action = createPost(POST);
    expect(action).toMatchObject({
      post: POST,
    });
  });
});

describe('createPostFulfilled', () => {
  it('should create an action of type CREATE_POST_FULFILLED', () => {
    const action = createPostFulfilled();
    expect(action).toMatchObject({
      type: CREATE_POST_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = createPostFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});

describe('fetchPosts', () => {
  it('should create an action of type FETCH_POSTS', () => {
    const action = fetchPosts();
    expect(action).toMatchObject({
      type: FETCH_POSTS,
    });
  });
});

describe('fetchPostsFulfilled', () => {
  it('should create an action of type FETCH_POSTS_FULFILLED', () => {
    const action = fetchPostsFulfilled();
    expect(action).toMatchObject({
      type: FETCH_POSTS_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = fetchPostsFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
