import {
  createRating,
  CREATE_RATING,
  CREATE_RATING_FULFILLED,
  createRating, createRatingFulfilled, FETCH_RATINGS, fetchRatings, fetchRatingsFulfilled,
  FETCH_RATINGS_FULFILLED,
} from '../actions';

describe('createRating', () => {
  it('should create an action of type CREATE_RATING', () => {
    const action = createRating();
    expect(action).toMatchObject({
      type: CREATE_RATING,
    });
  });

  it('should have the field rating', () => {
    const RATING = {};
    const action = createRating(RATING);
    expect(action).toMatchObject({
      post: RATING,
    });
  });
});

describe('createRatingFulfilled', () => {
  it('should create an action of type CREATE_RATING_FULFILLED', () => {
    const action = createRatingFulfilled();
    expect(action).toMatchObject({
      type: CREATE_RATING_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = createRatingFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});

describe('fetchRatings', () => {
  it('should create an action of type FETCH_RATINGS', () => {
    const action = fetchRatings();
    expect(action).toMatchObject({
      type: FETCH_RATINGS,
    });
  });
});

describe('fetchRatingsFulfilled', () => {
  it('should create an action of type FETCH_RATINGS_FULFILLED', () => {
    const action = fetchRatingsFulfilled();
    expect(action).toMatchObject({
      type: FETCH_RATINGS_FULFILLED,
    });
  });

  it('should add a payload', () => {
    const action = fetchRatingsFulfilled('some payload');
    expect(action).toMatchObject({
      payload: 'some payload',
    });
  });
});
