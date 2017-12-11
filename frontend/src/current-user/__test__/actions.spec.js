import { setCurrentUser, SET_CURRENT_USER } from '../actions';

describe('setCurrentUser', () => {
  it('should create an action of type SET_CURRENT_USER', () => {
    const action = setCurrentUser();
    expect(action).toMatchObject({
      type: SET_CURRENT_USER,
    });
  });

  it('should accept the current user id as parameter', () => {
    const action = setCurrentUser(1);
    expect(action).toMatchObject({
      currentUser: 1,
    });
  });
});
