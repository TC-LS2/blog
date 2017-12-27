import { connect } from 'react-redux';

import { getPertinencesList } from '../selectors';
import PertenencesList from '../components/PertenencesList';

function mapStateToProps(state) {
  return {
    pertinences: getPertinencesList(state),
  };
}

const UserPertinencesList = connect(mapStateToProps)(PertenencesList);

export default UserPertinencesList;
