import React, { useState, useEffect,useContext } from "react";
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {
    MDBRow,
    MDBCol,

} from "mdb-react-ui-kit";
import {Link} from 'react-router-dom'
import Cards from '../Cards'
import {ProductContext} from '../../context/product-context'


const theme = createTheme();

export default function BaseModel() {
    const{products} = useContext(ProductContext)

    //Filter products array by category of collection
    const filteredProducts = products.filter(product => {
        return (
            product.category === "base"
        )
    })

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Box
                sx={{
                    bgcolor: 'background.paper',
                    pt: 8,
                    pb: 6,
                }}
            >
                <Container maxWidth="lg">
                    <MDBRow>

                        {filteredProducts.map((product) => (
                            <MDBCol md="12" lg="4" className="mb-4 mb-lg-0" key={product.name} >
                                <Cards key={product.product_id} product={product}/>
                            </MDBCol>
                        ))}
                    </MDBRow>
                </Container>

            </Box>
        </ThemeProvider>
    );
}