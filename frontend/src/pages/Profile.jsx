import React, {useState, useEffect} from 'react';
import {Link, useParams} from 'react-router-dom';
import TwoFactorAuth from './TwoFactorAuth'
import DisableTwoFactorAuth from './DisableTwoFactorAuth'
import { useNavigate } from 'react-router-dom';

import {
    MDBCol,
    MDBContainer,
    MDBRow,
    MDBCard,
    MDBCardText,
    MDBCardBody,
    MDBCardImage,
    MDBBtn,
    MDBBreadcrumb,
    MDBBreadcrumbItem,
    MDBProgress,
    MDBProgressBar,
    MDBIcon,
    MDBListGroup,
    MDBListGroupItem,
    MDBModal,
    MDBModalDialog,
    MDBModalContent,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
} from 'mdb-react-ui-kit';
import MyOrders from "./MyOrders";

export default function UserProfile() {
    const [user, setUser] = useState({});
    const [qrCodeUrl, setQrCodeUrl] = useState('');
    const [basicModal, setBasicModal] = useState(false);
    const navigate = useNavigate();


    const toggleShow = () => setBasicModal(!basicModal);

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/profile', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
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

    const handleDisable2FA = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/auth/disable', {
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
                window.location.href = '/profile';
            } else {
                throw new Error('Failed to disable 2FA');
            }
        } catch (error) {
            console.error(error);
        }
    };

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

    const handleDeleteUserProfile = async () => {
        if (window.confirm("Are you sure you want to close your account?")) {
            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/delete', {
                    method: 'DELETE',
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`,
                    },
                });

                if (response.ok) {
                    console.log('User profile deleted');
                    window.location.href = '/';
                } else {
                    throw new Error('Failed to delete user profile');
                }
            } catch (error) {
                console.error(error);
            }
        }
    };

    return (
        <section>
            <MDBContainer className="py-5">
                <MDBRow>
                    <MDBCol lg="4">
                        <MDBCard className="mb-4">
                            <MDBCardBody className="text-center">
                                <MDBCardImage
                                    // User image for future sprint
                                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1.webp"
                                    alt="avatar"
                                    className="rounded-circle"
                                    style={{width: '150px'}}
                                    fluid/>
                                <p className="text-muted mb-1">{user.first_name}</p>
                                <p className="text-muted mb-2">{user.username}</p>
                                <div className="d-flex justify-content-center mb-2">
                                    {/*<MDBBtn className="ms-1" color="primary">Edit</MDBBtn>*/}
                                    {!user.is_using2FA ? (
                                        // <Link to='/2fa'>
                                        <>
                                            <MDBBtn className="ms-1" color="success" onClick={toggleShow}>
                                                Enable 2FA
                                            </MDBBtn>
                                            <MDBModal show={basicModal} setShow={setBasicModal} tabIndex='-1' >
                                                <MDBModalDialog>
                                                    <MDBModalContent>
                                                        <MDBModalHeader>
                                                            <MDBModalTitle>Enable 2FA</MDBModalTitle>
                                                            <MDBBtn className='btn-close' color='none' onClick={toggleShow}></MDBBtn>
                                                        </MDBModalHeader>
                                                        <MDBModalBody className={'align-items-center'}>

                                                            <MDBCard className="mb-4">
                                                                <MDBCardBody className="text-center">
                                                                    <a href='https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2&hl=en&gl=US&pli=1' target="_blank">
                                                                        <MDBCardImage
                                                                            src={'https://cdn-icons-png.flaticon.com/512/732/732208.png'}
                                                                            alt="Google Play"
                                                                            style={{ width: '50px' }}
                                                                            fluid
                                                                        />
                                                                    </a>
                                                                    
                                                                    <a  href='https://apps.apple.com/au/app/google-authenticator/id388497605' target="_blank">
                                                                        <MDBCardImage
                                                                            src={'https://1000logos.net/wp-content/uploads/2016/10/Apple-Logo.png'}
                                                                            alt="Apple Store"
                                                                            style={{ width: '100px' }}
                                                                            fluid
                                                                        />
                                                                    </a>

                                                                </MDBCardBody>
                                                            </MDBCard>
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
                                                            <MDBBtn color="success" onClick={enable2FA}>
                                                                Show QR Code
                                                            </MDBBtn>

                                                        </MDBModalBody>

                                                        <MDBModalFooter>
                                                            <MDBBtn color="primary" href="/profile">
                                                                Go to profile
                                                            </MDBBtn>

                                                        </MDBModalFooter>
                                                    </MDBModalContent>
                                                </MDBModalDialog>
                                            </MDBModal>
                                        </>

                                       // </Link>
                                    ) : null}
                                    {user.is_using2FA ? (
                                            <>
                                                <MDBBtn className="ms-1" color="success" onClick={toggleShow}>
                                                    Disable 2FA
                                                </MDBBtn>
                                                <MDBModal show={basicModal} setShow={setBasicModal} tabIndex='-1' >
                                                    <MDBModalDialog>
                                                        <MDBModalContent>
                                                            <MDBModalHeader>
                                                                <MDBModalTitle>Disable 2FA</MDBModalTitle>

                                                            </MDBModalHeader>
                                                            <MDBModalBody className={'align-items-center'}><DisableTwoFactorAuth/></MDBModalBody>

                                                            <MDBModalFooter>
                                                                <MDBBtn color="danger" onClick={handleDisable2FA}>
                                                                   Disable 2FA
                                                                </MDBBtn>
                                                            </MDBModalFooter>
                                                        </MDBModalContent>
                                                    </MDBModalDialog>
                                                </MDBModal>
                                            </>

                                    ) : null}
                                    <MDBBtn outline  className="ms-1"  color="danger" onClick={handleDeleteUserProfile}>
                                        Close Account
                                    </MDBBtn>
                                </div>
                            </MDBCardBody>
                        </MDBCard>

                        <MDBCard className="mb-4 mb-lg-0">
                            <MDBCardBody className="p-0">
                                <MDBListGroup className="rounded-3">
                                    <Link to="/userOrders">
                                        <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                                            <MDBIcon fas icon="globe fa-lg text-warning" />
                                            <MDBCardText>My Orders</MDBCardText>
                                        </MDBListGroupItem>
                                    </Link>
                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                                        <MDBIcon fab icon="fa-lg" style={{color: '#333333'}}/>
                                        <MDBCardText>some action</MDBCardText>
                                    </MDBListGroupItem>
                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                                        <MDBIcon fab icon="fa-lg" style={{color: '#55acee'}}/>
                                        <MDBCardText>some action</MDBCardText>
                                    </MDBListGroupItem>
                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                                        <MDBIcon fab icon="fa-lg" style={{color: '#ac2bac'}}/>
                                        <MDBCardText>some action</MDBCardText>
                                    </MDBListGroupItem>
                                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                                        <MDBIcon fab icon="fa-lg" style={{color: '#3b5998'}}/>
                                        <MDBCardText>some action</MDBCardText>
                                    </MDBListGroupItem>
                                </MDBListGroup>
                            </MDBCardBody>
                        </MDBCard>
                    </MDBCol>

                    <MDBCol lg="8">
                        <MDBCard className="mb-4">
                            <MDBCardBody>
                                <MDBRow>
                                    <MDBCol sm="3">
                                        <MDBCardText>Full Name</MDBCardText>
                                    </MDBCol>
                                    <MDBCol sm="9">
                                        <MDBCardText className="text-muted">{user.first_name}</MDBCardText>
                                    </MDBCol>
                                </MDBRow>
                                <hr />
                                <MDBRow>
                                    <MDBCol sm="3">
                                        <MDBCardText>Email</MDBCardText>
                                    </MDBCol>
                                    <MDBCol sm="9">
                                        <MDBCardText className="text-muted">{user.email}</MDBCardText>
                                    </MDBCol>
                                </MDBRow>
                                <hr />
                                <MDBRow>
                                    <MDBCol sm="3">
                                        <MDBCardText>Username</MDBCardText>
                                    </MDBCol>
                                    <MDBCol sm="9">
                                        <MDBCardText className="text-muted">{user.username}</MDBCardText>
                                    </MDBCol>
                                </MDBRow>
                                <hr />
                                {user.roles && (
                                    <MDBRow>
                                        <MDBCol sm="3">
                                            <MDBCardText>Roles</MDBCardText>
                                        </MDBCol>
                                        <MDBCol sm="9">
                                            <MDBCardText className="text-muted">{user.roles.map(role => role.name).join(', ')}</MDBCardText>
                                        </MDBCol>
                                    </MDBRow>
                                )}
                                <hr />
                                <MDBRow>
                                    <MDBCol sm="3">
                                        <MDBCardText>Password</MDBCardText>
                                    </MDBCol>
                                    <MDBCol sm="9">
                                        <MDBCardText className="text-muted">{user.password}</MDBCardText>
                                    </MDBCol>
                                </MDBRow>
                                <hr />
                                {user.using2FA && (
                                    <MDBRow>
                                        <MDBCol sm="3">
                                            <MDBCardText>2FA</MDBCardText>
                                        </MDBCol>
                                        <MDBCol sm="9">
                                            <MDBCardText className="text-muted">{user.is_using2FA.toString()}</MDBCardText>
                                        </MDBCol>
                                    </MDBRow>
                                )}
                            </MDBCardBody>
                        </MDBCard>
                        <MDBCard className="mb-4">
                            <MDBCardBody>
                               <MyOrders/>
                            </MDBCardBody>
                        </MDBCard>
                    </MDBCol>

                </MDBRow>
            </MDBContainer>
        </section>
    );
}
