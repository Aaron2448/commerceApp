import React, { useState, useContext } from 'react'
import { ShopContext } from '../context/shop-context'
import { useNavigate } from 'react-router-dom'
const CustomerOrderDetails = () => {
    const navigate = useNavigate()
    const { cartItems, clearCart } = useContext(ShopContext)
    const [customer_id, setCustomerId] = useState('')
    const [address, setAddress] = useState('')
    const [email, setEmail] = useState('')
    const [payment_method, setPaymentMethod] = useState('')
    const handleSubmit = e => {
        e.preventDefault()
        const products = cartItems.map(item => ({
            sku: item.sku,
            retailPrice: item.retail_price,
            quantityInCart: item.quantity_in_cart,
        }))
        const orderObj = {
            
            address,
            email,
            payment_method,
            products,
        }
        fetch('http://localhost:8080/api/v1/order/createOrder', {
            method: 'POST',
            body: JSON.stringify(orderObj),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then(response => response.json())
            .then(data => {
                console.log(data)
                clearCart()
                navigate('/')
            })
            .catch(err => {
                console.log(err.message)
            })
    }
    return (
        <div>
            {' '}
            <form onSubmit={handleSubmit}>
                {' '}
               
                <label>Address:</label>{' '}
                <input
                    type="text"
                    name="address"
                    value={address}
                    onChange={e => setAddress(e.target.value)}
                />{' '}
                <label>Email:</label>{' '}
                <input type="text" name="email" value={email} onChange={e => setEmail(e.target.value)} />{' '}
                <label>Payment Method:</label>{' '}
                <input
                    type="text"
                    name="payment_method"
                    value={payment_method}
                    onChange={e => setPaymentMethod(e.target.value)}
                />{' '}
                <button type="submit">Place Order</button>{' '}
            </form>{' '}
        </div>
    )
}
export default CustomerOrderDetails
