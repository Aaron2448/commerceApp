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

export default function Cart() {
    const {cartItems,addToCart,removeFromCart,total, minusFromCart,clearCart} = useContext(ShopContext)

    var subTotal = 0;

    return  (
        <MDBContainer className="py-5">
        <MDBCard
            className="shadow-2-strong mb-5 mb-lg-4"
            style={{ borderRadius: "16px" }}
        >
            <MDBCardBody className="p-4">
                <MDBRow className="justify-content-center align-items-center h-100">
                    <MDBCol>
                        <MDBCardHeader className="py-3">
                            <h5 className="mb-0">Billing Details</h5>
                        </MDBCardHeader>
                        <MDBTable responsive>
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

                                                    <MDBBtn onClick={()=> addToCart(product,product.product_id)} className="px-2" color="link">
                                                        <MDBIcon fas icon="plus" size='1g'/>
                                                    </MDBBtn>

                                                    <div  className="text-danger mx-4">
                                                        <MDBIcon fas icon="trash text-danger" size="lg" onClick={()=> removeFromCart(product.product_id)}/>
                                                    </div>
                                                </div>

                                            </td>



                                            <td className="align-middle">
                                                <p className="mb-0" style={{fontWeight: "500"}}>
                                                    {`AU$ ${parseFloat(product.retail_price * product.amount).toFixed(2)}`}
                                                </p>

                                            </td>
                                        </tr>
                                    )
                                })}


                            </MDBTableBody>
                        </MDBTable>
                        <MDBCol>
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
                                <p className="mb-2">{`AU$ ${parseFloat(total + (total * 0.1)).toFixed(2)}`}</p>

                            </div>
                            <MDBBtn  size="md" color={'danger'} onClick={clearCart}>
                                <div className="d-flex justify-content-between">
                                    <span>Empty Cart </span>
                                </div>
                            </MDBBtn>
                        </MDBCol>
                    </MDBCol>
                </MDBRow>
            </MDBCardBody>
        </MDBCard>
        </MDBContainer>
    )

}