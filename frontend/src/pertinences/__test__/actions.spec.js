import {
  fetchPertinences,
  FETCH_PERTINENCES,
  fetchPertinencesFulfilled,
  FETCH_PERTINENCES_FULFILLED,
} from '../actions';

describe('fetchPertinences', () => {
  it('should create an action of type FETCH_PERTINENCES', () => {
    const action = fetchPertinences();
    expect(action).toMatchObject({
      type: FETCH_PERTINENCES,
    });
  });
});

describe('fetchPertinencesFulfilled', () => {
  it('should create an action of type FETCH_PERTINENCES_FULFILLED', () => {
    const action = fetchPertinencesFulfilled();
    expect(action).toMatchObject({
      type: FETCH_PERTINENCES_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = fetchPertinencesFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
