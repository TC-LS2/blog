import { getReportsList, getReport } from '../selectors';

const REPORT_1 = { id: 1, reason: 'blame', report: 1, user: 2 };
const REPORT_2 = { id: 2, reason: 'fake', report: 2, user: 1 };
const STATE = {
  reports: {
    1: REPORT_1,
    2: REPORT_2,
  },
};

describe('getReport', () => {
  it('should return the requested report', () => {
    const report = getReport(STATE, { reportId: 1 });

    expect(report).toBe(REPORT_1);
  });

  it('should return an empty object if it does not exists', () => {
    const report = getReport(STATE, { reportId: 'UNEXISTING' });

    expect(report).toEqual({});
  });
});

describe('getReportsList', () => {
  it('should return the list of reports inverse order by id', () => {
    const reports = getReportsList(STATE);
    expect(reports).toEqual([REPORT_2, REPORT_1]);
  });

  it('should return the same instance if called twice without changes', () => {
    const reports1 = getReportsList(STATE);
    const reports2 = getReportsList(STATE);

    expect(reports1).toBe(reports2);
  });
});
