import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { Link } from "react-router-dom";
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import {useState} from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { getCookie, setCookie } from '../../utils/cookies';
import { apis } from '../../utils/apis';
import { ConstructionOutlined } from '@mui/icons-material';
import {getUserId, isLoggedIn} from '../../utils/cookies.js';
import Alert from '@mui/material/Alert';


const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

export default function SignInSide() {
    const navigate = useNavigate();
    const[usernameOrEmail,setUsernameOrEmail] = useState('');
    const[password,setPassword] = useState('');
    const [twoFactorCode, setTwoFactorCode] = useState('');
    const [needs2FA, setNeeds2FA] = useState(false);
    const [loginData, setLoginData] = useState({ usernameOrEmail: '', password: '', twoFactorCode: '' });
    const [error, setError] = useState(null);

    const handleClick = async (e) => {
        e.preventDefault();
        const user={usernameOrEmail,password,twoFactorCode}
        console.log(user);
        setError(null);

        try {
            const response = await fetch('http://localhost:8080/api/v1/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            });

            if (response.ok) {
                const { accessToken } = await response.json();
                localStorage.setItem('token', accessToken);
                window.location.href = '/profile'; // Redirect to dashboard
            } else {
                const { message } = await response.json();
                if (message === "Two-factor code is required!") {
                    setNeeds2FA(true);
                }
                setError(message);
            }
        } catch (error) {
            console.error(error);
            setError('An error occurred while logging in. Please try again later.');
        }
      }

  return (

      <Grid container component="main" sx={{ height: '100vh' }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage: 'url(https://images.pexels.com/photos/1093236/pexels-photo-1093236.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)',
            backgroundRepeat: 'no-repeat',
            backgroundColor: (t) =>
              t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
            backgroundSize: 'cover',
            backgroundPosition: 'center',
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={12} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Sign in
            </Typography>
              <Box
                  component="form"
                  noValidate
                  sx={{ mt: 3 }}
              >
                  <Box
                      component="form"
                      noValidate
                      sx={{ mb: 3 }}
                  >
                  {error &&<Alert severity="error">{error}</Alert>}
                  </Box>

                <TextField
                    required
                    fullWidth
                    id="username"
                    label="Username"
                    name="username"
                    autoComplete="username"
                    value={usernameOrEmail}
                    onChange={(e)=>setUsernameOrEmail(e.target.value)}
                />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="new-password"
                value={password}
                onChange={(e)=>setPassword(e.target.value)}
              />
                  <Box
                      component="form"
                      noValidate
                      sx={{ mb: 3 }}
                  >
                      {needs2FA && (
                          <TextField
                              required
                              fullWidth
                              id="twoFactorCode"
                              label="Two Factor Code"
                              name="twoFactorCode"
                              value={twoFactorCode}
                              onChange={(e)=>setTwoFactorCode(e.target.value)}
                          />
                      )}
                  </Box>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
                onClick={handleClick}
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item xs>
                  <Link href=".#" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Link to="/register" variant="body2">
                    {"Don't have an account? Sign Up"}
                  </Link>
                </Grid>
              </Grid>
          </Box>
          </Box>
        </Grid>
      </Grid>

  );
}