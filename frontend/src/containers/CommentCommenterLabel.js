import { connect } from 'react-redux';

import { getUser } from '../selectors';
import UserLabel from '../components/UserLabel';

function mapStateToProps(state, { comment }) {
  return {
    user: getUser(state, { userId: comment.commenterId }),
  };
}

const CommentCommenterLabel = connect(mapStateToProps)(UserLabel);

export default CommentCommenterLabel;
