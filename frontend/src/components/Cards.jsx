import React, { useState, useEffect,useContext } from "react";
import axios from "axios"
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBIcon,
    MDBBtn,
} from "mdb-react-ui-kit";
import {Link} from 'react-router-dom'
import {ShopContext} from '../context/shop-context'


const theme = createTheme();

const Cards = ({product}) => {

    const {addToCart} = useContext(ShopContext)

    return (
                                <MDBCard className="mb-3">
                                    <MDBCardImage
                                        src={product.image_url}
                                        position="top"
                                        alt={product.name}
                                        style={{minHeight:400, maxHeight:400 , maxWidth:400}}
                                    />
                                    <MDBCardBody>
                                        <div className="d-flex justify-content-between mb-3">
                                            <Link to={`/product-detail/${product.product_id}`} style={{ color: 'inherit', textDecoration: 'inherit'}}>
                                            <h5 className="mb-0">{product.name.substring(0,20)}</h5>
                                            </Link>
                                            <h5 className="text-dark mb-0">${product.retail_price}</h5>
                                        </div>


                                        <div className="d-flex justify-content-between">
                                            <p className="small">
                                                <a href="#!" className="text-muted">
                                                    Category: {product.category}
                                                </a>
                                            </p>
                                        </div>

                                        <div class="d-flex justify-content-between mb-2">
                                            <p class="text-muted mb-0">
                                                Available: <span class="fw-bold">{product.external_stock}</span>
                                            </p>
                                            <div className="ms-auto text-success">
                                                <MDBBtn onClick={()=> addToCart(product,product.product_id)} className='me-1' color='success'>
                                                    <MDBIcon fas icon="cart-plus" size='lg'/>
                                                </MDBBtn>

                                            </div>
                                        </div>

                                    </MDBCardBody>
                                </MDBCard>
    );
}

export default Cards;
