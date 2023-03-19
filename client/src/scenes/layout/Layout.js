import React,{ useState } from 'react';
import { Box, useMediaQuery } from '@mui/material';
import { Outlet } from 'react-router-dom';
import { useSelector } from 'react-redux';
import NavBar from "components/NavBar";
export default function Layout() {
  return (
    <Box width="100%" height="100%">  
        <Box>
            <NavBar />
            <Outlet />
        </Box>
    </Box>
  )
};
