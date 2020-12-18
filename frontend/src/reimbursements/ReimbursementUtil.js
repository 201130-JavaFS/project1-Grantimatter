import $ from 'jquery';

export {Reimbursement};

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
    static notResolved(id, amount, author_id, resolver_id, status_id, type_id, description, submitted){
        return new Reimbursement(id, amount, author_id, resolver_id, status_id, type_id, description, submitted, null);
    }

    static getStatus(status_id){
        switch(status_id){
            case 0: return 'Pending';
            case 1: return 'Approved';
            case 2: return 'Denied';
        }
    }
    static getType(type_id){
        switch(type_id){
            case 0: return 'Lodging';
            case 1: return 'Travel';
            case 2: return 'Food';
            case 3: return 'Other';
        }
    }
}

$('.reimb-approved').on({
    mouseenter: ()=>{
        console.log('Mouse Entered Approved row!');
        $(this).addClass('reimb-approved-active');
    },
    mouseleave: ()=>{$(this).removeClass('reimb-approved-active')}
});

$('.reimb-approved').on('mouseenter mouseleave', ()=>{
    console.log('Mouse entered or mouse left!');
    $(this).toggleClass('reimb-approved-active');
});

$('.reimb-denied').on('mouseenter mouseleave', ()=>{
    console.log('Mouse entered or mouse left!');
    $(this).toggleClass('reimb-denied-active');
});

$('.reimb-pending').on('mouseenter mouseleave', ()=>{
    console.log('Mouse entered or mouse left!');
    $(this).toggleClass('row-hover-active');
});
