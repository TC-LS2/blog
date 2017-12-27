import { connect } from 'react-redux';

import { getUser } from '../selectors';
import UserLabel from '../components/UserLabel';

function mapStateToProps(state, { denuncia }) {
  return {
    user: getUser(state, { userId: denuncia.reportedId }),
  };
}

const DenunciaReportedLabel = connect(mapStateToProps)(UserLabel);

export default DenunciaReportedLabel;
