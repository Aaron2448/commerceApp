import React from 'react';
import {
    MDBFooter,
    MDBContainer,
    MDBIcon,
    MDBInput,
    MDBCol,
    MDBRow,
    MDBBtn
} from 'mdb-react-ui-kit';

export default function App() {
    return (
        <MDBFooter className='text-center' color='white' bgColor='dark'>
            <MDBContainer className='p-4'>
                <section className='mb-4'>
                    <MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
                        <MDBIcon fab icon='facebook-f' />
                    </MDBBtn>

                    <MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
                        <MDBIcon fab icon='twitter' />
                    </MDBBtn>

                    <MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
                        <MDBIcon fab icon='google' />
                    </MDBBtn>

                    <MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
                        <MDBIcon fab icon='instagram' />
                    </MDBBtn>

                    <MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
                        <MDBIcon fab icon='linkedin-in' />
                    </MDBBtn>

                    <MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
                        <MDBIcon fab icon='github' />
                    </MDBBtn>
                </section>

                <section className=''>
                    <form action='.'>
                        <MDBRow className='d-flex justify-content-center'>
                            <MDBCol size="auto">
                                <p className='pt-2'>
                                    <strong>Sign up for our newsletter</strong>
                                </p>
                            </MDBCol>

                            <MDBCol md='5' start>
                                <MDBInput contrast type='email' label='Email address' className='mb-4' />
                            </MDBCol>

                            <MDBCol size="auto">
                                <MDBBtn outline color='light' type='submit' className='mb-4'>
                                    Subscribe
                                </MDBBtn>
                            </MDBCol>
                        </MDBRow>
                    </form>
                </section>


                <section className=''>
                    <MDBRow>
                        <MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
                            <h5>Product Categories</h5>

                            <ul className='list-unstyled mb-0'>
                                <li>
                                    <a href='/collection' className='text-white'>
                                        Drone Collection
                                    </a>
                                </li>
                                <li>
                                    <a href='/customise' className='text-white'>
                                        Customise your Drone
                                    </a>
                                </li>
                                <li>
                                    <a href='/parts' className='text-white'>
                                        Parts
                                    </a>
                                </li>
                                <li>
                                    <a href='.#!' className='text-white'>
                                        Service
                                    </a>
                                </li>
                            </ul>
                        </MDBCol>

                        <MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
                            <h5>Help & Support</h5>

                            <ul className='list-unstyled mb-0'>
                                <li>
                                    <a href='support' className='text-white'>
                                        Product Support
                                    </a>
                                </li>
                                <li>
                                    <a href='support' className='text-white'>
                                        Inquiry
                                    </a>
                                </li>
                                <li>
                                    <a href='support' className='text-white'>
                                        Help Center
                                    </a>
                                </li>
                            </ul>
                        </MDBCol>

                        <MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
                            <h5>Fly Safe</h5>

                            <ul className='list-unstyled mb-0'>
                                <li>
                                    <a href='.#!' className='text-white'>
                                        Fly Safe
                                    </a>
                                </li>
                                <li>
                                    <a href='.#!' className='text-white'>
                                        Drone Flying Tips
                                    </a>
                                </li>
                            </ul>
                        </MDBCol>

                        <MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
                            <h5>Community</h5>

                            <ul className='list-unstyled mb-0'>
                                <li>
                                    <a href='.#!' className='text-white'>
                                        FlexDrone Forum
                                    </a>
                                </li>
                                <li>
                                    <a href='.#!' className='text-white'>
                                        Developer
                                    </a>
                                </li>
                                <li>
                                    <a href='.#!' className='text-white'>
                                        Share your drone photos
                                    </a>
                                </li>
                            </ul>
                        </MDBCol>
                    </MDBRow>
                </section>
            </MDBContainer>

            <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
                © 2023 Copyright:
                <a className='text-white' href='https://fdmgroup.com/'>
                    FlexDrone
                </a>
            </div>

        </MDBFooter>
    );
}