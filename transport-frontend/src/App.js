import React, { Component } from "react";
import axios from "axios";
import InputLabel from "@material-ui/core/InputLabel"
import Select from "@material-ui/core/Select"
import MenuItem from "@material-ui/core/MenuItem"
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import FormControl from '@material-ui/core/FormControl';
import Results from "./Results";


class App extends Component {
  constructor () {
    super ();
    this.state = {
      vehicles: [],
      selectvalue : "",
      secondvalue : null,
      seeres: false ,
      seesecondvalue : false
    };
    this.onSubmit = this.onSubmit.
    bind(this);  
    this.handleChange = this.handleChange.bind(this);
  }
  onSubmit(e) {
    e.preventDefault();
  console.log(this.state.selectvalue);
    if (this.state.secondvalue === null){
    axios
      .get(`http://localhost:8080/${this.state.selectvalue}`)
      .then(res => {
        console.log(res.data);
        this.setState( () => ({ vehicles: res.data ,
                                   seeres: true  }));
        
      })
      .catch(err =>{
        throw err;
      });

    }
    else {
      if (this.state.selectvalue ===  "schedule" ) {
        axios
        .get(`http://localhost:8080/${this.state.selectvalue}/${this.state.secondvalue}`, {
          stopIds : [7824]
        })
        .then(res => {
          console.log(res.data);
          this.setState( () => ({ vehicles: res.data,
                                  seeres: true,
                                seesecondvalue : false,
                              secondvalue : null }));
        })
        .catch(err =>{
          throw err;
        });
      }
      else {
        axios
        .get(`http://localhost:8080/${this.state.selectvalue}/${this.state.secondvalue}/stop`)
        .then(res => {
          console.log(res.data);
          this.setState( () => ({ vehicles: res.data,
            seeres: true,
          seesecondvalue : false,
        secondvalue : null }));
        })
        .catch(err =>{
          throw err;
        });
      }
    }
}

handleChange(event) {
  console.log(event.target);
  if (event.target.value == "line" || event.target.value == "schedule")
    this.setState (() => ( {seesecondvalue : true }));
  event.persist();
  this.setState( () => ({[event.target.name] : event.target.value}));
};


  render() {
    return (
      <div className="App">
         <Container component="main" maxWidth="xs">
        <Typography component="h1" variant="h5">
             Make a query
            </Typography>
            <Grid container>
       <FormControl >
            <Grid item>
      <InputLabel id="label">View</InputLabel>
      <Select labelId="label" id="select" name = "selectvalue"    value = {this.state.selectvalue}
          onChange={this.handleChange}  fullWidth  >
        <MenuItem value={"line"}>Lines</MenuItem>
        <MenuItem value={"passenger"}>Passengers</MenuItem>
        <MenuItem value={"vehicle"}>Vehicles</MenuItem>
        <MenuItem value={"schedule"}>Schedule</MenuItem>
      </Select>
      {this.state.seesecondvalue ? <TextField
            id="lineid"
            name="secondvalue"
            label="lineid"
            value={this.state.secondvalue}
            onChange={this.handleChange}
            type="number"
            margin="normal"
          /> : null }
      </Grid>
      <Grid item >
      <Button
                type="submit"
                variant="contained"
                color="primary"
                style={{margin: 25}}
                onClick={this.onSubmit}
              > View </Button>
              </Grid>
              </FormControl>
              </Grid>
              <div >
             { this.state.seeres ? <Results vehicles = {this.state.vehicles} /> : null }
        </div>
      </Container>
      
      </div>
      

    );
  }
}

export default App;
