import {
  getUserLikes, GET_USER_LIKES,
  showLikes, SHOW_LIKES
} from '../actions';

describe('showUserLikes', () => {
    it('should create an action of type SHOW_LIKES', () => {
    const action = showLikes();
    expect(action).toMatchObject({
      type: SHOW_LIKES,
    });
  });

});


