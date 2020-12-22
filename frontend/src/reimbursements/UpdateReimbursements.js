import $ from 'jquery';
import {baseUrl} from '../fetch/FetchUtil.js';

$('#filter-all').on('click', ()=>{
    $('#manageReimbDropdown').text('Filter: All');
    $('.table-row').show();
});

$('#filter-pending').on('click', ()=>{
    $('#manageReimbDropdown').text('Filter: Pending');
    $('.table-row').hide();
    $('.reimb-pending').show();
});

$('#filter-approved').on('click',()=>{
    $('#manageReimbDropdown').text('Filter: Approved');
    $('.table-row').hide();
    $('.reimb-approved').show();
});

$('#filter-denied').on('click',()=>{
    $('#manageReimbDropdown').text('Filter: Denied');
    $('.table-row').hide();
    $('.reimb-denied').show();
});

$('#approve-request-btn').on('click', ()=>{
    updateReimbursements('approved');
});

$('#deny-request-btn').on('click', ()=>{
    updateReimbursements('denied');
});

function getSelectedReimbursements(){
    let $ids = $('.table-row.selected').find('.id');
    //alert('There are ' + $ids.length + ' selected reimbursement requests');
    let putReimbursements = [];
    $ids.each(function(){
        putReimbursements.push($(this).text());
    });

    return putReimbursements;
}

function updateReimbursements(newStatus){
    let idList = getSelectedReimbursements();

    let json = JSON.stringify({idList, newStatus});

    //alert(json);

    $.ajax({
        url: baseUrl + 'reimbursements',
        xhrFields: { withCredentials: true },
        context: document.body,
        method: 'PUT',
        dataType: 'json',
        data: json
    }).done(()=>{
        location.reload();
    }).fail(()=>{
        alert('PUT failed!');
    });
    
}