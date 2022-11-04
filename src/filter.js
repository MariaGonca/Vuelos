import React from 'react';
import axios from 'axios';

function ChooseDate(){

    const persons = ""

    const filterByAirline = () =>{
        axios.get(`http://localhost:8080/api/places`)
        .then(res => {
                persons = res.data;
                this.setState({ persons });
        })
    }

    {/* Checkbox settings */}
    {/* One way and return checkbox */}
    const [checked, setChecked] = React.useState(true);
    const [checked2, setChecked2] = React.useState(false);
    
    {/* Hidden return date checkbox */}
    const [isShown, setIsShown] = React.useState(false);

    {/* Events for trip type checkbox */}
    const handleChangeOneWay = () => {
        setChecked(true);
        setChecked2(false);
        setIsShown(false);
    };
    const handleChangeReturn = () => {
        setChecked(false);
        setChecked2(true);
        setIsShown(true);
    };
    
    return (    
        <div class="container">
            {/* Trip type Form */}
            <h2> Choose one way or return trip </h2>      
            <form>
                <div>
                    <label>
                        <input type="checkbox" class="mb-3" checked={checked} onChange={handleChangeOneWay}/>
                        One-Way
                        <input type="checkbox" checked={checked2} onChange={handleChangeReturn}/>
                        Return
                    </label>

                    <div class="row">
                        <div class="col-25">
                        <label for="Origin">Departure Date</label>
                        </div>
                        <div class="col-75">
                        <input type="text" id="departure" name="departure" placeholder="To"/>
                        </div>
                    </div>

                    {isShown &&<div class="row">
                        <div class="col-25">
                        <label for="Origin">Return Date</label>
                        </div>
                        <div class="col-75">
                        <input type="text" id="return" name="return" placeholder="Date of return"/>
                        </div>
                    </div>}

                    <div class="row">
                        <div class="elementCenter">
                        <input type="submit" value="Submit"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    )
}

export default ChooseDate;