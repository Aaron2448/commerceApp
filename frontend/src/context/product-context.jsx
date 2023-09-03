import React,{createContext,useState,useEffect} from 'react';
import axios from "axios"
export const ProductContext = createContext();

const ProductContextProvider = ({children}) => {

    const [products, setProducts] = useState([]);
    const [search,setsearch] = useState("")


    useEffect(() => {
        const fetchData = async () => {
            let result = await axios.get("http://localhost:8080/api/v1/product/getAll");
            console.log(result.data)
            setProducts(result.data);
        };
        fetchData();
    }, []);

    const searchHandler = (search) => {
        setsearch(search)
    }

    return (

        <ProductContext.Provider value={{products,searchHandler}}>{children}</ProductContext.Provider>
    );
};
export default ProductContextProvider;

