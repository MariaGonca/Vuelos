import React from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
//Datatable Modules
import "datatables.net-dt/js/dataTables.dataTables"
import "datatables.net-dt/css/jquery.dataTables.min.css"
import $ from 'jquery'; 

export default class ChoosePlace extends React.Component {
    state = {
        persons: [],
        LIST: [
            { flight_id: "1", idAirline: "1", scale: "y", luggage: "y", departure: "01/01/2022", arrival: "04/01/2022", price: "10" },
            { flight_id: "2", idAirline: "2", scale: "y", luggage: "n", departure: "02/02/2022", arrival: "05/02/2022", price: "10" },
            { flight_id: "3", idAirline: "3", scale: "n", luggage: "y", departure: "03/03/2022", arrival: "06/03/2022", price: "10" },
            { flight_id: "4", idAirline: "4", scale: "y", luggage: "y", departure: "04/04/2022", arrival: "07/04/2022", price: "10" },
            { flight_id: "5", idAirline: "5", scale: "n", luggage: "n", departure: "05/05/2022T16:00", arrival: "08/05/2022", price: "10" }
        ]

    }
    


    /* Used to get the list of places that already exists so input can be dropdown */
    componentDidMount() {
        axios.get(`http://localhost:8080/api/places`)
            .then(res => {
                const persons = res.data;
                this.setState({ persons });
            })
            $(document).ready(function () {
                $('#myTable').DataTable();
            });
    }


    oneWaySub = e => this.setState({ agreement: e.target.checked });
    oneWayChange = e => {
        e.preventDefault();
        console.log(`checked: ${this.state.agreement}`);
    };

    render() {
        return (

            <div>
                <h2>List</h2>
                <div className='shadow-lg p-3 mb-5 bg-white rounded'>
                    <h3 className="p-3 text-center">React - Display a list of items</h3>
                    <table className="table table-striped table-bordered" id='myTable'>
                        <thead>
                            <tr>
                                <th>Airline</th>
                                <th>Flight Number</th>
                                <th>Departure</th>
                                <th>Arrival</th>
                                <th>Transit Time</th>
                                <th>Layover</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.LIST.map(list =>
                                <tr key={list.idAirline}>
                                    <td>{list.flight_id}</td>
                                    <td>{list.departure}</td>
                                    <td>{list.arrival.slice(0, 10)}</td>
                                    <td>{list.scale}</td>
                                    <td>{list.luggage}</td>
                                    <td>{list.price}</td>
                                </tr>
                            )}
                        </tbody>
                    </table>
                </div>

                {/* Origin and Destination Form */}
                <div className='shadow-lg p-3 mb-5 bg-white rounded'>
                    <h2> Choose Origin and Destination </h2>
                    <form>
                        <div className="row">
                            <div className="col-25">
                                <label htmlFor="origin">Origin</label>
                            </div>
                            <div className="col-75">
                                <select id="origin" name="origin">
                                    {this.state.persons.map(person => <option>{person.name}</option>)}
                                </select>
                            </div>
                        </div>

                        <div className="row">
                            <div className="col-25">
                                <label htmlFor="destination">Destination</label>
                            </div>
                            <div className="col-75">
                                <select id="origin" name="origin">
                                    {this.state.persons.map(person => <option>{person.name}</option>)}
                                </select>
                            </div>
                        </div>

                        <div className="row">
                            <div className="col-25">
                                <label htmlFor="oneWay">One Way</label>
                            </div>
                            <div className="col-75">
                                <input type="checkbox" checked={this.state.agreement} onChange={this.oneWay} />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col-25">
                                <label htmlFor="Origin">Departure Date</label>
                            </div>
                            <div className="col-75">
                                <input type="text" id="departure" name="departure" placeholder="To" />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col-25">
                                <label htmlFor="Origin">Arrival Date</label>
                            </div>
                            <div className="col-75">
                                <input type="text" id="departure" name="departure" placeholder="To" />
                            </div>
                        </div>


                        <div className="row mt-3">
                            <div className="elementCenter">
                                <input type="submit" value="Search" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}