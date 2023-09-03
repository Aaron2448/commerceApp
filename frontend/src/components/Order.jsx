import React, { useState, useEffect, useContext } from "react";
import {ShopContext} from '../context/shop-context'
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
export default function SummaryPage() {
	
	const {cartItems,addToCart,removeFromCart,total, minusFromCart,clearCart} = useContext(ShopContext)


    var subTotal = 0;

    return (
        <section className="h-100 h-custom">
            <MDBContainer className="py-5 h-100">
                {/*Shopping card*/}
                <MDBCard
                    className="shadow-2-strong mb-5 mb-lg-4"
                    style={{ borderRadius: "16px" }}
                >
                    <MDBCardBody className="p-4">
                <MDBRow className="justify-content-center align-items-center h-100">
                    <MDBCol>
                        <MDBTable responsive>
                            <MDBTableHead>
                                <tr>
                                    <th scope="col" className="h4">
                                        Shopping Bag
                                    </th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                            </MDBTableHead>

                            <MDBTableBody>

                                    {cartItems.map(product => {
                                        return (
                                            <tr>

                                                <th scope="row" >
                                                    <div className="d-flex align-items-center">
                                                        <img
                                                            src={product.image_url}
                                                            fluid
                                                            className="rounded-3"
                                                            style={{width: "120px"}}
                                                            alt="Book"
                                                        />
                                                        <div className="flex-column ms-4">
                                                            <Link to={`/product-detail/${product.product_id}`} style={{ color: 'inherit', textDecoration: 'inherit'}}>
                                                                <p className="mb-2">{product.name}</p>
                                                            </Link>
                                                            <p className="mb-0">{product.category}</p>
                                                        </div>
                                                    </div>
                                                </th>
                                                <td className="align-middle">
                                                    <div className="d-flex flex-row align-items-center">


                                                        <MDBBtn onClick={()=> minusFromCart(product.product_id)} className="px-2" color="link">
                                                            <MDBIcon fas icon="minus" size='1g'/>
                                                        </MDBBtn>

	                                                        <td className="align-middle">
	                                                    		<p className="mb-0" style={{fontWeight: "500"}}>Qty {product.amount}</p>
	                                                		</td>

                                                 		<MDBBtn onClick={()=> addToCart(product,product.id)} className="px-2" color="link">
                                                            <MDBIcon fas icon="plus" size='1g'/>
                                                        </MDBBtn>

                                                        <div  className="text-danger mx-4">
                                                            <MDBIcon fas icon="trash text-danger" size="lg" onClick={()=> removeFromCart(product.product_id)}/>
                                                        </div>
                                                    </div>

                                                </td>



                                                <td className="align-middle">
                                                    <p className="mb-0" style={{fontWeight: "500"}}>
                                                        {`AU$ ${parseFloat(product.retailPrice * product.amount).toFixed(2)}`}
                                                    </p>

                                                </td>
                                            </tr>
                                            )
                                    })}


                            </MDBTableBody>
                        </MDBTable>
                    </MDBCol>
                </MDBRow>
                    </MDBCardBody>
                </MDBCard>

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

        </section>
    );
}