import React,{useState,useEffect} from 'react';
import ObservationComponent from '../components/ObservationComponent';
import ObservationList from '../components/ObservationList';
import {getBirds,create,getObservations} from '../controllers/ObservationController';

const ObservationContainer =()=>{
    const [birds, setBirds] = useState([]); //constin perässä ensin muuttuja sitten funktio
    const [observations, setObservations] = useState([]); 
    const [observation, setObservation] = useState({});

    useEffect(()=>{
        initData();
    },[]);

    async function initData(){
        //pyydetään linnut controllerilta
        getBirds() 
        .then(data=>{
            setBirds(data);          //tallennetaan tulos paikallisesti
        })
        .catch((error) => {
            alert('Error:', error);
        });
        //pyydetään havainnot controllerilta
        getObservations() 
        .then(data=>{
            setObservations(data);          //tallennetaan tulos paikallisesti
        })
        .catch((error) => {
            alert('Error:', error);
        });

    }

    useEffect(()=>{
        localStorage.setItem("observation", JSON.stringify(observation));
    },[observation])
    
    //takes care updating the observation
    const handleChange = (e) => {
        let observationNew = {...observation};   //avoid mutation
        observationNew[e.target.name]=e.target.value;
        setObservation(observationNew); //storing to the memory of container
      };

    const handleSubmit=()=>{
        const result =create(observation);
        alert("Tallennettu " +JSON.stringify(observation));
    }


    return(
        <div>
            {/* Kutsutaan controllerin getBirds -funtiota ja välitetään
            linnut componetille Ctrl+Shift+/*/}
            <ObservationComponent theBirds={birds} submit={handleSubmit} observation={observation} change={handleChange}/>
            <ObservationList data={observations}/>
       </div>
    );
}

export default ObservationContainer;