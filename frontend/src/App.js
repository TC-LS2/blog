import React from 'react';
import { Provider } from 'react-redux';
import store from './store';

import Main from './components/Main';
import { doPopulate } from './actions';
import { getPostsList } from './selectors';

// On App start fetch posts if none present
const state = store.getState();
if (getPostsList(state).length === 0) {
  store.dispatch(doPopulate());
}

export default () => (
  <Provider store={store}>
    <Main />
  </Provider>
);
