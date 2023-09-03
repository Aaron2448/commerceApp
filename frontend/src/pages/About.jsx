import React from 'react';
import PropTypes from 'prop-types';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import Link from '@mui/material/Link';
import Box from '@mui/material/Box';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import FAQ from '../components/FAQ'
import Container from '@mui/material/Container';
//import ContactForm from '../components/ContactForm'

const theme = createTheme();

const About = () => {
    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Box
                sx={{
                    pt: 8,
                    pb: 6,
                }}
            >
                <Container maxWidth="lg">
                    <Paper
                        sx={{
                            position: 'relative',
                            backgroundColor: 'grey.800',
                            color: '#fff',
                            mb: 4,
                            backgroundSize: 'cover',
                            backgroundRepeat: 'no-repeat',
                            backgroundPosition: 'center',
                            backgroundImage: `url(https://images.pexels.com/photos/1336264/pexels-photo-1336264.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)`,

                        }}
                    >

                        <Box
                            sx={{
                                position: 'absolute',
                                top: 0,
                                bottom: 0,
                                right: 0,
                                left: 0,
                                backgroundColor: 'rgba(0,0,0,.3)',
                            }}
                        />
                        <Grid container>
                            <Grid item md={8}>
                                <Box
                                    sx={{
                                        position: 'relative',
                                        p: { xs: 3, md: 6 },
                                        pr: { md: 0 },
                                    }}
                                >
                                    <Typography component="h1" variant="h3" color="inherit" gutterBottom>
                                        About Us
                                    </Typography>
                                    <Typography variant="h6" color="inherit" gutterBottom>
                                        Flexdrone is an online retail business for the purchasing of public consumer-grade drones.
                                    </Typography>
                                    <Typography variant="h6" color="inherit" gutterBottom>
                                        Flexdrone gives flexibility to the customer's drone choice in three main ways:
                                    </Typography>
                                    <Typography variant="body1" color="inherit" gutterBottom>
                                        1. Choice to select a drone collection that is pre-made and ready to fly
                                    </Typography>
                                    <Typography variant="body1" color="inherit" gutterBottom>
                                        2. Option to build a drone on our website by going through our guided user-interface
                                    </Typography>
                                    <Typography variant="body1" color="inherit" gutterBottom>
                                        3. Buy accessories or specific parts to replace or upgrade on a pre-existing drone
                                    </Typography>
                                    <Typography variant="body1" color="inherit" gutterBottom>
                                        We source our products from manufacturers who meet standard Australian industry regulations and requirements.
                                    </Typography>
                                </Box>

                            </Grid>
                        </Grid>
                    </Paper>
                    <FAQ />

                </Container>
            </Box>
        </ThemeProvider>
    )
}

export default About