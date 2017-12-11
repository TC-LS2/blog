import {
  createComment,
  CREATE_COMMENT,
  createCommentFulfilled,
  CREATE_COMMENT_FULFILLED,
  deleteComment,
  DELETE_COMMENT,
  deleteCommentFulfilled,
  DELETE_COMMENT_FULFILLED,
  fetchComments,
  FETCH_COMMENTS,
  fetchCommentsFulfilled,
  FETCH_COMMENTS_FULFILLED,
} from '../actions';

describe('createComment', () => {
  it('should create an action of type CREATE_COMMENT', () => {
    const action = createComment();
    expect(action).toMatchObject({
      type: CREATE_COMMENT,
    });
  });

  it('should have comment paramenter', () => {
    const COMMENT = { id: 2 };
    const action = createComment(COMMENT);
    expect(action).toMatchObject({
      comment: COMMENT,
    });
  });
});

describe('createCommentFulfilled', () => {
  it('should create an action of type CREATE_COMMENT_FULFILLED', () => {
    const action = createCommentFulfilled();
    expect(action).toMatchObject({
      type: CREATE_COMMENT_FULFILLED,
    });
  });

  it('should have payload paramenter', () => {
    const action = createCommentFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
describe('deleteComment', () => {
  it('should delete an action of type DELETE_COMMENT', () => {
    const action = deleteComment();
    expect(action).toMatchObject({
      type: DELETE_COMMENT,
    });
  });

  it('should have commentId paramenters', () => {
    const action = deleteComment(2);
    expect(action).toMatchObject({
      commentId: 2,
    });
  });
});

describe('deleteCommentFulfilled', () => {
  it('should delete an action of type DELETE_COMMENT_FULFILLED', () => {
    const action = deleteCommentFulfilled();
    expect(action).toMatchObject({
      type: DELETE_COMMENT_FULFILLED,
    });
  });

  it('should have payload paramenter', () => {
    const action = deleteCommentFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});

describe('fetchComments', () => {
  it('should create an action of type FETCH_COMMENTS', () => {
    const action = fetchComments();
    expect(action).toMatchObject({
      type: FETCH_COMMENTS,
    });
  });

  it('should have postId paramenter', () => {
    const action = fetchComments(3);
    expect(action).toMatchObject({
      postId: 3,
    });
  });
});

describe('fetchCommentsFulfilled', () => {
  it('should create an action of type FETCH_COMMENTS_FULFILLED', () => {
    const action = fetchCommentsFulfilled();
    expect(action).toMatchObject({
      type: FETCH_COMMENTS_FULFILLED,
    });
  });

  it('should have payload paramenter', () => {
    const action = fetchCommentsFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
