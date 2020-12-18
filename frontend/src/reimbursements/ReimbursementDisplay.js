import $ from 'jquery';
import { baseUrl } from '../fetch/FetchUtil.js';
import { Reimbursement } from '../reimbursements/ReimbursementUtil.js';
import { User, user } from '../util/User.js'

user.done((data, textStatus, jqXHR) => {
    //console.log("User again: " + data.full_name);
    let currentUser = new User(data.full_name, data.id, data.role_id);

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

function getMyReimbursements(user_id){
    $.ajax({
        url: baseUrl + 'reimbursements',
        xhrFields: { withCredentials: true },
        context: document.body,
        method: 'GET',
        dataType: 'json'
        //data: JSON.stringify({user_id})
    }).done(function (data, textStatus, jqXHR) {
        for (const reimbursement of data) {
            addMyReimbursement(reimbursement, 'reimb_table_body');
        }
        if($('#reimb_table_body').children().length > 0){
            $('#my-reimbursements').show();
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

        if($('#other_reimb_table_body').children.length > 0){
            $('#other_reimb_table').show();
        }

        $('#other-reimb-tab').show();
    }).fail(()=>{
        console.log('Failed to find any reimbursements');
    });

}

function addMyReimbursement(reimbursement, table_body_id) {
    let date = null;
    console.log("Adding my reimbursement: " + reimbursement);
    if(reimbursement.resolved != null){
        date = new Date(reimbursement.resolved).toUTCString;
    }
    $('#'+table_body_id).append(
        $('<tr></tr>')
            .addClass(getStatusClass(reimbursement.status_id))
            .append(createData(reimbursement.id))
            .append(createData('$' + reimbursement.amount))
            .append(createData(Reimbursement.getStatus(reimbursement.status_id)))
            .append(createData(Reimbursement.getType(reimbursement.type_id)))
            .append(createData(reimbursement.description))
            .append(createData(new Date(reimbursement.submitted).toUTCString()))
            .append(createData(date))
    );
}

function addOtherReimbursement(reimbursement, table_body_id) {
    let date = null;
    if(reimbursement.resolved != null){
        date = new Date(reimbursement.resolved).toUTCString;
    }
    $('#'+table_body_id).append(
        $('<tr></tr>')
            .addClass(getStatusClass(reimbursement.status_id))
            .append(createData(reimbursement.id))
            .append(createData(reimbursement.author_id))
            .append(createData('$' + reimbursement.amount))
            .append(createData(Reimbursement.getStatus(reimbursement.status_id)))
            .append(createData(Reimbursement.getType(reimbursement.type_id)))
            .append(createData(reimbursement.description))
            .append(createData(new Date(reimbursement.submitted).toUTCString()))
            .append(createData(date))
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