import {
  fetchUsers,
  FETCH_USERS,
  fetchUsersFulfilled,
  FETCH_USERS_FULFILLED,
} from '../actions';

describe('fetchUsers', () => {
  it('should create an action of type FETCH_USERS', () => {
    const action = fetchUsers();
    expect(action).toMatchObject({
      type: FETCH_USERS,
    });
  });
});

describe('fetchUsersFulfilled', () => {
  it('should create an action of type FETCH_USERS_FULFILLED', () => {
    const action = fetchUsersFulfilled();
    expect(action).toMatchObject({
      type: FETCH_USERS_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = fetchUsersFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
