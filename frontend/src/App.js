import React from 'react';
import { Provider } from 'react-redux';
import store from './store';

import Main from './components/Main';
import { getPostsList } from './selectors';
import { doPopulate } from './populate/actions';

// On App start fetch posts if none present
const state = store.getState();
if (getPostsList(state).length === 0) {
  console.log({ doPopulate, dispatch: store.dispatch })
  store.dispatch(doPopulate());
}

export default () => (
  <Provider store={store}>
    <Main />
  </Provider>
);
