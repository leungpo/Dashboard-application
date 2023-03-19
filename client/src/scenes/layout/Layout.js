import React,{ useState } from 'react';
import { Box, useMediaQuery } from '@mui/material';
import { Outlet } from 'react-router-dom';
import { useSelector } from 'react-redux';
import NavBar from "components/NavBar";
import SideBar from "components/SideBar";

export default function Layout() {
    const isNonMobile = useMediaQuery("(min-width: 600px)"); // check is mobile or not by using the screen width
    const[isSidebarOpen, setIsSidebarOpen] = useState(true);
    return (
    <Box display={isNonMobile ? "flex": "block"} width="100%" height="100%">  
        <SideBar
            isNonMobile={isNonMobile}
            drawerWidth="250px"
            isSidebarOpen={isSidebarOpen}
            setIsSidebarOpen={setIsSidebarOpen}
        />
        <Box>
            <NavBar 
                isSidebarOpen={isSidebarOpen}
                setIsSidebarOpen={setIsSidebarOpen}
            />
            <Outlet />
        </Box>
    </Box>
  )
};
