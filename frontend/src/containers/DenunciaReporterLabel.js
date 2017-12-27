import { connect } from 'react-redux';

import { getUser } from '../selectors';
import UserLabel from '../components/UserLabel';

function mapStateToProps(state, { denuncia }) {
  return {
    user: getUser(state, { userId: denuncia.reporterId }),
  };
}

const DenunciaReporterLabel = connect(mapStateToProps)(UserLabel);

export default DenunciaReporterLabel;
