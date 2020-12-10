class Reimbursement{
    constructor(id, amount, author_id, resolver_id, status_id, type_id, description, submitted, resolved){
        this.id = id;
        this.author_id = author_id;
        this.resolver_id = resolver_id;
        this.amount = amount;
        this.status_id = status_id;
        this.type_id = type_id;
        this.description = description;
        this.submitted = submitted;
        this.resolved = resolved;
    }
    static amountTypeDescriptInstance(amount, type, description){
        return new Reimbursement(null, amount, null, null, null, type, description, null, null);
    }
    static amountTypeInstance(amount, type){
        return new Reimbursement(null, amount, null, null, null, type, null, null, null);
    }
}

$("#new_reimb_form").submit(function(e) {
    e.preventDefault();
    let amount = document.getElementById('reimb_amount').value;
    let reimb = Reimbursement.amountTypeDescriptInstance(parseFloat(amount), $('#reimb_type').val(), $('#reimb_description').val());
    //console.log(reimb);
    postData('reimb-submit', reimb);
    $('#new_reimb_form')[0].reset();
    $('#new_reimb_modal').modal('hide')
    location.reload();
});

function sendNewReimb(reimbursement){
    console.log(reimbursement);
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

function addAllReimbursementsToTable(reimb_array){
    console.log(reimb_array);
    for(r of reimb_array){
        addReimbursementToTable(r);
    }
}

let reimb_table_body = document.getElementById("reimb_table_body");

function addReimbursementToTable(reimbursement){
    function addData(innerhtml){
        let newData = document.createElement("td");
        newData.innerHTML = innerhtml;
        return newData;
    }
    let reimb_row = document.createElement("tr");
    reimb_row.classList.add(getStatusClass(reimbursement.status_id));
    let reimb_id = document.createElement("th");
    reimb_id.scope = "row";
    reimb_id.innerHTML = reimbursement.id;

    //let reimb_amount = document.createElement("td");
    //reimb_amount.innerHTML = reimbursement.reimb_amount;

    let reimb_status = document.createElement("td");

    reimb_row.appendChild(reimb_id);
    reimb_row.appendChild(addData("$" + Number(reimbursement.amount).toFixed(2)));
    reimb_row.appendChild(addData(getStatus(reimbursement.status_id)));
    reimb_row.appendChild(addData(getType(reimbursement.type_id)));
    reimb_row.appendChild(addData(reimbursement.description));
    reimb_row.appendChild(addData(getFomrattedDate(new Date(Number(reimbursement.submitted)))));
    reimb_table_body.appendChild(reimb_row);
    setupTableEvents();
}

function getFomrattedDate(date){
    let formatted = '';
    var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    var days = ["Sunday", "Monday", "Tuesday", "Wendesday", "Thursday", "Friday", "Saturday"];
    formatted += (date.getMonth() + 1) + " / " + date.getDate() + " / " + (date.getFullYear()) + " ";
    formatted += getFormattedTime(date);
    
    return formatted;
}

function getFormattedTime(date){
    let formattedTime = "";
    let hour = date.getHours();
    function getMinutes(minutes){
        minutes++;
        if(minutes < 10){
            minutes = String("0"+minutes);
        }
        return minutes;
    }
    let minutes = getMinutes(date.getMinutes());
    if(hour == 0 || hour == 11){
        formattedTime += "12" + ":" + minutes + " AM";
    }else if(hour < 11){
        formattedTime += String((hour + 1) + ":" + minutes + " PM");
    }else{
        formattedTime += String((hour - 11 + formattedTime) + ":" + minutes + " PM");
    }

    
    return formattedTime;
}

function getType(type_id){
    switch(type_id){
        case 0:
            return "Lodging";
        case 1:
            return "Travel";
        case 2:
            return "Food";
        case 3:
            return "Other";
    }
}

function getStatus(status_id){
    switch(status_id){
        case 0:
            return "Pending";
        case 1:
            return "Approved";
        case 2:
            return "Denied";
    }
}

function getStatusClass(status_id){
    switch(status_id){
        case 0:
            return "row-hover";
        case 1:
            return "reimb-approved";
        case 2:
            return "reimb-denied";
    }
}

async function getReimbursements(){
    let author = getCookie("UserId");
    let response = await fetch("reimb-get?UserId=" + author);
    console.log(response);
    if(response.status === 200){
        let data = await response.json();
        addAllReimbursementsToTable(data);
    }
}

//postData('reimb-submit', {"amount":7474.10,"author_id":0,"type_id":2,"description":"Posted from Javascript!"});

// Example POST method implementation:
async function postData(url = 'reimb-submit', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
      method: 'POST', // *GET, POST, PUT, DELETE, etc.
      mode: 'cors', // no-cors, *cors, same-origin
      cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
      credentials: 'same-origin', // include, *same-origin, omit
      headers: {
        'Content-Type': 'application/json'
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: 'follow', // manual, *follow, error
      referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return response.json(); // parses JSON response into native JavaScript objects
  }
  
  postData('https://example.com/answer', { answer: 42 })
    .then(data => {
      console.log(data); // JSON data parsed by `data.json()` call
    });

function setupTableEvents(){
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
}

getReimbursements();