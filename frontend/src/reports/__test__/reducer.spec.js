import { createReportFulfilled, fetchReportsFulfilled } from '../actions';
import reducer from '../reducer';

describe('posts reducer', () => {
  it('should create an empty object as initial state', () => {
    const initialState = reducer(undefined, {});
    expect(initialState).toMatchObject({});
  });

  const REPORT_1 = { id: 1, reason: 'blame', post: 1, user: 2 };
  const REPORT_2 = { id: 2, reason: 'fake', post: 2, user: 1 };

  describe('createReportFulfilled', () => {
    it('should add post after createReportFulfilled', () => {
      let state = reducer({ 1: REPORT_1 }, createReportFulfilled(REPORT_2));

      expect(state).toEqual({ 1: REPORT_1, 2: REPORT_2 });
    });
  });

  describe('fetchReportsFulfilled', () => {
    it('should add received elements', () => {
      const state = reducer(
        undefined,
        fetchReportsFulfilled([REPORT_1, REPORT_2]),
      );
      expect(state).toMatchObject({
        1: REPORT_1,
        2: REPORT_2,
      });
    });

    it('should replace previous received elements', () => {
      let state = reducer(undefined, fetchReportsFulfilled([REPORT_1]));
      state = reducer(state, fetchReportsFulfilled([REPORT_2]));

      expect(state).toEqual({ 2: REPORT_2 });
    });
  });
});
