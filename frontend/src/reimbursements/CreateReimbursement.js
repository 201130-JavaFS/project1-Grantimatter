import $ from 'jquery';
import {baseUrl} from '../fetch/FetchUtil.js';

function submitReimbursement(e){
    e.preventDefault();

    let amount = $('#reimb_amount').val();
    let type_id = $('#reimb_type_id').val();
    let description = $('#reimb_description').val();

    $.ajax({
        url: baseUrl + 'reimbursements',
        xhrFields: {withCredentials: true},
        context: document.body,
        method: 'POST',
        dataType: 'json',
        data: JSON.stringify({amount, type_id, description})
    }).done(()=>{
        
    }).fail(()=>{
        //alert('Something went wrong, please try again later.');
    }).always(()=>{
        $('#new_reimb_form').get(0).reset();
        window.$('#new_reimb_modal').modal('hide');
        location.reload();
    });
}

$('#new_reimb_form').on('submit', (e)=>{
    submitReimbursement(e);
});