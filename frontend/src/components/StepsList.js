import React from 'react';
import { Media } from 'react-bootstrap';

import PostStepsPostLabel from '../containers/PostStepsPostLabel';

export default function StepsList(props) {
  return (
    <div>
      {props.postSteps.map(postSteps => (
        <Media key={postSteps.id}>
          <Media.Body>
            <p>{postSteps.text}</p>
          </Media.Body>
        </Media>
      ))}
    </div>
  );
}
