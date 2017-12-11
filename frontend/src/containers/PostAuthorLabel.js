import { connect } from 'react-redux';

import { getUser } from '../selectors';
import UserLabel from '../components/UserLabel';

function mapStateToProps(state, { post }) {
  return {
    user: getUser(state, { userId: post.authorId }),
  };
}

const PostAuthorLabel = connect(mapStateToProps)(UserLabel);

export default PostAuthorLabel;
