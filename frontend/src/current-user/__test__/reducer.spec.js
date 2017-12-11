import reducer from '../reducer';
import { fetchUsersFulfilled } from '../../actions';
import { setCurrentUser } from '../actions';

const USER_1 = { id: 1 };
const USER_2 = { id: 2 };

describe('current-user reducer', () => {
  it('should start having null by default', () => {
    const initialState = reducer(undefined, {});
    expect(initialState).toBe(null);
  });

  describe('fetchUsersFulfilled', () => {
    it('should change the state the first time that users are received', () => {
      const state = reducer(null, fetchUsersFulfilled([USER_1, USER_2]));
      expect(state).toBe(USER_1.id);
    });

    it('should not change the state if current user is set', () => {
      const state = reducer(USER_1.id, fetchUsersFulfilled([USER_2]));
      expect(state).toBe(USER_1.id);
    });
  });

  describe('setCurrentUser', () => {
    it('should change when setCurrentUser', () => {
      const state = reducer(USER_1.id, setCurrentUser(USER_2.id));
      expect(state).toBe(USER_2.id);
    });
  });
});
