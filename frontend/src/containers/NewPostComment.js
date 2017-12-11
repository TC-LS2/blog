import { connect } from 'react-redux';

import { createComment } from '../actions';
import { getCurrentUserId } from '../selectors';
import CommentInput from '../components/CommentInput';

const mapStateToProps = function(state, ownProps) {
  return {
    commenterId: getCurrentUserId(state),
    postId: ownProps.postId,
  };
};

const mapDispatchToProps = {
  onSubmit: createComment,
};

const NewPostComment = connect(mapStateToProps, mapDispatchToProps)(
  CommentInput,
);

export default NewPostComment;
