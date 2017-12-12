import { fetchPertinencesFulfilled } from '../actions';
import reducer from '../reducer';

describe('pertinensa reducer', () => {
  it('should create an empty object as initial state', () => {
    const initialState = reducer(undefined, {});
    expect(initialState).toMatchObject({});
  });

  const PERTINENSA_1 = { id: 1, text: 'pertinensa 1',  };
  const PERTINENSA_2 = { id: 2, title: 'pertinensa 2', };
  const PERTINENSA_3 = { id: 3, title: 'pertinensa 3',};



  describe('fetchPostsFulfilled', () => {
    it('should add received elements', () => {
      const state = reducer(
        undefined,
        fetchPertinencesFulfilled([PERTINENSA_1, PERTINENSA_2, PERTINENSA_3]),
      );
      expect(state).toMatchObject({
        1: PERTINENSA_1,
        2: PERTINENSA_2,
        3: PERTINENSA_3,
      });
    });

    it('should replace previous received elements', () => {
      let state = reducer(undefined, fetchPertinencesFulfilled([PERTINENSA_1]));
      state = reducer(state, fetchPertinencesFulfilled([PERTINENSA_2]));

      expect(state).toEqual({ 2: PERTINENSA_2 });
    });
  });
});
