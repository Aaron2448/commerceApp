import Carousel from 'react-bootstrap/Carousel';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme();
function Carousels() {
  return (
      <ThemeProvider theme={theme}>

          <CssBaseline/>
          <Box
              sx={{
                  bgcolor: 'radial-gradient(circle, rgba(174,201,238,1) 0%, rgba(33,42,54,1) 100%)',
                  pt: 8,
                  pb: 6,
                  background: 'radial-gradient(circle, rgba(174,201,238,0.2) 0%, rgba(33,42,54,0.2) 100%)',
              }}
          >
              <Container maxWidth="lg">
                  <Carousel fade>
                      <Carousel.Item>
                          <img
                              className="d-block w-100"
                              src="https://images.pexels.com/photos/3619877/pexels-photo-3619877.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                              alt="First slide"
                          />
                          <Carousel.Caption>
                              <h3>Action Camera DJI</h3>
                              <p>Explore our Classic and Best Seller Drones</p>
                          </Carousel.Caption>
                      </Carousel.Item>
                      <Carousel.Item>
                          <img
                              className="d-block w-100"
                              src="https://images.pexels.com/photos/7762139/pexels-photo-7762139.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                              alt="Second slide"
                          />

                          <Carousel.Caption>
                              <h3>Explore our Drone Products in Different Fields</h3>
                              <p>Learn More</p>
                          </Carousel.Caption>
                      </Carousel.Item>
                      <Carousel.Item>
                          <img
                              className="d-block w-100"
                              src="https://images.pexels.com/photos/7762152/pexels-photo-7762152.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
                              alt="Third slide"
                          />

                          <Carousel.Caption>
                              <h3>Compare Camera Drones</h3>
                              <p>
                                  See product overviews and comparisons here
                              </p>
                          </Carousel.Caption>
                      </Carousel.Item>
                  </Carousel>
              </Container>
          </Box>

      </ThemeProvider>

  );
}

export default Carousels;