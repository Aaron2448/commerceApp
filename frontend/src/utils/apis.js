import axios from 'axios';
import { getCookie } from './cookies';

export const apis = {
    signup,
    login
}

const config = {
    headers: { Authorization: `Bearer ${getCookie('token')}` }
}
const instance = axios.create({
    baseURL: 'http://localhost:8080/api/v1/product/getAll'
})

function signup(username, email, password, first_name, last_name,role){
    return instance.post('/auth/signup', {email, first_name, last_name, password, role, username})
}
function login(username, password) {
    return instance.post('/auth/login', {username, password})
}
