import { connect } from 'react-redux';

import { getPost } from '../selectors';
import PostLabel from '../components/PostLabel';

function mapStateToProps(state, { comment }) {
  return {
    post: getPost(state, { postId: comment.postId }),
  };
}

const CommentPostLabel = connect(mapStateToProps)(PostLabel);

export default CommentPostLabel;
