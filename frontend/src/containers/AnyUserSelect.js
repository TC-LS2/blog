import { connect } from 'react-redux';

import UserSelect from '../components/UserSelect';
import { getUsersList } from '../selectors';

function mapStateToProps(state, ownProps) {
  return {
    user: ownProps.user,
    users: getUsersList(state),
    onChange: ownProps.onChange,
  };
}

const CurrentUserSelect = connect(mapStateToProps)(UserSelect);

export default CurrentUserSelect;
