import { connect } from 'react-redux';

import { createDenuncia } from '../actions';
import { getCurrentUserId,getUser } from '../selectors';
import DenunciaInput from '../components/DenunciaInput';

const mapStateToProps = function(state) {
  return {
    reporterId: getCurrentUserId(state),
  };
};

const mapDispatchToProps = {
  onSubmit: createDenuncia(),
};

const NewPost = connect(mapStateToProps, mapDispatchToProps)(DenunciaInput);

export default NewPost;
