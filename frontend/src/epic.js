import 'rxjs/Rx';

import { combineEpics } from 'redux-observable';

import commentsEpic from './comments/epic';
import currentUserEpic from './current-user/epic';
import postsEpic from './posts/epic';
import populateEpic from './populate/epic';
import usersEpic from './users/epic';
import viewEpic from './view/epic';

export default combineEpics(
  commentsEpic,
  currentUserEpic,
  postsEpic,
  populateEpic,
  usersEpic,
  viewEpic,
);
