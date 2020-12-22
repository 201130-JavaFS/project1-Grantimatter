import $ from 'jquery';
import _ from 'lodash';
import {baseUrl} from './fetch/FetchUtil.js';

function login(e){
    e.preventDefault();
    const username = $('#username').val();
    const password = $('#password').val();

    $('#invalidLoginLabel').hide();

    $.ajax({
        url: baseUrl + 'login',
        xhrFields: {withCredentials: true},
        context: document.body,
        method: 'POST',
        dataType: 'json',
        data: JSON.stringify({username, password})
    }).fail(()=>{
        console.log('Login Failed!');
        $('#password').val('');
        $('#invalidLoginLabel').show();
    }).done(function( data, textStatus, jqXHR ) {
        //console.log('login cookie: ' + getCookie('loggedName'));
        let loggedUser = _.startCase(_.toLower(data.loggedUser));
        if(loggedUser){
            console.log('Login Successful!');
            //createCookie('loggedUser', loggedUser);
            window.open('reimbursements.html', '_self');
        }
    });
}

export function logout(){
    $.ajax({
        url: baseUrl + 'logout',
        xhrFields: {withCredentials: true},
        method: 'GET',
        dataType: 'json'
    }).always(()=>{
        window.open('login.html', '_self');
    });
}

$('#loginForm').on('submit', (e)=>login(e));