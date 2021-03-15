import React from 'react';
//npm install react-table-v6
import ReactTable from "react-table-v6";
import 'react-table-v6/react-table.css';

const columns = [{
    Header: 'Bird',
    accessor: 'birdid' // String-based value accessors!
  }, {
    Header: 'Place',
    accessor: 'place',
  }, {
    Header: 'Time',
    accessor: 'time',
  }, {
    Header: 'User',
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