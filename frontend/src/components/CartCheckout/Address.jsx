import React, {useState, useContext, useEffect} from 'react'
import { ShopContext } from '../../context/shop-context'
import { useNavigate } from 'react-router-dom'
import {
    MDBCard,
    MDBCardBody,
    MDBCardHeader,
  
    MDBCol,
    MDBContainer,
    MDBInput,
    MDBIcon,
    MDBRow,
    MDBRadio,
    MDBBtn,
   
} from "mdb-react-ui-kit";

export default function App() {
    const navigate = useNavigate()
    const {cartItems,addToCart,removeFromCart,total, minusFromCart,clearCart} = useContext(ShopContext)
    
    const [customer_id, setCustomer_id] = useState('')
    const [address, setAddress] = useState('')
    const [email, setEmail] = useState('')
    const [name, setName] = useState('')
    const [payment_method, setPayment_method] = useState('')
    const [user, setUser] = useState('')
    const [quantity_in_cart, setQuantity_in_cart] = useState('')

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
                    console.log(data)
                    setUser(data);

					
                  
                        setName(data.first_name);
                        setEmail(data.email);
                 



                } else {
                    // If failed to fetch user profile, use the information in the text fields
                   		setName(name);
                        setEmail(email);
                    
                }
            } catch (error) {
                console.error(error);
            }
        };

        fetchUser();
    }, []);

    console.log(cartItems)

    const handleSubmit = async (e) => {
        e.preventDefault()
        try {
			
			
            const product = cartItems.map(item => ({
                sku: item.sku,
                retail_price: item.retail_price,
                quantity_in_cart: item.amount,
				product_id: item.product_id
            }))

          const orderObj = {
                customer_id,
                name,
                address,
                email,
                payment_method,
                product
            }

            const res = await fetch('http://localhost:8080/api/v1/order/createOrder', {
                method: 'POST',
                body: JSON.stringify(orderObj),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                },
            })
            if (res.ok){
                console.log('order added')
                clearCart()
                navigate('/')
            }else{
                throw new Error('failed to add to cart')
            }
        } catch (error) {
            console.log(error)
        }

    }

    return (
        <>
            <MDBContainer className="py-5">
                <MDBRow className="justify-content-center align-items-center h-100">
                    <MDBCol md="12" className="mb-4">
                        <MDBCard className="">
                            <MDBCardHeader className="py-3">
                                <h5 className="mb-0">Billing Details</h5>
                            </MDBCardHeader>
                            <MDBCardBody>
                                
                                <MDBRow className="mb-4">
	                                 <MDBInput
	                                    wrapperClass="mb-4"
	                                    label="Name"
	                                    id="form1"
	                                    type="text"
	                                    value={name}
	                                    onChange={e => setName(e.target.value)}/>         
                                </MDBRow>
                                
                                <MDBRow className="mb-4">
                                <MDBInput
                                        wrapperClass="mb-4"
                                        label="Email"
                                        id="form2"
                                        type="email"
                                        value={email}
                                        onChange={e => setEmail(e.target.value)}/>
                                </MDBRow>
                                
                                 <MDBRow className="mb-4">
                          			<MDBInput
	                                    wrapperClass="mb-4"
	                                    label="Address"
	                                    id="form3"
	                                    type="text"
	                                    value={address}
	                                    onChange={e => setAddress(e.target.value)}/>
                                </MDBRow>
                                
                            </MDBCardBody>
                        </MDBCard>
                    </MDBCol>
                </MDBRow>
                <MDBRow className="justify-content-center align-items-center h-100">
                    <MDBCol>
                        <MDBCard
                            className="shadow-2-strong mb-5 mb-lg-0"
                            style={{ borderRadius: "16px" }}
                        >
                            <MDBCardBody className="p-4">
                                <MDBRow>
                                    <MDBCol md="6" lg="4" xl="3" className="mb-4 mb-md-0">
                                        <form onChange={e => setPayment_method(e.target.value)}>
                                            <div className="d-flex flex-row pb-3">
                                                <div className="d-flex align-items-center pe-2">
                                                    <MDBRadio
                                                        type="radio"
                                                        name="radio1"
                                                        value='Credit Card'
                                                    />
                                                </div>
                                                <div className="rounded border w-100 p-3">
                                                    <p className="d-flex align-items-center mb-0">
                                                        <MDBIcon
                                                            fab
                                                            icon="cc-mastercard fa-2x text-dark pe-2"
                                                        />
                                                        Credit Card
                                                    </p>
                                                </div>
                                            </div>
                                            <div className="d-flex flex-row pb-3">
                                                <div className="d-flex align-items-center pe-2">
                                                    <MDBRadio
                                                        type="radio"
                                                        name="radio2"
                                                        value='Debit Card'
                                                    />
                                                </div>
                                                <div className="rounded border w-100 p-3">
                                                    <p className="d-flex align-items-center mb-0">
                                                        <MDBIcon fab icon="cc-visa fa-2x text-dark pe-2" />
                                                        Debit Card
                                                    </p>
                                                </div>
                                            </div>

                                        </form>
                                    </MDBCol>
                                    <MDBCol md="6" lg="4" xl="6">
                                        <MDBRow>
                                            <MDBCol size="12" xl="6">
                                                <MDBInput
                                                    className="mb-4 mb-xl-5"
                                                    label="Name on card"
                                                    placeholder="John Smiths"
                                                    size="lg"
                                                />
                                                <MDBInput
                                                    className="mb-4 mb-xl-5"
                                                    label="Expiration"
                                                    placeholder="MM/YY"
                                                    size="lg"
                                                    maxLength={7}
                                                    minLength={7}
                                                />
                                            </MDBCol>

                                            <MDBCol size="12" xl="6">
                                                <MDBInput
                                                    className="mb-4 mb-xl-5"
                                                    label="Card Number"
                                                    placeholder="1111 2222 3333 4444"
                                                    size="lg"
                                                    minlength="19"
                                                    maxlength="19"
                                                />
                                                <MDBInput
                                                    className="mb-4 mb-xl-5"
                                                    label="Cvv"
                                                    placeholder="&#9679;&#9679;&#9679;"
                                                    size="lg"
                                                    minlength="3"
                                                    maxlength="3"
                                                    type="password"
                                                />
                                            </MDBCol>
                                        </MDBRow>
                                    </MDBCol>
                                    <MDBCol lg="4" xl="3">
                                        <div
                                            className="d-flex justify-content-between"
                                            style={{ fontWeight: "500" }}
                                        >
                                            <p className="mb-2">Subtotal</p>
                                            <p className="mb-2">{`AU$ ${parseFloat(total).toFixed(2)}`}</p>
                                        </div>

                                        <div
                                            className="d-flex justify-content-between"
                                            style={{ fontWeight: "500" }}
                                        >
                                            <p className="mb-0">Tax</p>
                                            <p className="mb-0">{`AU$ ${parseFloat(total * 0.1).toFixed(2)}`}</p>
                                        </div>
                                        <div
                                            className="d-flex justify-content-between"
                                            style={{ fontWeight: "500" }}
                                        >
                                            <p className="mb-0">Shipping</p>
                                            <p className="mb-0">$2.99</p>
                                        </div>

                                        <hr className="my-4" />

                                        <div
                                            className="d-flex justify-content-between mb-4"
                                            style={{ fontWeight: "500" }}
                                        >
                                            <p className="mb-2">Total</p>
                                            <p className="mb-2">{`AU$ ${parseFloat(total + (total * 0.1)).toFixed(2)}`}</p>
                                        </div>
                                            <MDBBtn block size="lg" className={'mb-2'} onClick={handleSubmit}>
                                                <div className="d-flex justify-content-center">
                                                    <span>Checkout</span>
                                                </div>
                                            </MDBBtn>

                                    </MDBCol>
                                </MDBRow>
                            </MDBCardBody>
                        </MDBCard>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
        </>

);
}