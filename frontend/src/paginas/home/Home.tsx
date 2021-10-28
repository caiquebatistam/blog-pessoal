import React from "react";
import { Typography, Box, Grid, Button } from "@material-ui/core";
import "./Home.css";

function Home() {
    return (
        <>
        <Grid container direction="row" justifyContent="center" alignItems="center" style={{ backgroundColor: "#778899" }} >
            <Grid alignItems="center" item xs={6}>
                <Box paddingX={20} >
                    <Typography variant="h3" gutterBottom color="textPrimary" component="h3" align="center" style={{ color: "white", fontWeight: "bold" }}>Dev Batistam!</Typography>
                    <Typography variant="h5" gutterBottom color="textPrimary" component="h5" align="center" style={{ color: "white", fontWeight: "bold" }}>expresse aqui os seus pensamentos e opiniões!</Typography>
                </Box>
                <Box display="flex" justifyContent="center">
                    <Box marginRight={1}>
                    </Box>
                    <Button variant="outlined" style={{ borderColor: "white", backgroundColor: "#000000", color: "white" }}>Ver Postagens</Button>
                </Box>
            </Grid>
            <Grid item xs={6} >
                <img src="https://imgur.com/nv9uxEF.png" alt="" width="600px" height="600px" />
            </Grid>
            <Grid xs={12} style={{ backgroundColor: "white" }}>
            </Grid>
        </Grid>
    </>
);
}
export default Home;