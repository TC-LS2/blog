import { connect } from 'react-redux';

import { getCurrentUserCommentsList } from '../selectors';
import CommentsWithPostList from '../components/CommentsWithPostList';
import { deleteComment } from '../actions';

function mapStateToProps(state) {
  return {
    onDelete: true,
    comments: getCurrentUserCommentsList(state),
  };
}

const mapDispatchToProps = {
  onDelete: deleteComment,
};

const MyCommentsList = connect(mapStateToProps, mapDispatchToProps)(
  CommentsWithPostList,
);

export default MyCommentsList;
