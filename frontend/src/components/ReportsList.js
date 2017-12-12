import React from 'react';
import ViewLink from "../containers/ViewLink";

export default function ListPosts(props) {
  return (
    <ul>
      {props.reports.map(report => (
        <div key={report.id}>
          <ViewLink text={'Report ' + report.id + ': ' + report.reason} root="report" id={report.id} />
        </div>
      ))}
    </ul>
  );
}
