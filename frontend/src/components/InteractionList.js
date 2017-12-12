import React from 'react';
import { Media } from 'react-bootstrap';

import CommentCommenterLabel from '../containers/CommentCommenterLabel';

export default function InteractionList(props) {
  return (
    <div>
      {props.interactions.map(interaction => (
        <Media key={interaction.id}>
          <Media.Body>
            <Media.Heading>
              <CommentCommenterLabel interaction={interaction} /> interact with:
            </Media.Heading>
            <p>{interaction.value}</p>
          </Media.Body>
        </Media>
      ))}
    </div>
  );
}
