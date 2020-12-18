import $ from 'jquery';
import {baseUrl} from '../fetch/FetchUtil.js';

class User{
    constructor(full_name, role_id, user_id){
        this.full_name = full_name;
        this.role_id = role_id;
        this.user_id = user_id;
    }
}

function userXhr(){
    return $.ajax({
        url: baseUrl + 'login',
        xhrFields: {withCredentials: true},
            context: document.body,
            method: 'GET',
            dataType: 'json'
    });
}

let user = userXhr();

export {User, user};