import { connect } from 'react-redux';

import { getReportsList } from '../selectors';
import ReportsList from '../components/ReportsList';

function mapStateToProps(state) {
  return {
    reports: getReportsList(state),
  };
}

const AllReportsList = connect(mapStateToProps)(ReportsList);

export default AllReportsList;
