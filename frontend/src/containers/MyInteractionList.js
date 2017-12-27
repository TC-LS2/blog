import { connect } from 'react-redux';

import { getInteractionList } from '../selectors';
import CommentsWithPostList from '../components/CommentsWithPostList';
import { undoInteraction } from '../actions';

function mapStateToProps(state) {
  return {
    onDelete: true,
    comments: getInteractionList(state),
  };
}

const mapDispatchToProps = {
  onDelete: undoInteraction,
};

const MyInteractionList = connect(mapStateToProps, mapDispatchToProps)(
  CommentsWithPostList,
);

export default MyInteractionList;
