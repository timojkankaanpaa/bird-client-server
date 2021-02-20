import settings from './settings.json';

/**Funktio palauttaa array, jossa lintuja */
export async function getBirds(){
    //Käytä JS fetch ja hae linnut backendista
    return fetch(settings.url + 'birds_fi')
    .then(response => response.json())
    .then(data => {return(data)});
}

/**Funktio hakee kaikki linnut palvelimelta suomeksi järjestettynä */
export async function getObservations(){
  //Käytä JS fetch ja hae linnut backendista
  return fetch(settings.url + 'observations')
  .then(response => response.json())
  .then(data => {return(data)});
}

/**Funktio tallettaa luntuhavainon observation- tauluun */
export async function create(observation){
    const response = await fetch(settings.url + "observation", {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        headers: {
          'Content-Type': 'application/json'  
        },
        body: JSON.stringify(observation) // body data type must match "Content-Type" header
      });
      return response.json(); // parses JSON response into native JavaScript objects
}