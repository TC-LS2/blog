import { connect } from 'react-redux';

import { getPopulateList } from '../selectors';
import PopulateList from '../components/PopulateList';

function mapStateToProps(state) {
    return {
        populates: getPopulateList(state),
    };
}

const AllPopulatesList = connect(mapStateToProps)(PopulateList);

export default AllPopulatesList;
