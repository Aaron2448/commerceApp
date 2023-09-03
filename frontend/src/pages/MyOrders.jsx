import React,{useEffect,useState} from 'react';
import axios from "axios"
import {MDBCol, MDBRow,MDBBadge, MDBBtn, MDBTable, MDBTableHead, MDBTableBody,MDBContainer} from "mdb-react-ui-kit";
import Cards from "../components/Cards";
const MyOrders = () => {
    const [orders, setOrders] = useState([]);

    useEffect(() => {

        const fetchData = async () => {
            let res = await axios.get("http://localhost:8080/api/v1/order/getAll")
            console.log(res.data)
            setOrders(res.data)
        }
        fetchData();
    }, []);

    return (
        <div>
            <MDBTable align='middle'>
                <MDBTableHead>
                    <tr>
                        <th scope='col'>Order</th>
                        <th scope='col'>CustomerId</th>
                        <th scope='col'>Address</th>
                        <th scope='col'>Order Date</th>
                        <th scope='col'>Payment Method</th>
                        <th scope='col'>Status</th>
                    </tr>
                </MDBTableHead>
                <MDBTableBody>
                    {orders.map((order) => (<tr key={order.order_id}>

                        <td>
                            <div className='d-flex align-items-center'>
                                <div className='ms-3'>
                                    <p className='fw-bold mb-1'>{order.order_id}</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            {order.customer_id}
                        </td>
                        <td>
                            <p className='fw-normal mb-1'>{order.address}</p>
                        </td>
                        <td>
                            {order.order_at}
                        </td>
                        <td>
                            {order.payment_method}
                        </td>
                        <td>
                            <MDBBadge color='success' pill>
                                {order.status}
                            </MDBBadge>
                        </td>
                    </tr>))}
                </MDBTableBody>
            </MDBTable>
        </div>
    );
};

export default MyOrders;
