import { connect } from 'react-redux';

import { getCurrentUserPostsList } from '../selectors';
import PostsList from '../components/PostsList';

function mapStateToProps(state) {
  return {
    posts: getCurrentUserPostsList(state),
  };
}

const MyPostsList = connect(mapStateToProps)(PostsList);

export default MyPostsList;
