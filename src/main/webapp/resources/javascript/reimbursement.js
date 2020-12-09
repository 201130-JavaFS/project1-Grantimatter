/*let reimb_form = document.getElementById("new_reimb_form");
reimb_form.onSubmit = submitReimbursement;*/
//reimb_form.addEventListener("submit", submitReimbursement);

class Reimbursement{
    constructor(id, amount, status, type, description, receipt, submitted){
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.type = type;
        this.description = description;
        this.receipt = receipt;
        this.submitted = submitted;
    }
    static amountTypeDescriptReceiptInstance(amount, type, description, receipt){
        return new Reimbursement(null, amount, null, type, description, receipt, null);
    }
    static amountTypeInstance(amount, type){
        return new Reimbursement(null, amount, null, type, null, null, null);
    }
}

let reimb_table_body = document.getElementById("reimb_table_body");

$("#new_reimb_form").submit(function(e) {
    e.preventDefault();
    let new_reimb = Reimbursement.amountTypeDescriptReceiptInstance($('#reimb_amount').val(), $('#reimb_type').val(), $('#reimb_description').val(), $('#reimb_receipt').val());
    sendNewReimb(new_reimb);
/*
    let tableItem = document.createElement("tr");
    let rowHead = document.createElement("th");
    rowHead.scope = "row";
    rowHead.innerHTML = "999"
*/
    /*
    tableItem.appendChild(rowHead);
    tableItem.appendChild(createColumn("$"+$("#reimb_amount").val()));
    tableItem.appendChild(createColumn("Pending"));
    tableItem.appendChild(createColumn(getType($("#reimb_type").val())));
    tableItem.appendChild(createColumn($("#reimb_description").val()));
    tableItem.appendChild(createColumn("2020-12-05 14:58:54"));
    reimb_table_body.prepend(tableItem);*/

    //document.getElementById('new_reimb_form').reset();
    $('#new_reimb_form')[0].reset();
    $('#new_reimb_modal').modal('hide')
});

function sendNewReimb(reimbursement){
    console.log(reimbursement);
}

function receiveNewReimb(id, amount, status, type, description, receipt, submitted){
    let get_reimb = new Reimbursement(id, amount, status, type, description, receipt, submitted);
}

function createColumn(innerText){
    let column = document.createElement("td");
    column.innerHTML = innerText;
    return column;
}

function getType(value){
    switch (value){
        case "0":
            return "Lodging";
        case "1":
            return "Travel";
        case "2":
            return "Food";

        default: return "Other";
    }
}

$('.reimb-approved').mouseenter(function(){    
    $(this).removeClass('reimb-approved-deactivate');
    $(this).addClass('reimb-approved-activate');
    /*
    $(this).animate({
        backgroundColor: '#326432'
    }, 40);*/
});

$('.reimb-approved').mouseleave(function(){
    //$(this).removeClass('reimb-approved-activate');
    $(this).addClass('reimb-approved-deactivate');
});

$('.reimb-denied').mouseenter(function(){
    $(this).addClass("reimb-denied-active");
});

$('.reimb-denied').mouseleave(function(){
    $(this).removeClass("reimb-denied-active");
});

$('.row-hover').mouseenter(function(){
    $(this).addClass('row-hover-active');
});

$('.row-hover').mouseleave(function(){
    $(this).removeClass('row-hover-active');
});