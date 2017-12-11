import { connect } from 'react-redux';

import { getPostCommentsList } from '../selectors';
import CommentsList from '../components/CommentsList';

function mapStateToProps(state, { postId }) {
  const comments = getPostCommentsList(state, { postId });
  return {
    comments,
  };
}

const PostCommentsList = connect(mapStateToProps)(CommentsList);

export default PostCommentsList;
