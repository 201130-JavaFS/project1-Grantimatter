import $ from 'jquery';
import _, { create } from 'lodash';
import {postData, getData, baseUrl} from '../fetch/FetchUtil.js';
import {Reimbursement} from '../reimbursements/ReimbursementUtil.js';

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
        .append(createData(reimbursement.id))
        .append(createData(reimbursement.amount))
        .append(createData(Reimbursement.getStatus(reimbursement.status_id)))
        .append(createData(Reimbursement.getType(reimbursement.type_id)))
        .append(createData(reimbursement.description))
        .append(createData(new Date(reimbursement.submitted).toUTCString()))
    );
}

function createData(innerHTML){
    let cell = document.createElement('td');
    if(innerHTML != null){
        cell.innerHTML = innerHTML;
    }
    return cell;
}
