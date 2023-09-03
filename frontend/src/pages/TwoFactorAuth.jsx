import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import {
    MDBCol,
    MDBContainer,
    MDBRow,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBBtn,
} from 'mdb-react-ui-kit';

export default function TwoFactorAuthPage() {
    const navigate = useNavigate();
    const [qrCodeUrl, setQrCodeUrl] = useState('');
    const [user, setUser] = useState({});

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/profile', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`,
                    },
                });

                if (response.ok) {
                    const data = await response.json();
                    setUser(data);
                } else {
                    throw new Error('Failed to fetch user profile');
                }
            } catch (error) {
                console.error(error);
            }
        };

        fetchUser();
    }, []);


    useEffect(() => {
        const enable2FA = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/enable', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    },
                    body: JSON.stringify({
                        username: user.username
                    })
                });

                if (response.ok) {
                    const data = await response.json();
                    setQrCodeUrl(data.qrCodeUrl);
                } else {
                    throw new Error('Failed to enable 2FA');
                }
            } catch (error) {
                console.error(error);
            }
        };

        enable2FA();
    }, [user.username]);

    return (
        <section>
            <MDBContainer className="py-5">
<MDBRow>
    <MDBCol>
        <MDBCard className="mb-4">
            <MDBCardBody className="text-center">
                <MDBCardImage
                    src={qrCodeUrl}
                    alt="QR code"
                    style={{ width: '250px' }}
                    fluid
                />
            </MDBCardBody>

        </MDBCard>

</MDBCol>
    <MDBRow className={'align-items-center'}>
        <MDBCol >
            <MDBBtn color="primary" href="/profile">
                Go to profile
            </MDBBtn>
        </MDBCol>

    </MDBRow>



</MDBRow>

            </MDBContainer>
        </section>
    );
}
