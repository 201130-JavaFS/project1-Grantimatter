import $ from 'jquery';
import { baseUrl } from '../fetch/FetchUtil.js';
import { Reimbursement } from '../reimbursements/ReimbursementUtil.js';
import { User, user } from '../util/User.js'

user.done((data, textStatus, jqXHR) => {
    //console.log("User again: " + data.full_name);
    let currentUser = new User(data.full_name, data.role_id, data.id);
    console.log('Created new user!' + JSON.stringify(currentUser));

    getMyReimbursements(currentUser.user_id);

    if (data.role_id === 1) {
        getOtherReimbursements();
    }
});

user.fail(()=>{
    window.open('login.html', '_self');
});

function updateReimbursements(){
    
}

function getMyReimbursements(requestedUserId){
    $.ajax({
        url: baseUrl + 'reimbursements/' + requestedUserId,
        xhrFields: { withCredentials: true },
        context: document.body,
        method: 'GET',
        dataType: 'json'
    }).done(function (data, textStatus, jqXHR) {
        for (const reimbursement of data) {
            addMyReimbursement(reimbursement, 'reimb_table_body');
        } 

        $('#my-reimbursements').show();

        if($('#reimb_table_body').children().length > 0){
            $('#reimb_table').show();
        }
    });
}

function getOtherReimbursements() {
    console.log('Finding all reimbursements');
    $.ajax({
        url: baseUrl + 'reimbursements/all',
        xhrFields: { withCredentials: true },
        method: 'GET',
        dataType: 'json'
    }).done((data, textStatus, jqXHR)=>{
        console.log('Found reimbursements!');
        for(const reimbursement of data){
            addOtherReimbursement(reimbursement, 'other_reimb_table_body');
        }

        $('#other-reimb-tab').show();
    }).fail(()=>{
        console.log('Failed to find any reimbursements');
    });

}

function addMyReimbursement(reimbursement, table_body_id) {
    let resolved = null;
    console.log("Adding my reimbursement: " + reimbursement);
    if(reimbursement.resolved != null){
        resolved = new Date(reimbursement.resolved).toUTCString;
    }
    $('#'+table_body_id).append(
        $('<tr></tr>')
            .addClass(getStatusClass(reimbursement.status_id))
            .append(createData(reimbursement.id))
            .append(createData('$' + Number(reimbursement.amount).toFixed(2)))
            .append(createData(Reimbursement.getStatus(reimbursement.status_id)))
            .append(createData(Reimbursement.getType(reimbursement.type_id)))
            .append(createData(reimbursement.description))
            .append(createData(new Date(reimbursement.submitted).toUTCString()))
            .append(createData(resolved))
            .append(createData(reimbursement.resolver_id > -1 ? reimbursement.resolver_id : null))
    );
}

function addOtherReimbursement(reimbursement, table_body_id) {
    let resolved = null;
    if(reimbursement.resolved != null){
        resolved = new Date(reimbursement.resolved).toUTCString;
    }
    $('#'+table_body_id).append(
        $('<tr></tr>')
            .addClass(getStatusClass(reimbursement.status_id))
            .append(createData(reimbursement.id))
            .append(createData(reimbursement.author_id))
            .append(createData('$' + Number(reimbursement.amount).toFixed(2)))
            .append(createData(Reimbursement.getStatus(reimbursement.status_id)))
            .append(createData(Reimbursement.getType(reimbursement.type_id)))
            .append(createData(reimbursement.description))
            .append(createData(new Date(reimbursement.submitted).toUTCString()))
            .append(createData(resolved))
            .append(createData(reimbursement.resolver_id))
    );
}

function getStatusClass(status_id) {
    switch (status_id) {
        case 0: return 'reimb-pending';
        case 1: return 'reimb-approved';
        case 2: return 'reimb-denied';
    }
}

function createData(innerHTML) {
    let cell = document.createElement('td');
    if (innerHTML != null) {
        cell.innerHTML = innerHTML;
    }
    return cell;
}