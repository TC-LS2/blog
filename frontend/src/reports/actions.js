export const CREATE_REPORT = 'CREATE_REPORT';
export function createReport(report) {
  return {
    type: CREATE_REPORT,
    report,
  };
}

export const CREATE_REPORT_FULFILLED = 'CREATE_REPORT_FULFILLED';
export function createReportFulfilled(payload) {
  return {
    type: CREATE_REPORT_FULFILLED,
    payload,
  };
}

export const FETCH_REPORTS = 'FETCH_REPORTS';
export function fetchReports() {
  return {
    type: FETCH_REPORTS,
  };
}

export const FETCH_REPORTS_FULFILLED = 'FETCH_USERS_FULFILLED';
export function fetchReportsFulfilled(payload) {
  return {
    type: FETCH_REPORTS_FULFILLED,
    payload,
  };
}
