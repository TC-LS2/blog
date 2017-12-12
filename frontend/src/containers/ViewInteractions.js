import { connect } from 'react-redux';

import { getPost, getViewId } from '../selectors';
import Post from '../components/Post';

function mapStateToProps(state) {
  const interactionId = getViewId(state);
  const interaction = getInteraction(state, { interactionId });
  return {
    interaction,
  };
}

const CurrentLike = connect(mapStateToProps)(Post);

export default CurrentLike;
