import React from 'react';
import { Col, Grid, Row } from 'react-bootstrap';

import ViewRoot from '../containers/ViewRoot';
import Navbar from './Navbar';

export default function Main() {
  return (
    <Grid>
      <Row>
        <Col xs={12}>
          <br />
          <Navbar />
        </Col>
      </Row>
      <ViewRoot />
    </Grid>
  );
}
