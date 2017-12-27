import { connect } from 'react-redux';

import { getPost } from '../selectors';
import PostLabel from '../components/PostLabel';

function mapStateToProps(state, { postSteps }) {
  return {
    post: getPost(state, { postId: postSteps.postId }),
  };
}

const PostStepsPostLabel = connect(mapStateToProps)(PostLabel);

export default PostStepsPostLabel;
