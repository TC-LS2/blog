import React from 'react';
import { PageHeader } from 'react-bootstrap';

export default function Post(props) {
  return (
    <div>
      <PageHeader>
        {'Report ' + props.report.id}
      </PageHeader>
      <p>
        {props.report.reason}
      </p>
    </div>
  );
}
