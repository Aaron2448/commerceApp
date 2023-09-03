import React,{createContext,useState,useEffect} from 'react';

export const ShopContext = createContext();

const ShopContextProvider = ({children}) => {
    
    var sumTotal = 0;
    const [cartItems,setCartItems] = useState([]);
    //item amount state
    const [itemAmount, setItemAmount] = useState(0);
    //total price state
    const [total, setTotal] = useState(0);

    //uupdate number of items in shopping cart
    useEffect(() => {
        if (cartItems){
            const amount = cartItems.reduce((accumulator, currentItem) =>
            {
                return accumulator + currentItem.amount
            }, 0)
            setItemAmount(amount)
        }
    }, [cartItems]);

    useEffect(() => {
            const total = cartItems.reduce((accumulator, currentItem) =>
            {
                return accumulator + currentItem.retail_price * currentItem.amount
            }, 0)
            setTotal(total)
    });

    const addToCart = (product,product_id) => {
        
        const newItem = {...product,amount:1}
       
        const cartItem = cartItems.find((item) => {
            
            return item.product_id === product_id;
            
    	})

        if (cartItem) {
			
            const newCart = [...cartItems].map((item) => {
				
                if (item.product_id === product_id){
                    return {...item,amount: cartItem.amount + 1}
                } else {
                    return item
                }
            })

            console.log(newCart)
            setCartItems(newCart);
        } else {
            setCartItems([...cartItems,newItem])
        }
    }

    const clearCart = () =>{
        setCartItems([]);
    }
    
    const minusFromCart = (product_id) => {
        const cartItem = cartItems.find((item) => {
            return item.product_id === product_id;
    	})
        if (cartItem) {
			
            const newCart = cartItems.map((item) => {
				
                if (item.product_id === product_id){
					
                    return {...item,amount: cartItem.amount - 1}
                    
                } else {
					
                    return item
                }
                
            })
            setCartItems(newCart);
        }

            if (cartItem.amount < 2){
                removeFromCart(product_id);
            }
    }

    const removeFromCart = (product_id) => {
        const newCart = cartItems.filter(item => {
            return item.product_id !== product_id;

        })
        setCartItems(newCart)
    }
  
    return (
		
        <ShopContext.Provider value={{cartItems, addToCart, minusFromCart,removeFromCart,itemAmount,total,clearCart}}>{children}</ShopContext.Provider>
        
    );

};

export default ShopContextProvider;

