import React, { useState, useEffect } from "react";

function SearchProducts() {
    const [keyword, setKeyword] = useState("");
    const [products, setProducts] = useState([]);

    const handleSearch = async () => {
        const response = await fetch(
            `http://localhost:8080/api/v1/product/search?keyword=${keyword}`
        );
        const data = await response.json();
        setProducts(data);
    };

    useEffect(() => {
        handleSearch();
    }, [keyword]);

    const highlightKeyword = (text) => {
        const regex = new RegExp(keyword, "gi");
        return text.replace(regex, (match) => `<span class="highlight">${match}</span>`);
    };

    return (
        <div>
            <input type="text" value={keyword} onChange={(e) => setKeyword(e.target.value)} />
            <table className="product-table">
                <thead>
                <tr>
                    <th>SKU</th>
                    
                    <th>Retail Price</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th>External Stock</th>
                    <th>Internal Stock</th>
                    <th>Min Stock Level</th>
                    <th>Is Part</th>
                    <th>External Note</th>
                    <th>Internal Note</th>
                    <th>Image URL</th>
                </tr>
                </thead>
                <tbody>
                {products.map((product) => (
                    <tr key={product.product_id}>
                        <td dangerouslySetInnerHTML={{ __html: highlightKeyword(product.sku) }} />
                        <td>{product.retail_price}</td>
                        <td dangerouslySetInnerHTML={{ __html: highlightKeyword(product.category) }} />
                        <td dangerouslySetInnerHTML={{ __html: highlightKeyword(product.name) }} />
                        <td>{product.external_stock}</td>
                        <td>{product.internal_stock}</td>
                        <td>{product.min_stock_level}</td>
                        <td>{product.is_part ? "Yes" : "No"}</td>
                        <td dangerouslySetInnerHTML={{ __html: highlightKeyword(product.external_note) }} />
                        <td dangerouslySetInnerHTML={{ __html: highlightKeyword(product.internal_note) }} />
                        <td>{product.image_url}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            <style>{`
        .product-table {
          border-collapse: collapse;
          border: 1px solid black;
          margin: 20px 0;
          padding: 5px;
        }

        .product-table th, .product-table td {
          border: 1px solid black;
          padding: 10px;
        }

        .highlight {
          background-color: yellow;
        }
      `}</style>
        </div>
    );
}

export default SearchProducts;
