import React, {useContext} from "react";
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import Autocomplete from '@mui/material/Autocomplete';
import {ProductContext} from '../../context/product-context'
import {Link} from 'react-router-dom'
import SearchIcon from '@mui/icons-material/Search';
import InputBase from '@mui/material/InputBase';
import Paper from '@mui/material/Paper';
import IconButton from '@mui/material/IconButton';


export default function Searchbar() {
    const{products} = useContext(ProductContext)

    return (
        <Stack  sx={{ width: 800,justifyContent:"center"}}>
            <Paper
                component="form"

            >
                <InputBase
                    sx={{ ml: 14, flex: 1 }}
                    placeholder="Search Google Maps"
                    inputProps={{ 'aria-label': 'search google maps' }}
                />
                <IconButton type="button" sx={{ p: '10px' }} aria-label="search">
                    <SearchIcon />
                </IconButton>

            </Paper>

        </Stack>
    );
}