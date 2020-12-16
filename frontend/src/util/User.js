import $, { data } from 'jquery';
import _ from 'lodash';
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