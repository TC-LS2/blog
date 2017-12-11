import { getUsersList, getUser } from '../selectors';

const USER_1 = { id: 1, name: 'user 1', email: 'user_1@example.com' };
const USER_2 = { id: 2, name: 'user 2', email: 'user_2@example.com' };
const USER_3 = { id: 3, name: 'user 3', email: 'user_3@example.com' };
const STATE = {
  users: {
    1: USER_1,
    2: USER_2,
    3: USER_3,
  },
};

describe('getUser', () => {
  it('should return the requested user', () => {
    const user = getUser(STATE, { userId: 1 });

    expect(user).toBe(USER_1);
  });

  it('should return an empty object if user does not exists', () => {
    const user = getUser(STATE, { userId: 'UNEXISTING' });

    expect(user).toMatchObject({});
  });
});

describe('getUsersList', () => {
  it('should return the list of users', () => {
    const users = getUsersList(STATE);
    expect(users).toEqual([USER_1, USER_2, USER_3]);
  });

  it('should return the same instance if called twice without changes', () => {
    const users1 = getUsersList(STATE);
    const users2 = getUsersList(STATE);

    expect(users1).toBe(users2);
  });
});
