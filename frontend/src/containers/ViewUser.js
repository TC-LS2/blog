import { connect } from 'react-redux';

import { getUser, getViewId } from '../selectors';
import User from '../components/User';

function mapStateToProps(state) {
  const userId = getViewId(state);
  const user = getUser(state, { userId });
  return {
    user,
  };
}

const CurrentUser = connect(mapStateToProps)(User);

export default CurrentUser;
