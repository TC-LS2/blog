import { connect } from 'react-redux';

import { getDenunciesList } from '../selectors';
import DenunciesList from '../components/DenunciesList'


function mapStateToProps(state) {
  return {
    denuncies: getDenunciesList(state),
  };
}

const AllDenunciesList = connect(mapStateToProps)(DenunciesList);

export default AllDenunciesList;
