import { connect } from 'react-redux';

import { setCurrentUser } from '../actions';
import { getUsersList, getCurrentUser } from '../selectors';
import UsersList from '../components/UsersList';

function mapStateToProps(state) {
  return {
    currentUser: getCurrentUser(state),
    users: getUsersList(state),
  };
}

const mapDispatchToProps = {
  setCurrentUser,
};

const AllUsersList = connect(mapStateToProps, mapDispatchToProps)(UsersList);

export default AllUsersList;
