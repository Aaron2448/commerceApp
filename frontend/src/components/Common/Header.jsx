import React, {useContext, useEffect, useState} from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import FlightTakeoffIcon from '@mui/icons-material/FlightTakeoff';
import { Link, useNavigate } from 'react-router-dom';
import { styled, alpha } from '@mui/material/styles';
import SearchIcon from '@mui/icons-material/Search';
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import InputBase from '@mui/material/InputBase';
import { Badge } from "@mui/material";
import { ShopContext } from '../../context/shop-context'
import { ProductContext } from '../../context/product-context'
import Searchbar from './Searchbar'
const pages = ['Collection', 'Customise', 'Parts', 'About', 'Support'];
const userNotLoggedIn = ['Register', 'Login'];
const userLoggedIn = ['Profile','Logout'];
const user = localStorage.getItem('token') ? ['Logout'] : ['Register', 'Login'];
const handleLogout = () => {
  localStorage.removeItem('token');
};

function Header() {

    const navigate = useNavigate();
    const jwt = localStorage.getItem('token');
    const [anchorElNav, setAnchorElNav] = React.useState(null);
    const [anchorElUser, setAnchorElUser] = React.useState(null);
    const [user, setUser] = useState({});
    const [products, setProducts] = useState([]);


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
                } else {
                    throw new Error('Failed to fetch user profile');
                }
            } catch (error) {
                console.error(error);
            }
        };

        fetchUser();
    }, []);

    const handleLogout = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/auth/logout', {
                method: 'POST',
                headers: {
                    'Authorization': `Bearer ${jwt}`
                }
            });

            if (response.ok) {
                localStorage.removeItem('token');
                navigate('/');
                window.location.reload();
            } else {
                throw new Error('Failed to logout user');
            }
        } catch (error) {
            console.error(error);
        }
    };

    const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
    const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

    const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };
    const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };
    const {itemAmount,cartItems} = useContext(ShopContext)

  return (
    <AppBar position="static" style={{ background: '#edf6f9' }}>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <FlightTakeoffIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1, color: 'black' }} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'black',
              textDecoration: 'none',
            }}
          >
            FlexDrone
          </Typography>

          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}
            >

              {pages.map((page) => (
                <MenuItem key={page} onClick={handleCloseNavMenu}>
                  <Typography textAlign="center">
                    <Link style={{ textDecoration: 'none', color: "black" }} to={`/${page}`}>
                      {page}
                    </Link>
                  </Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          <FlightTakeoffIcon sx={{ display: { xs: 'flex', md: 'none' }, mr: 1, color: 'black' }} />
          <Typography
            variant="h5"
            noWrap
            component="a"
            href=""
            sx={{
              mr: 2,
              display: { xs: 'flex', md: 'none' },
              flexGrow: 1,
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'black',
              textDecoration: 'none',
            }}
          >
            FlexDrone
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page}
                onClick={handleCloseNavMenu}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                <Link style={{ textDecoration: 'none', color: "black" }} to={`/${page}`}>
                  {page}
                </Link>
              </Button>
            ))}
          </Box>
          <Box sx={{ flexGrow: 0 }}>
            <Tooltip title="Checkout">
              <IconButton sx={{ p: 1 }}>

                      <Badge badgeContent={itemAmount} color="error">
                         <Link to='checkout' >
                             <ShoppingBagIcon/>
                         </Link>
                      </Badge>
              </IconButton>
            </Tooltip>
            <Tooltip title="User Account">
              <IconButton onClick={handleOpenUserMenu} sx={{ p: 1 }}>
                <AccountCircleIcon />
                  {user.first_name}
              </IconButton>
            </Tooltip>
            <Menu
              sx={{ mt: '45px' }}
              id="menu-appbar"
              anchorEl={anchorElUser}
              anchorOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              open={Boolean(anchorElUser)}
              onClose={handleCloseUserMenu}
            >
                {!jwt && (
                    <>
                        {userNotLoggedIn.map((setting) => (
                            <MenuItem key={setting} onClick={handleCloseUserMenu}>
                                <Typography textAlign="center">
                                    <Link style={{ textDecoration: 'none', color: "black" }} to={`/${setting}`}>
                                        {setting}
                                    </Link></Typography>
                            </MenuItem>
                        ))}
                    </>
                )}
                {jwt && (
                    <>
                        {userLoggedIn.map((setting) => (
                            <MenuItem key={setting} onClick={handleCloseUserMenu}>
                                <Typography textAlign="center">
                                    <Link style={{ textDecoration: 'none', color: "black" }} to={`/${setting}`}>
                                        {setting}
                                    </Link></Typography>
                            </MenuItem>
                        ))}
                    </>
                )}

            </Menu>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>

  );
}
export default Header