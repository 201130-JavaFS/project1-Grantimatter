import $ from 'jquery';

export {Reimbursement};

class Reimbursement{
    constructor(id, amount, author, resolver, status, type, description, submitted, resolved, author_id){
        this.id = id;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
        this.status = status;
        this.type = type;
        this.description = description;
        this.submitted = submitted;
        this.resolved = resolved;
        this.author_id = author_id;
    }
    static amountTypeDescriptInstance(amount, type, description){
        return new Reimbursement(null, amount, null, null, null, type, description, null, null);
    }
    static amountTypeInstance(amount, type){
        return new Reimbursement(null, amount, null, null, null, type, null, null, null);
    }
    static notResolved(id, amount, author, resolver, status, type, description, submitted){
        return new Reimbursement(id, amount, author, resolver, status, type, description, submitted, null);
    }

    static getStatus(status){
        switch(status){
            case 0: return 'Pending';
            case 1: return 'Approved';
            case 2: return 'Denied';
        }
    }
    static getType(type){
        switch(type){
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
