import {
  createReport,
  CREATE_REPORT,
  createReportFulfilled,
  CREATE_REPORT_FULFILLED,
  fetchReports,
  FETCH_REPORTS,
  fetchReportsFulfilled,
  FETCH_REPORTS_FULFILLED,
} from '../actions';

describe('createReport', () => {
  it('should create an action of type CREATE_REPORT', () => {
    const action = createReport();
    expect(action).toMatchObject({
      type: CREATE_REPORT,
    });
  });

  it('should have the field report', () => {
    const REPORT = {};
    const action = createReport(REPORT);
    expect(action).toMatchObject({
      report: REPORT,
    });
  });
});

describe('createReportFulfilled', () => {
  it('should create an action of type CREATE_REPORT_FULFILLED', () => {
    const action = createReportFulfilled();
    expect(action).toMatchObject({
      type: CREATE_REPORT_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = createReportFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});

describe('fetchReports', () => {
  it('should create an action of type FETCH_REPORTS', () => {
    const action = fetchReports();
    expect(action).toMatchObject({
      type: FETCH_REPORTS,
    });
  });
});

describe('fetchReportsFulfilled', () => {
  it('should create an action of type FETCH_REPORTS_FULFILLED', () => {
    const action = fetchReportsFulfilled();
    expect(action).toMatchObject({
      type: FETCH_REPORTS_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = fetchReportsFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
