import { connect } from 'react-redux';

import { getPostStepsList } from '../selectors';
import StepsList from '../components/StepsList';

function mapStateToProps(state, { postId }) {
  const postSteps = getPostStepsList(state, { postId });
  return {
    postSteps,
  };
}

const PostStepsList = connect(mapStateToProps)(StepsList);

export default PostStepsList;
