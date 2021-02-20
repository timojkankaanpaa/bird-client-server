import React from 'react';
//npm install react-table-v6
import ReactTable from "react-table-v6";
import 'react-table-v6/react-table.css';

const columns = [{
    Header: 'Lintu',
    accessor: 'birdid' // String-based value accessors!
  }, {
    Header: 'Paikka',
    accessor: 'place',
  }, {
    Header: 'Aika',
    accessor: 'time',
  }, {
    Header: 'Käyttäjä',
    accessor: 'user',
  }]

const ObservationList=(props)=>{
    return(
        <div>
            <ReactTable
            data={props.data}
            columns={columns}
            />
        </div>
    )
}

export default ObservationList;