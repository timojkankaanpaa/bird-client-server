import React from 'react';

const ObservationComponent =(props)=>{
    //console.log(props.theBirds);

    //read birds from array and add to option elements
    const birdOptions =props.theBirds.map((bird, index)=>{
        return <option key={parseInt(index)} value={bird.id}>{bird.english}</option>
    })

    return(
        <div>
            <h2>Save a bird observation</h2>
            <table style={{marginLeft: '45%'}}>
            <tr><td>Bird</td><td><select onChange={e=>props.change(e)} name="birdid">{birdOptions}</select></td></tr>
            <tr><td>Place</td><td><input onChange={e=>props.change(e)} name="place" value={props.observation.place} type="text"></input></td></tr>
            <tr><td>Time</td><td><input onChange={e=>props.change(e)} name="time" value={props.observation.time} type="text"></input></td></tr>
            <tr><td>User</td><td><input onChange={e=>props.change(e)} name="user" value={props.observation.user} type="text"></input></td></tr>
            <tr><td><button onClick={props.submit}>Save</button></td></tr>
            </table>
            
        </div>
    );
}

export default ObservationComponent;