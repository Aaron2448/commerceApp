import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function Logout() {
    const navigate = useNavigate();

    useEffect(() => {
        const logoutUser = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/logout', {
                    method: 'POST',
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem('token')}`
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

        logoutUser();
    }, [navigate]);

    return null;
}

export default Logout;
