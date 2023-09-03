import React, { useState } from 'react';
import LoginForm from '../components/Register/LoginForm'
function Login() {
    const [loginData, setLoginData] = useState({ usernameOrEmail: '', password: '', twoFactorCode: '' });
    const [error, setError] = useState(null);
    const [needs2FA, setNeeds2FA] = useState(false);

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setLoginData({ ...loginData, [name]: value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        setError(null);

        try {
            const response = await fetch('http://localhost:8080/api/v1/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                },
                body: JSON.stringify({
                    usernameOrEmail: loginData.usernameOrEmail,
                    password: loginData.password,
                    twoFactorCode: loginData.twoFactorCode
                })
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
    };

    return (
        // <form onSubmit={handleSubmit}>
        //     <h1>Login</h1>
        //     {error && <p>{error}</p>}
        //     {needs2FA && (
        //         <div>
        //             <label htmlFor="twoFactorCode">Two-Factor Code:</label>
        //             <input type="text" name="twoFactorCode" value={loginData.twoFactorCode} onChange={handleInputChange} />
        //         </div>
        //     )}
        //     <label htmlFor="usernameOrEmail">Username or Email:</label>
        //     <input type="text" name="usernameOrEmail" value={loginData.usernameOrEmail} onChange={handleInputChange} />
        //     <br />
        //     <label htmlFor="password">Password:</label>
        //     <input type="password" name="password" value={loginData.password} onChange={handleInputChange} />
        //     <br />
        //     <button type="submit">Login</button>
        // </form>
        <LoginForm/>
    );
}

export default Login;
