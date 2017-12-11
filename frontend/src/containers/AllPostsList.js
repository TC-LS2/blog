import { connect } from 'react-redux';

import { getPostsList } from '../selectors';
import PostsList from '../components/PostsList';

function mapStateToProps(state) {
  return {
    posts: getPostsList(state),
  };
}

const AllPostsList = connect(mapStateToProps)(PostsList);

export default AllPostsList;
