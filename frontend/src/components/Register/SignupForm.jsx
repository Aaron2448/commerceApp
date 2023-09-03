import React, {useState} from 'react';
import axios from 'axios';
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import { Link } from "react-router-dom";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import {FormHelperText} from "@mui/material";
import Alert from "@mui/material/Alert";

const Signup = () => {
    const [name, setName] = useState('');
    const [fName, setFName] = useState('');
    const [lName, setLName] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [nameError, setNameError] = useState('');
    const [usernameError, setUsernameError] = useState('');
    const [emailError, setEmailError] = useState('');
    const [passwordError, setPasswordError] = useState([]);
    const [successMessage, setSuccessMessage] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const payload = {
            name: name,
            username: username,
            email: email,
            password: password,
        };

        try {
            const response = await axios.post(
                'http://localhost:8080/api/v1/auth/register',
                payload
            );
            console.log(response.data);
            setName('');
            setUsername('');
            setEmail('');
            setPassword('where is the name');
            setNameError('');
            setUsernameError('');
            setEmailError('');
            setPasswordError([]);
            setSuccessMessage('User registered successfully!');
        } catch (error) {
            const response = error.response.data;
            console.log(response);

            if (response.message.includes('Name')) {
                setNameError(response.message);
            } else {
                setNameError('');
            }

            if (response.message.includes('Username')) {
                setUsernameError(response.message);
            } else {
                setUsernameError('');
            }

            if (response.message.includes('Email')) {
                setEmailError(response.message);
            } else {
                setEmailError('');
            }

            if (response.message.includes('Password should contain')) {
                setPasswordError(
                    response.message.split(': ')[1].split('. ').filter(Boolean)
                );
            } else {
                setPasswordError([]);
            }
        }
    };

    const passwordRequirements = [
        {
            id: 'lowercase',
            condition: /(?=.*[a-z])/,
            message: 'Password should contain at least one lowercase letter.',
        },
        {
            id: 'uppercase',
            condition: /(?=.*[A-Z])/,
            message: 'Password should contain at least one uppercase letter.',
        },
        {
            id: 'digit',
            condition: /(?=.*[0-9])/,
            message: 'Password should contain at least one digit.',
        },
        {
            id: 'special',
            condition: /(?=.*[!@#$%^&*()-+=])/,
            message: 'Password should contain at least one special character.',
        },
        {
            id: 'length',
            condition: /.{10,}/,
            message: 'Password should be at least 10 characters long.',
        },
    ];

    const checkPasswordRequirements = (password) => {
        const messages = passwordRequirements
            .filter((requirement) => !requirement.condition.test(password))
            .map((requirement) => requirement.message);

        return messages;
    };

    const handlePasswordBlur = (event) => {
        const passwordValue = event.target.value;
        const passwordErrors = checkPasswordRequirements(passwordValue);

        setPasswordError(
            passwordErrors.filter((message) => !message.endsWith('met.'))
        );
    };

    return (
        <Grid container component="main" sx={{ height: "100vh" }}>
            <CssBaseline />
            <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
                <Box
                    sx={{
                        my: 8,
                        mx: 4,
                        display: "flex",
                        flexDirection: "column",
                        alignItems: "center",
                    }}
                >
                    <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
                        <LockOutlinedIcon />
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign up
                    </Typography>

                    <form onSubmit={handleSubmit}>
                        <Box component="div" noValidate sx={{ mt: 3 }}>
                            <Grid container spacing={2}>
                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        fullWidth
                                        id="name"
                                        label="Name"
                                        name="name"
                                        autoComplete="name"
                                        value={name}
                                        onChange={(e) => setName(e.target.value)}
                                    />
                                    {nameError && <FormHelperText error>{nameError}</FormHelperText>}
                                </Grid>
                        
                        
                        
                        
                        
                        
                        
                        

                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        fullWidth
                                        id="username"
                                        label="Username"
                                        name="username"
                                        autoComplete="username"
                                        value={username}
                                        onChange={(e) => setUsername(e.target.value)}
                                    />
                                    {usernameError && (
                                        <FormHelperText error>{usernameError}</FormHelperText>
                                    )}
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        fullWidth
                                        id="email"
                                        label="Email Address"
                                        name="email"
                                        autoComplete="email"
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}
                                    />
                                    {emailError && (
                                        <FormHelperText error>{emailError}</FormHelperText>
                                    )}
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField
                                        required
                                        fullWidth
                                        name="password"
                                        label="Password"
                                        type="password"
                                        id="password"
                                        autoComplete="new-password"
                                        value={password}
                                        onChange={(event) => setPassword(event.target.value)}
                                        onBlur={handlePasswordBlur}
                                    />
                                    {passwordError.length > 0 && (
                                        <FormHelperText error>
                                            {passwordError.map((message, index) => (
                                                <div key={index}>
                                                    {message.endsWith("met.") && (
                                                        <span style={{ color: "green" }}>✓</span>
                                                    )}
                                                    {!message.endsWith("met.") && (
                                                        <span style={{ color: "red" }}>✗</span>
                                                    )}
                                                    {message}
                                                </div>
                                            ))}
                                        </FormHelperText>
                                    )}
                                </Grid>
                            </Grid>
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                sx={{ mt: 3, mb: 2 }}
                            >
                                Sign Up
                            </Button>
                            {successMessage && (
                                <Alert severity="success" sx={{ mb: 2 }}>
                                    {successMessage}
                                </Alert>
                            )}
                            <Grid container justifyContent="flex-end">
                                <Grid item>
                                    <Link to="/login" variant="body2">
                                        Already have an account? Sign in
                                    </Link>
                                </Grid>
                            </Grid>
                        </Box>
                    </form>
                </Box>
            </Grid>
            <Grid
                item
                xs={false}
                sm={4}
                md={7}
                sx={{
                    backgroundImage:
                        "url(https://images.pexels.com/photos/1093236/pexels-photo-1093236.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)",
                    backgroundRepeat: "no-repeat",
                    backgroundColor: (t) =>
                        t.palette.mode === "light"
                            ? t.palette.grey[50]
                            : t.palette.grey[900],
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                }}
            />
        </Grid>
    );
};

export default Signup;
