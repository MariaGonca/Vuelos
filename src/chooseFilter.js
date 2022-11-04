import React from 'react';
import axios from 'axios';

function ChooseFilter() {

    {/* Filtering checkbox airline,scales,luggage,schedule */}
    const [airlineC, setCheckAir] = React.useState(false);
    const [scalesC, setCheckScale] = React.useState(false);
    const [luggageC, setCheckLug] = React.useState(false);
    const [scheduleC, setCheckSched] = React.useState(false);

    {/* Events for trip filter checkbox */}
    const selectAir = () => {
        setCheckAir(true);
        setCheckScale(false);
        setCheckLug(false);
        setCheckSched(false);
    };
    const selectScale = () => {
        setCheckAir(false);
        setCheckScale(true);
        setCheckLug(false);
        setCheckSched(false);
    };
    const selectLug = () => {
        setCheckAir(false);
        setCheckScale(false);
        setCheckLug(true);
        setCheckSched(false);
    };
    const selectSched = () => {
        setCheckAir(false);
        setCheckScale(false);
        setCheckLug(false);
        setCheckSched(true);
    };

    return (
        <div class="container">

            {/* Filter Form */}
            <h2> Choose filters </h2>      
            <form>
                <div>
                    <label>
                        <input type="checkbox" checked={airlineC} class="mb-3" onChange={selectAir}/>
                        Airline
                        <input type="checkbox" checked={scalesC} class="mb-3" onChange={selectScale}/>
                        Scales
                        <input type="checkbox" checked={luggageC} class="mb-3" onChange={selectLug}/>
                        Luggage
                        <input type="checkbox" checked={scheduleC} class="mb-3" onChange={selectSched}/>
                        Schedule

                        <div class="row">
                            <div class="elementCenter">
                                <input type="submit" value="Filter"/>
                            </div>
                        </div>
                    </label>          
                </div>
            </form>
        </div>
    )
}


export default ChooseFilter;