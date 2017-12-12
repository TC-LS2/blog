import { createSelector } from 'reselect';

export function getPopulates(state) {
    return state.populates;
}

export function getPopulate(state, { populateId }) {
    return getPopulates(state)[populateId] || {};
}

export const getPopulateList = createSelector([getPopulates], populates =>
    Object.values(populates).sort((a, b) => b.id - a.id),
);