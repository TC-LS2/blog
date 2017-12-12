import React from 'react';
import { Media } from 'react-bootstrap';

export default function RatingsList(props) {
  return (
    <div>
      {props.ratings.map(rating => (
        <Media key={rating.id}>
          <Media.Body>
            <Media.Heading>
            </Media.Heading>
          </Media.Body>
        </Media>
      ))}
    </div>
  );
}
