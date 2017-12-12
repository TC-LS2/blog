import {
  fetchPostSteps,
  FETCH_POSTSTEPS,
  fetchPostStepsFulfilled,
  FETCH_POSTSTEPS_FULFILLED,
} from '../actions';

describe('fetchPostSteps', () => {
  it('should create an action of type FETCH_POSTSTEPS', () => {
    const action = fetchPostSteps();
    expect(action).toMatchObject({
      type: FETCH_POSTSTEPS,
    });
  });

  it('should have postId paramenter', () => {
    const action = fetchPostSteps(3);
    expect(action).toMatchObject({
      postId: 3,
    });
  });
});

describe('fetchPostStepsFulfilled', () => {
  it('should create an action of type FETCH_POSTSTEPS_FULFILLED', () => {
    const action = fetchPostStepsFulfilled();
    expect(action).toMatchObject({
      type: FETCH_POSTSTEPS_FULFILLED,
    });
  });

  it('should have payload paramenter', () => {
    const action = fetchPostStepsFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
