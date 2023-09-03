import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function OrderProducts() {
    const [products, setProducts] = useState([]);
    const [order, setOrder] = useState(null);
    const { orderId } = useParams();

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token) {
            const fetchOrder = async () => {
                try {
                    const response = await axios.get(`http://localhost:8080/api/v1/order/myOrder/id/${orderId}`, {
                        headers: {
                            Authorization: `Bearer ${token}`,
                        },
                    });
                    setOrder(response.data);
                } catch (error) {
                    console.error(error);
                }
            };
            fetchOrder();

            const fetchProducts = async () => {
                try {
                    const response = await axios.get(`http://localhost:8080/api/v1/order/myOrder/id/${orderId}`, {
                        headers: {
                            Authorization: `Bearer ${token}`,
                        },
                    });
                    setProducts(response.data);
                } catch (error) {
                    console.error(error);
                }
            };
            fetchProducts();
        }
    }, [orderId]);

    if (!order) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>Product Order ID</th>
                    <th>Order ID</th>
                    <th>Product ID</th>
                    <th>Quantity</th>
                    <th>SKU</th>
                    <th>Sold Price</th>
                </tr>
                </thead>
                <tbody>
                {products.map((product) => (
                    <tr key={product.product_order_id}>
                        <td style={{border: "1px solid black"}}>{product.product_order_id}</td>
                        <td style={{border: "1px solid black"}}>{product.order_id}</td>
                        <td style={{border: "1px solid black"}}>{product.product_id}</td>
                        <td style={{border: "1px solid black"}}>{product.quantity}</td>
                        <td style={{border: "1px solid black"}}>{product.sku}</td>
                        <td style={{border: "1px solid black"}}>{product.sold_price}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}


export default OrderProducts;
