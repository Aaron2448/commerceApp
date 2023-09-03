import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UserOrders() {
    const [orders, setOrders] = useState([]);
    const [user, setUser] = useState(null);

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token) {
            const fetchUser = async () => {
                try {
                    const response = await axios.get('http://localhost:8080/api/v1/auth/profile', {
                        headers: {
                            Authorization: `Bearer ${token}`
                        }
                    });
                    setUser(response.data);
                } catch (error) {
                    console.error(error);
                }
            };
            fetchUser();

            const fetchOrders = async () => {
                try {
                    const response = await axios.get('http://localhost:8080/api/v1/order/myOrder', {
                        headers: {
                            Authorization: `Bearer ${token}`
                        }
                    });
                    console.log(orders)
                    setOrders(response.data);
                } catch (error) {
                    console.error(error);
                }
            };
            fetchOrders();
        }
    }, []);

    if (!user) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h1>My Orders ({user.email})</h1>
            <table>
                <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Status</th>
                    <th>Address</th>
                    <th>Order At</th>
                    <th>Email</th>
                    <th>Payment Method</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
                {orders.map((order) => (
                    <tr key={order.order_id}>
                        <td style={{border: "1px solid black"}}>{order.order_id}</td>
                        <td style={{border: "1px solid black"}}>{order.customer_id}</td>
                        <td style={{border: "1px solid black"}}>{order.status}</td>
                        <td style={{border: "1px solid black"}}>{order.address}</td>
                        <td style={{border: "1px solid black"}}>{order.order_at}</td>
                        <td style={{border: "1px solid black"}}>{order.email}</td>

                        <td style={{border: "1px solid black"}}>{order.payment_method}</td>
                        <td style={{border: "1px solid black"}}>{order.dispatched_on}</td>
                        <td style={{border: "1px solid black"}}>
                            <Link to={`/userOrders/${order.order_id}`}>
                                <button>View</button>
                            </Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default UserOrders;
