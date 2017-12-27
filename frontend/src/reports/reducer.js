import { CREATE_REPORT_FULFILLED, FETCH_REPORTS_FULFILLED } from './actions';

export default function users(state = {}, action) {
  switch (action.type) {
    case CREATE_REPORT_FULFILLED: {
      const report = action.payload;
      return {
        ...state,
        [report.id]: report,
      };
    }

    case FETCH_REPORTS_FULFILLED: {
      const newState = {};
      action.payload.forEach(report => {
        newState[report.id] = report;
      });
      return newState;
    }

    default:
      return state;
  }
}
