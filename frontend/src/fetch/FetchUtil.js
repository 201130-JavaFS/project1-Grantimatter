//let baseUrl = 'http://localhost:8080/project-1/';
let baseUrl = 'http://3.137.201.253/Project-1-ERS/';

let getData = async function(url){
    return await (await fetch(url)).json();
}

let postData = async function(url, data = {}){
    const response = await fetch(url, {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json'
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(data)
      });
  
      return response.json();
}

export {baseUrl, getData, postData};
