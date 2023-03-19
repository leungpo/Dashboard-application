import React,{ useState } from 'react';
import { Box, useMediaQuery } from '@mui/material';
import { Outlet } from 'react-router-dom';
import { useSelector } from 'react-redux';
import NavBar from "components/NavBar";
import SideBar from "components/SideBar";

export default function Layout() {
    const isNonMobile = useMediaQuery("(min-width: 600px)"); // check is mobile or not by using the screen width
  return (
    <Box width="100%" height="100%">  
        <Box>
            <NavBar />
            <Outlet />
        </Box>
    </Box>
  )
};
