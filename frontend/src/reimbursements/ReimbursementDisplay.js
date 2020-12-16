import $ from 'jquery';
import _, { create } from 'lodash';
import {postData, getData, baseUrl} from '../fetch/FetchUtil.js';
import {Reimbursement} from '../reimbursements/ReimbursementUtil.js';
import { user } from '../util/User.js';

$.ajax({
    url: baseUrl + 'reimbursements',
    xhrFields: {withCredentials: true},
        context: document.body,
        method: 'GET',
        dataType: 'json'
}).done(function( data, textStatus, jqXHR ){
    for (const reimbursement of data) {
        addReimbursement(reimbursement);
    }
    $('#reimb_table').show();
});

function addReimbursement(reimbursement){
    $('#reimb_table_body').append(
        $('<tr></tr>')
        .addClass(getStatusClass(reimbursement.status_id))
        .append(createData(reimbursement.id))
        .append(createData('$'+reimbursement.amount))
        .append(createData(Reimbursement.getStatus(reimbursement.status_id)))
        .append(createData(Reimbursement.getType(reimbursement.type_id)))
        .append(createData(reimbursement.description))
        .append(createData(new Date(reimbursement.submitted).toUTCString()))
    );
}

function getStatusClass(status_id){
    switch(status_id){
        case 0: return 'reimb-pending';
        case 1: return 'reimb-approved';
        case 2: return 'reimb-denied';
    }
}

function createData(innerHTML){
    let cell = document.createElement('td');
    if(innerHTML != null){
        cell.innerHTML = innerHTML;
    }
    return cell;
}

async function checkRole(){
    let login = await user;
    if(login.role_id == 0){

    }
}
