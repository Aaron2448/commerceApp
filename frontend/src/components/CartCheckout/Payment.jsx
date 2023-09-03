import React, { useState, useEffect, useContext } from "react";
import {ShopContext} from '../../context/shop-context'
import {
    MDBBtn,
    MDBCard,
    MDBCardBody,
    MDBCardHeader,
    MDBCheckbox,
    MDBCol,
    MDBContainer,
    MDBIcon,
    MDBInput,
    MDBRadio,
    MDBRow,
    MDBTable,
    MDBTableBody,
    MDBTableHead,
    MDBListGroup,
    MDBListGroupItem,
} from "mdb-react-ui-kit";
import {Link} from 'react-router-dom'

export default function Payment(){
    const {cartItems,addToCart,removeFromCart,total, minusFromCart,clearCart} = useContext(ShopContext)
    var subTotal = 0;

    return(
        <MDBContainer className="py-5 h-100">
        <MDBRow className="justify-content-center align-items-center h-100">
            <MDBCol>
                <MDBCard
                    className="shadow-2-strong mb-5 mb-lg-0"
                    style={{ borderRadius: "16px" }}
                >
                    <MDBCardBody className="p-4">
                        <MDBRow>
                            <MDBCol md="6" lg="4" xl="3" className="mb-4 mb-md-0">
                                <form>
                                    <div className="d-flex flex-row pb-3">
                                        <div className="d-flex align-items-center pe-2">
                                            <MDBRadio
                                                type="radio"
                                                name="radio1"
                                                checked
                                                value=""
                                                aria-label="..."
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
                                                name="radio1"
                                                checked
                                                value=""
                                                aria-label="..."
                                            />
                                        </div>
                                        <div className="rounded border w-100 p-3">
                                            <p className="d-flex align-items-center mb-0">
                                                <MDBIcon fab icon="cc-visa fa-2x text-dark pe-2" />
                                                Debit Card
                                            </p>
                                        </div>
                                    </div>
                                    <div className="d-flex flex-row pb-3">
                                        <div className="d-flex align-items-center pe-2">
                                            <MDBRadio
                                                type="radio"
                                                name="radio1"
                                                checked
                                                value=""
                                                aria-label="..."
                                            />
                                        </div>
                                        <div className="rounded border w-100 p-3">
                                            <p className="d-flex align-items-center mb-0">
                                                <MDBIcon fab icon="cc-paypal fa-2x text-dark pe-2" />
                                                PayPal
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
                                    <p className="mb-0">Shipping</p>
                                    <p className="mb-0">$2.99</p>
                                </div>

                                <hr className="my-4" />

                                <div
                                    className="d-flex justify-content-between mb-4"
                                    style={{ fontWeight: "500" }}
                                >
                                    <p className="mb-2">Total (tax included)</p>
                                    <p className="mb-2">AU$ {total + (total * 0.1)}</p>
                                </div>

                                <Link to="/order">
                                    <MDBBtn block size="lg" className={'mb-2'}>
                                        <div className="d-flex justify-content-between">
                                            <span>Checkout</span>
                                            <span>{`AU$ ${parseFloat(total + (total*0.1)).toFixed(2)}`}</span>
                                        </div>
                                    </MDBBtn>
                                </Link>

                                <MDBBtn block size="lg" color={'danger'} onClick={clearCart}>
                                    <div className="d-flex justify-content-between">
                                        <span>Empty Cart</span>
                                        <span>
                                                <MDBIcon fas icon="trash " size="lg" />
                                            </span>
                                    </div>
                                </MDBBtn>
                            </MDBCol>
                        </MDBRow>
                    </MDBCardBody>
                </MDBCard>
            </MDBCol>

        </MDBRow>
        </MDBContainer>
    )
}