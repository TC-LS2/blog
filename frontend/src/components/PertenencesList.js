import React from 'react';


export default function PertenencesList(props) {
  return (
    <ul>
      {props.pertenences.map(pertenence => (
        <div key={pertenence.id}>
          <h3 style={{ marginBottom: 0 }}>
           {   pertenence.text }
          </h3>
        </div>
      ))}
    </ul>
  );
}
