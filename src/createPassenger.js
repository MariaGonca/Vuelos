import React from 'react';
import axios from 'axios';

export default class CreatePassenger extends React.Component {
  state = {
    passname: '',
    unsername: '',
    nationality: '',
    identification: '',
    age: ''
  }

  handleChangeName = event => {
    this.setState({ passname: event.target.value });;
  }
  handleChangeUserN = event => {
    this.setState({ unsername: event.target.value });
  }
  handleChangeNation = event => {
    this.setState({ nationality: event.target.value });
  }
  handleChangeIden = event => {
    this.setState({ identification: event.target.value });
  }
  handleChangeAge = event => {
    this.setState({ age: event.target.value });
  }

  handleSubmit = event => {
    event.preventDefault();

    const passenger = {
        name: this.state.passname,
        unsername: this.state.unsername,
        nationality: this.state.nationality,
        identification: this.state.identification,
        age: this.state.age
    };

    axios.post(`http://localhost:8080/api/passenger/`,  passenger )
      .then(res => {
        console.log(this.age);
        console.log(this.passname);
        console.log(res);
        console.log(res.data);
      })
  }

  render() {
    return (

        <div className="shadow-lg p-3 mb-5 bg-white rounded">
            {/* Passenger Form */}
            <h2> Passenger Creation </h2>
            <form  onSubmit={this.handleSubmit}>
            <div className="row">
                <div className="col-25">
                    <label htmlFor="passname">Name</label>
                </div>
                <div className="col-75">
                    <input type="text" onChange={this.handleChangeName} id="passname" name="passname" placeholder="Your Firstname"/>
                </div>
            </div>

            <div className="row">
                <div className="col-25">
                  <label htmlFor="unsername">Surname</label>
                </div>
                <div className="col-75">
                    <input type="text" onChange={this.handleChangeUserN} id="unsername" name="unsername" placeholder="Your Family name"/>
                </div>
            </div>

            <div className="row">
                <div className="col-25">
                    <label htmlFor="nationality">Nationality</label>
                </div>
                <div className="col-75">
                    <input type="text" onChange={this.handleChangeNation} id="nationality" name="nationality" placeholder="Your nationality"/>
                </div>
            </div>

            <div className="row">
                <div className="col-25">
                    <label htmlFor="identification">Identification</label>
                </div>
                <div className="col-75">
                    <input type="text" onChange={this.handleChangeIden} id="identification" name="identification" placeholder="Your identification"/>
                </div>
            </div>

            <div className="row">
                <div className="col-25">
                    <label htmlFor="age">Age</label>
                </div>
                <div className="col-75">
                    <input type="text" onChange={this.handleChangeAge} id="age" name="age" placeholder="Your age"/>
                </div>
            </div>

            <div className="row mt-3">
                <div className="elementCenter">
                    <input type="submit" value="Submit"/>
                </div>
            </div> 
            </form>
        </div>
        )
    }
}