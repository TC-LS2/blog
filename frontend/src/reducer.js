import { combineReducers } from 'redux';

import comments from './comments/reducer';
import currentUser from './current-user/reducer';
import posts from './posts/reducer';
import users from './users/reducer';
import view from './view/reducer';
import postSteps from './postsSteps/reducer';

export default combineReducers({
  comments,
  currentUser,
  posts,
  postSteps,
  users,
  view,
});
