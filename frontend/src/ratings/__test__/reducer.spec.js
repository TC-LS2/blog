import {createPostFulfilled, fetchPostsFulfilled, fetchRatingsFulfilled} from '../actions';
import reducer from '../reducer';

describe('ratings reducer', () => {
  it('should create an empty object as initial state', () => {
    const initialState = reducer(undefined, {});
    expect(initialState).toMatchObject({});
  });

  const RATING_1 = { id: 1, title: 'post 1', authorId: 1 };
  const RATING_2 = { id: 2, title: 'post 2', authorId: 1 };
  const RATING_3 = { id: 3, title: 'post 3', authorId: 1 };

  describe('createRatingFulfilled', () => {
    it('should add post after createRatingFulfilled', () => {
      let state = reducer({ 1: RATING_1 }, createPostFulfilled(RATING_2));

      expect(state).toEqual({ 1: RATING_1, 2: RATING_2 });
    });
  });

  describe('fetchRatingFulfilled', () => {
    it('should add received elements', () => {
      const state = reducer(
        undefined,
        fetchRatingsFulfilled([RATING_1, RATING_2, RATING_3]),
      );
      expect(state).toMatchObject({
        1: RATING_1,
        2: RATING_2,
        3: RATING_3,
      });
    });

    it('should replace previous received elements', () => {
      let state = reducer(undefined, fetchRatingsFulfilled([RATING_1]));
      state = reducer(state, fetchPostsFulfilled([RATING_2]));

      expect(state).toEqual({ 2: RATING_2 });
    });
  });
});
