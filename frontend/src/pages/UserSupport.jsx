import React, {useEffect, useState} from 'react';
import {MDBCard, MDBCardBody, MDBCardHeader, MDBCol, MDBContainer, MDBIcon, MDBInput, MDBRow} from 'mdb-react-ui-kit';
import Alert from "@mui/material/Alert";
import Button from "@mui/material/Button";

export default function UserSupport() {
    const [enquiry, setEnquiry] = useState({
        name: '',
        email: '',
        customer_message: '',
        enquiry_type: ''
    });

    const [user, setUser] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);

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

                    // Update the enquiry state with the user's information
                    setEnquiry({
                        ...enquiry,
                        name: data.name,
                        email: data.email
                    });
                } else {
                    // If failed to fetch user profile, use the information in the text fields
                    setEnquiry({
                        ...enquiry,
                        name: enquiry.name,
                        email: enquiry.email
                    });
                }
            } catch (error) {
                console.error(error);
            }
        };

        fetchUser();
    }, []);

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setEnquiry({...enquiry, [name]: value});
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/v1/user-enquiries/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                },
                body: JSON.stringify({
                    ...enquiry,
                    user: user,
                    create_date: new Date().toISOString().slice(0, 10),
                    resolve_date: null
                })
            });

            if (response.ok) {
                console.log('Enquiry created successfully');
                setIsSubmitted(true);
                setEnquiry({
                    name: '',
                    email: '',
                    customer_message: '',
                    enquiry_type: ''
                });
            } else {
                throw new Error('Failed to create enquiry');
            }
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <MDBContainer className="my-5">
            <MDBRow className="justify-content-center">
                <MDBCol md="12" className="text-center mb-6">
                    <h2>Contact Us</h2>
                </MDBCol>
                <MDBCol md="8">
                    <MDBCard>
                        <MDBCardHeader>
                            <MDBIcon icon="envelope" className="me-2"/>
                            Send Us A Message!
                        </MDBCardHeader>
                        <MDBCardBody>
                            <form onSubmit={handleSubmit}>
                                <div className="row mb-3">
                                    <div className="col">
                                        <MDBInput
                                            label="Name"
                                            name="name"
                                            value={enquiry.name}
                                            onChange={handleInputChange}
                                            required
                                        />
                                    </div>
                                    <div className="col">
                                        <MDBInput
                                            label="Email"
                                            name="email"
                                            type="email"
                                            value={enquiry.email}
                                            onChange={handleInputChange}
                                            required
                                        />
                                    </div>
                                </div>
                                <div className="mb-3">
                                    <MDBInput
                                        label="Description"
                                        name="customer_message"
                                        type="textarea"
                                        rows="5"
                                        value={enquiry.customer_message}
                                        onChange={handleInputChange}
                                        required
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="enquiryType" className="form-label">
                                        Enquiry Type
                                    </label>
                                    <select
                                        className="form-select"
                                        id="enquiry_type"
                                        name="enquiry_type"
                                        value={enquiry.enquiry_type}
                                        onChange={handleInputChange}
                                        required
                                    >
                                        <option value="">Select an enquiry type</option>
                                        <option value="GENERAL">General enquiry</option>
                                        <option value="CUSTOMER">Customer enquiry</option>
                                        <option value="RETURN">Return enquiry</option>
                                    </select>
                                </div>
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    sx={{mt: 3, mb: 2}}
                                >
                                    Submit
                                </Button>
                                {isSubmitted && (
                                    <Alert severity="success" sx={{mb: 2}}>
                                        Enquiry submitted successfully!
                                    </Alert>
                                )}
                            </form>
                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>
        </MDBContainer>
    );


}
