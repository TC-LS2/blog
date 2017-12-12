import { connect } from 'react-redux';

import RatingsList from "../components/RatingsList";
import {getRatingsList} from "../ratings/selectors";

function mapStateToProps(state) {
  return {
    ratings: getRatingsList(state),
  };
}

const MyRatingList = connect(mapStateToProps)(
  RatingsList,
);

export default MyRatingList;
