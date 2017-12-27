import { connect } from 'react-redux';

import { createReport } from '../actions';
import { getCurrentUserId } from '../selectors';
import ReportInput from '../components/ReportInput';

const mapStateToProps = function(state) {
  return {
    authorId: getCurrentUserId(state),
  };
};

const mapDispatchToProps = {
  onSubmit: createReport,
};

const NewReport = connect(mapStateToProps, mapDispatchToProps)(ReportInput);

export default NewReport;
