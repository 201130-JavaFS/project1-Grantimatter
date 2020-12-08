/*let reimb_form = document.getElementById("new_reimb_form");
reimb_form.onSubmit = submitReimbursement;*/
//reimb_form.addEventListener("submit", submitReimbursement);

let reimb_table_body = document.getElementById("reimb_table_body");

$("#new_reimb_form").submit(function(e) {
    e.preventDefault();

    let tableItem = document.createElement("tr");
    let rowHead = document.createElement("th");
    rowHead.scope = "row";
    rowHead.innerHTML = "999"

    tableItem.appendChild(rowHead);
    tableItem.appendChild(createColumn("$"+$("#reimb_amount").val()));
    tableItem.appendChild(createColumn("Pending"));
    tableItem.appendChild(createColumn(getType($("#reimb_type").val())));
    tableItem.appendChild(createColumn($("#reimb_description").val()));
    tableItem.appendChild(createColumn("2020-12-05 14:58:54"));
    reimb_table_body.prepend(tableItem);


    //document.getElementById('new_reimb_form').reset();
    $('#new_reimb_form')[0].reset();
    $('#new_reimb_modal').modal('hide')
});

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