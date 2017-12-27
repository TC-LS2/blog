import { getUserLikes, getLikesList } from '../selectors';
import{ getCurrentUser } from '../../current-user/selectors';

const LIKE_1 = { id: 1, giverId: 1, receiverId: 2, value: false };
const LIKE_2 = { id: 1, giverId: 2, receiverId: 1, value: true };

const USER_1 = { id:1};

const STATE = {
  users: {
    1: USER_1,
  },
  likes: {
    1: LIKE_1,
    2: LIKE_2,
  },
};

describe('getUserLikes', () => {
  it('should return the list of likes of the user to the other users', () => {
    const likes = getLikesList(STATE, getCurrentUser(STATE));
    expect(likes).toEqual([LIKE_1, LIKE_2]);
  });

});
