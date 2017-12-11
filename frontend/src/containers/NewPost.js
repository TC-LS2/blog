import { connect } from 'react-redux';

import { createPost } from '../actions';
import { getCurrentUserId } from '../selectors';
import PostInput from '../components/PostInput';

const mapStateToProps = function(state) {
  return {
    authorId: getCurrentUserId(state),
  };
};

const mapDispatchToProps = {
  onSubmit: createPost,
};

const NewPost = connect(mapStateToProps, mapDispatchToProps)(PostInput);

export default NewPost;
