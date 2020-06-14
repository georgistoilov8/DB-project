
import React, { Component } from "react";

import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

const StyledTableCell = withStyles((theme) => ({
    head: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
    },
    body: {
      fontSize: 14,
    },
  }))(TableCell);




const Results = (props) => {

    return (
    <Table>
        <TableHead>
            <TableRow>
                
                {Object.keys(props.vehicles[0]).map ( (key) => (<StyledTableCell align = "right"> {key} </StyledTableCell>))}
            </TableRow>
        </TableHead>
        <TableBody>
      {props.vehicles.map((t) => (
           <TableRow>
        {Object.keys(t).map((key) => (
           
        <StyledTableCell component="th" scope="row" align = "right"> {t[key]} </StyledTableCell>
        ))}
        </TableRow>
            )
    )}
    </TableBody>
    </Table>
    );
}

export default Results