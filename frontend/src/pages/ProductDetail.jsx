import React,{useContext} from 'react';
import {useParams} from 'react-router-dom'
import {ShopContext} from '../context/shop-context'
import {ProductContext} from '../context/product-context'
import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBIcon,
    MDBRipple,
    MDBBtn,
} from "mdb-react-ui-kit";
import "./product-details.css"
export default function ProductDetail() {
    //get the product id from the url
    const {id} = useParams()
    const {products} =useContext(ProductContext)
    const {addToCart} =useContext(ShopContext)

    const product = products.find(item => {
        return item.product_id === parseInt(id);
    })

    if (!product){
        return <section>
            Loading...
        </section>
    }
    console.log(product)

    const {name,retail_price,description,image_url,category,external_stock,sku} = product


    return (
        <MDBContainer fluid>
            <MDBRow className="justify-content-center mb-0">
                <MDBCol md="12" xl="10">
                    <MDBCard className="shadow-0 border rounded-3 mt-5 mb-3">
                        <MDBCardBody>
                            <MDBRow>
                                <MDBCol md="12" lg="3" className="mb-4 mb-lg-0">
                                    <MDBRipple
                                        rippleColor="light"
                                        rippleTag="div"
                                        className="bg-image rounded hover-zoom hover-overlay"
                                    >
                                        <MDBCardImage
                                            src={image_url}
                                            fluid
                                            className="w-100"
                                        />
                                        <a href="#!">
                                            <div
                                                className="mask"
                                                style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}
                                            ></div>
                                        </a>
                                    </MDBRipple>
                                </MDBCol>
                                <MDBCol md="6">
                                    <h5>{name}</h5>
                                    <div className="mt-1 mb-0 text-muted small">
                                        <span>Category: {category}</span>
                                        <span className="text-primary"> • </span>
                                        <span>Serial Num: {sku}</span>
                                        <span className="text-primary"> • </span>

                                    </div>
                                    <div className="mb-2 text-muted small">
                                        <span>Available: {external_stock}</span>
                                        <span className="text-primary"> • </span>


                                    </div>
                                    <p className="text mb-4 mb-md-0">
                                        {description}
                                    </p>
                                </MDBCol>
                                <MDBCol
                                    md="6"
                                    lg="3"
                                    className="border-sm-start-none border-start"
                                >
                                    <div className="d-flex flex-row align-items-center mb-1">
                                        <h4 className="mb-1 me-1">AU${retail_price}</h4>

                                    </div>
                                    <h6 className="text-success">Free shipping</h6>
                                    <div className="d-flex flex-column mt-4">
                                        <MDBBtn color="success" size="sm" onClick={()=> addToCart(product,product.product_id)}>
                                            Add To Cart
                                        </MDBBtn>

                                    </div>
                                </MDBCol>
                            </MDBRow>
                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>
        </MDBContainer>
    );
};

