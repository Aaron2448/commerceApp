import React from "react";
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import "./App.css";
import Header from "./components/Common/Header";
import Home from "./pages/Home";
import Customise from "./pages/Customise";
import Collection from "./pages/Collection";
import Parts from "./pages/Parts";
import Register from "./pages/Register";
import Login from "./pages/Login";
import Logout from "./pages/Logout";
import About from "./pages/About";
import Dashboard from "./pages/Dashboard"
import UserProfile from "./pages/Profile";
import Footer from './components/Common/Footer'
import ShoppingCart from './pages/ShoppingCart'
import TwoFactorAuth from "./pages/TwoFactorAuth";
import DisableTwoFactorAuth from "./pages/DisableTwoFactorAuth";
import Support from "./pages/Support";
import ProductDetail from './pages/ProductDetail'
import UserSupport from "./pages/UserSupport";
import CustomerOrderDetails from './pages/CustomerOrderDetails'
import Checkout from './pages/Checkout'
import MyOrders from './pages/MyOrders'
import UserOrders from "./pages/Search/Orders/UserOrders";
import OrderProducts from "./pages/Search/Orders/OrderProducts";
import SearchProducts from "./pages/Search/SearchProduct";


function App() {
    // axios.defaults.baseURL = "http://localhost:8080/api/v1";
    // axios.defaults.withCredentials = true;
    // axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";
    // axios.defaults.headers.common["Access-Control-Allow-Methods"] =
    //     "GET, POST, PUT, DELETE, OPTIONS";
    // axios.defaults.headers.common["Access-Control-Allow-Headers"] =
    //     "Authorization,Content-Type,Origin,X-Requested-With,Accept";

	//Router.events.on('routeChangeStart', (url)=> {
	//	console.log('Page is loading...');
	//})


    return (
        <BrowserRouter>
            <Header/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="collection" element={<Collection/>}/>
                <Route path="customise" element={<Customise/>}/>
                <Route path="parts" element={<Parts/>}/>
                <Route path="about" element={<About/>}/>
                <Route path="login" element={<Login/>}/>
                <Route path="Logout" element={<Logout/>}/>
                <Route path="register" element={<Register/>}/>
                <Route path="dashboard" element={<Dashboard/>}/>
                <Route path="profile" element={<UserProfile/>}/>
                <Route path='cart' element={<ShoppingCart/>}/>
                <Route path='checkout' element={<Checkout/>}/>
                <Route path="/2fa" element={<TwoFactorAuth/>}/>
                <Route path="/disable" element={<DisableTwoFactorAuth/>}/>
                <Route path="/support" element={<Support/>}/>
                <Route path="/product-detail/:id" element={<ProductDetail/>}/>
                <Route path="/user-support" element={<UserSupport/>}/>
                <Route path="/order" element={<CustomerOrderDetails/>}/>
				<Route path="/myorders" element={<MyOrders/>}/>
				<Route path="/userOrders" element={<UserOrders/>}/>
                <Route path="/userOrders/:orderId" element={<OrderProducts />} />
                <Route path="/search/" element={<SearchProducts />} />
            </Routes>
            <Footer/>
        </BrowserRouter>


    );
}

export default App;
