import React from 'react';

const ObservationComponent =(props)=>{
    //console.log(props.theBirds);

    //luetaan linnut taulukosta ja laitetaan option elementtiin
    const birdOptions =props.theBirds.map((bird, index)=>{
        return <option key={parseInt(index)} value={bird.id}>{bird.finnish}</option>
    })

    return(
        <div>
            <h2>Tallenna lintuhavainto</h2>
            <table style={{marginLeft: '45%'}}>
            <tr><td>Lintu</td><td><select onChange={e=>props.change(e)} name="birdid">{birdOptions}</select></td></tr>
            <tr><td>Paikka</td><td><input onChange={e=>props.change(e)} name="place" value={props.observation.place} type="text"></input></td></tr>
            <tr><td>Aika</td><td><input onChange={e=>props.change(e)} name="time" value={props.observation.time} type="text"></input></td></tr>
            <tr><td>Käyttäjä</td><td><input onChange={e=>props.change(e)} name="user" value={props.observation.user} type="text"></input></td></tr>
            <tr><td><button onClick={props.submit}>Tallenna</button></td></tr>
            </table>
            
        </div>
    );
}

export default ObservationComponent;