import React from 'react';
import { DarkModeOutlined, LightModeOutlined } from '@mui/icons-material';

const ChangeMode = ({theme}) =>{

    return (theme.palette.mode === 'dark' ? (
        <DarkModeOutlined sx={{ fontSize: "25px"}} />
    ) : (
        <LightModeOutlined sx={{fontSize: "25px"}} />
    )
    )
}

export default ChangeMode;
