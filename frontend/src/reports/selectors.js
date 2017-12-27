import { createSelector } from 'reselect';

export function getReports(state) {
  return state.reports;
}

export function getReport(state, { reportId }) {
  return getReports(state)[reportId] || {};
}

export const getReportsList = createSelector([getReports], reports =>
  Object.values(reports).sort((a, b) => b.id - a.id),
);
