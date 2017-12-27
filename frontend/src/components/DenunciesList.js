import React from 'react';

import ViewLink from '../containers/ViewLink';
import DenunciaReporterLabel from "../containers/DenunciaReporterLabel";
import DenunciaReportedLabel from "../containers/DenunciaReportedLabel";

export default function ListDenuncies(props) {
  return (
    <ul>
      {props.denuncies.map(denuncia => (
        <div key={denuncia.id}>
          <h3 style={{marginBottom: 0}}>
            <ViewLink text={denuncia.reason} root="denuncia" id={denuncia.id}/>
          </h3>
          {' by '}
          <DenunciaReporterLabel denuncia={denuncia}/>
          {' About '}
          <DenunciaReportedLabel denuncia={denuncia}/>
        </div>
      ))}
    </ul>
  );
}
