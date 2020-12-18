import $ from 'jquery';
import {baseUrl} from '../fetch/FetchUtil.js';

function getUserSession(){
    return $.ajax({
        url: baseUrl + 'login',
        xhrFields: {withCredentials: true},
            context: document.body,
            method: 'GET',
            dataType: 'json'
    });
}

let user = getUserSession().done((data, textStatus, jqXHR)=>{
    return data;
});

export {getUserSession, user};