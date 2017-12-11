import {
  getCurrentUser,
  getCurrentUserId,
  getCurrentUserCommentsList,
  getCurrentUserPostsList,
} from '../selectors';

const USER_1 = { id: 1 };
const POST_1 = { id: 1, authorId: 1 };
const POST_2 = { id: 2, authorId: 2 };
const POST_3 = { id: 3, authorId: 1 };
const COMMENT_1 = { postId: 1, commenterId: 1 };
const COMMENT_2 = { postId: 2, commenterId: 2 };
const COMMENT_3 = { postId: 3, commenterId: 1 };

const STATE = {
  currentUser: 1,
  comments: {
    1: COMMENT_1,
    2: COMMENT_2,
    3: COMMENT_3,
  },
  posts: {
    1: POST_1,
    2: POST_2,
    3: POST_3,
  },
  users: {
    1: USER_1,
  },
};

describe('getCurrentUser', () => {
  it('should return the user instance of the current user', () => {
    const user = getCurrentUser(STATE);
    expect(user).toBe(USER_1);
  });

  it('should return an empty object if no current user', () => {
    const user = getCurrentUser({
      ...STATE,
      currentUser: 'UNEXISTING',
    });
    expect(user).toEqual({});
  });
});

describe('getCurrentUserId', () => {
  it('should return the user instance of the current user', () => {
    const userId = getCurrentUserId(STATE);
    expect(userId).toBe(USER_1.id);
  });
});

describe('getCurrentUserCommentsList', () => {
  it('should return the list of the posts belonging to that user', () => {
    const posts = getCurrentUserCommentsList(STATE);
    expect(posts).toEqual([COMMENT_1, COMMENT_3]);
  });

  it('should return twice the same instance if nothing changes', () => {
    const posts1 = getCurrentUserCommentsList(STATE);
    const posts2 = getCurrentUserCommentsList(STATE);

    expect(posts1).toBe(posts2);
  });

  it('should return an empty list if the user is unexisting', () => {
    const user = getCurrentUserCommentsList({
      ...STATE,
      currentUser: 'UNEXISTING',
    });
    expect(user).toEqual([]);
  });
});

describe('getCurrentUserPostsList', () => {
  it('should return the list of the posts belonging to that user', () => {
    const posts = getCurrentUserPostsList(STATE);
    expect(posts).toEqual([POST_3, POST_1]);
  });

  it('should return twice the same instance if nothing changes', () => {
    const posts1 = getCurrentUserPostsList(STATE);
    const posts2 = getCurrentUserPostsList(STATE);

    expect(posts1).toBe(posts2);
  });

  it('should return an empty list if the user is unexisting', () => {
    const user = getCurrentUserPostsList({
      ...STATE,
      currentUser: 'UNEXISTING',
    });
    expect(user).toEqual([]);
  });
});
