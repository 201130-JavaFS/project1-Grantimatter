import $ from 'jquery';
import _ from 'lodash';
import { baseUrl } from '../fetch/FetchUtil.js';
import { Reimbursement } from '../reimbursements/ReimbursementUtil.js';
import { User, user } from '../util/User.js'

user.done((data, textStatus, jqXHR) => {
    console.log("User again: " + data.full_name);
    let currentUser = new User(data.full_name, data.role_id, data.id);
    console.log('Created new user!' + JSON.stringify(currentUser));

    getMyReimbursements(currentUser.user_id);

    if (data.role_id === 1) {
        getOtherReimbursements();
    }
});

user.fail(()=>{
    window.open('login.html', '_self');
    console.log("User failed to login!");
});

function getMyReimbursements(requestedUserId){
    $.ajax({
        url: baseUrl + 'reimbursements/' + requestedUserId,
        xhrFields: { withCredentials: true },
        context: document.body,
        method: 'GET',
        dataType: 'json'
    }).done(function (data, textStatus, jqXHR) {
        for (const reimbursement of data) {
            let reimb = new Reimbursement(reimbursement.id, reimbursement.amount, reimbursement.author, reimbursement.resolver,
                _.startCase(_.toLower(reimbursement.status)), _.startCase(_.toLower(reimbursement.type)), reimbursement.description, reimbursement.submitted, reimbursement.resolved);
            addMyReimbursement(reimb, 'reimb_table_body');
        }

        $('#my-reimbursements').show();
        setupEvents();

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
            let reimb = new Reimbursement(reimbursement.id, reimbursement.amount, reimbursement.author, reimbursement.resolver,
                _.startCase(_.toLower(reimbursement.status)), _.startCase(_.toLower(reimbursement.type)), reimbursement.description, reimbursement.submitted, reimbursement.resolved);
            addOtherReimbursement(reimb, 'other_reimb_table_body');
        }

        $('#other-reimb-tab').show();
        
        setupSelection();
    }).fail(()=>{
        console.log('Failed to find any reimbursements');
    });

}

function addMyReimbursement(reimbursement, table_body_id) {
    let resolved = 'N/A';
    if(reimbursement.resolved != null){
        resolved = new Date(reimbursement.resolved).toUTCString();
    }
    $('#'+table_body_id).append(
        $('<tr></tr>')
            .addClass(getStatusClass(reimbursement.status))
            .append(createData(reimbursement.id))
            .append(createData('$' + Number(reimbursement.amount).toFixed(2)))
            .append(createData(reimbursement.status))
            .append(createData(reimbursement.type))
            .append(createData(reimbursement.description))
            .append(createData(new Date(reimbursement.submitted).toUTCString()))
            .append(createData(resolved))
            .append(createData(resolved != 'N/A' ? reimbursement.resolver : 'N/A'))
    );
}

function addOtherReimbursement(reimbursement, table_body_id) {
    let resolved = 'N/A';
    if(reimbursement.resolved != null){
        resolved = new Date(reimbursement.resolved).toUTCString();
    }

    let id = createData(reimbursement.id);
    id.classList.add('id');

    $('#'+table_body_id).append(
        $('<tr></tr>')
            .addClass(getStatusClass(reimbursement.status))
            .append(createCheckbox(reimbursement.status))
            .append(id)
            .append(createData(reimbursement.author))
            .append(createData('$' + Number(reimbursement.amount).toFixed(2)))
            .append(createData(reimbursement.status))
            .append(createData(reimbursement.type))
            .append(createData(reimbursement.description))
            .append(createData(new Date(reimbursement.submitted).toUTCString()))
            .append(createData(resolved))
            .append(createData(resolved != 'N/A' ? reimbursement.resolver : 'N/A'))
    );
}

function createCheckbox(status){
    if(status == 'Pending'){
        let inputElement = document.createElement('input');
        inputElement.type = 'checkbox';
        return createData(inputElement.outerHTML);
    }
    
    return createData('');
}

function getStatusClass(status) {
    switch (status) {
        case 'Pending': return 'table-row reimb-pending';
        case 'Approved': return 'table-row reimb-approved';
        case 'Denied': return 'table-row reimb-denied';
    }
}

function createData(innerHTML) {
    let cell = document.createElement('td');
    if (innerHTML != null) {
        cell.innerHTML = innerHTML;
    }
    return cell;
}

function setupSelection(){
    $('td').parent().on('click', function(){
        console.log("Clicked on row");
        let $checkbox = $(this).find('input[type=checkbox]');

        $checkbox.prop('checked', function(i, checked){
            $(this).parent().parent().toggleClass('selected');
            return !checked;
        });
    });
}

function setupEvents(){
    $('.table-row').on('mouseenter mouseleave', function(){
        console.log('mouse entered or left the element');
        if(!$(this).hasClass('selected')){
            $(this).toggleClass('hover');
        }
    });
}
