import { fetchUsersFulfilled } from '../actions';
import reducer from '../reducer';

describe('users reducer', () => {
  it('should create an empty object as initial state', () => {
    const initialState = reducer(undefined, {});
    expect(initialState).toMatchObject({});
  });

  const USER_1 = { id: 1, name: 'user 1', email: 'user_1@example.com' };
  const USER_2 = { id: 2, name: 'user 2', email: 'user_2@example.com' };
  const USER_3 = { id: 3, name: 'user 3', email: 'user_3@example.com' };
  describe('fetchUsersFulfilled', () => {
    it('should add elements', () => {
      const state = reducer(
        undefined,
        fetchUsersFulfilled([USER_1, USER_2, USER_3]),
      );
      expect(state).toMatchObject({
        1: USER_1,
        2: USER_2,
        3: USER_3,
      });
    });

    it('should replace previous elements', () => {
      let state = reducer(undefined, fetchUsersFulfilled([USER_1]));
      state = reducer(state, fetchUsersFulfilled([USER_2]));

      expect(state).toEqual({ 2: USER_2 });
    });
  });
});
