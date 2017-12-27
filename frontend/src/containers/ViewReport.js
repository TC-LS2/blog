import { connect } from 'react-redux';

import { getReport, getViewId } from '../selectors';
import Report from '../components/Report';

function mapStateToProps(state) {
  const reportId = getViewId(state);
  const report = getReport(state, { reportId });
  return {
    report,
  };
}

const CurrentReport = connect(mapStateToProps)(Report);

export default CurrentReport;
