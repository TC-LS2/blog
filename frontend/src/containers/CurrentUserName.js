import { connect } from 'react-redux';

import UserName from '../components/UserName';
import { getCurrentUser } from '../selectors';

function mapStateToProps(state) {
  return {
    user: getCurrentUser(state),
  };
}

const CurrentUserName = connect(mapStateToProps)(UserName);

export default CurrentUserName;
