import React,{createContext,useState,useEffect} from 'react';
import axios from "axios"
export const UserContext = createContext();



const UserContextProvider = ({children}) => {

    const [user, setUser] = useState({});

    useEffect(() => {

        const fetchUser = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/profile', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
                });

                if (response.ok) {
                    const data = await response.json();
                    setUser(data);

                }
            } catch (error) {
                console.error(error);
            }
        };

        fetchUser();
    }, []);

    return (

        <UserContext.Provider value={{user}}>{children}</UserContext.Provider>
    );
};
export default UserContextProvider;
            
               

