import './App.css';
import * as React from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
//Datatable Modules
import "datatables.net-dt/js/dataTables.dataTables"
import "datatables.net-dt/css/jquery.dataTables.min.css"



import ChoosePlace from './choosPlace';
import CreatePassenger from './createPassenger';

function App() {
  return (
    <div className="col-8" style={{marginLeft:"auto",marginRight:"auto"}}>
      <ChoosePlace/>
      <CreatePassenger />
    </div>
  );
}

export default App;