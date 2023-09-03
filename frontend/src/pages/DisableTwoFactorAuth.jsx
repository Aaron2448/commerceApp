import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import {
    MDBCol,
    MDBContainer,
    MDBRow,
    MDBCard,
    MDBCardBody,
    MDBBtn,
} from 'mdb-react-ui-kit';

export default function DisableTwoFactorAuth() {
    return (
        <section>
            <MDBContainer className="py-5">

                        <MDBCard className="mb-4">
                            <MDBCardBody className="text-center">
                                <p className="lead">
                                    Are you sure you want to disable two-factor authentication?
                                </p>
                            </MDBCardBody>
                        </MDBCard>
            </MDBContainer>
        </section>
    );
}
