function openLoginModal(){
    if($('#loginModal')){
        createLoginModal();
    }
}

function createLoginModal(){
    let loginModal = document.createElement("div");
    loginModal.classList.add("modal", "fade");
    loginModal.id = "loginModal";

    let modalDialog = document.createElement("div");
    modalDialog.classList.add("modal-dialog", "modal-dialog-centered");

    let modalContent = document.createElement("div");
    modalContent.classList.add("modal-content");

    modalContent.appendChild(createLoginForm());
    modalDialog.appendChild(modalContent);
    loginModal.appendChild(modalDialog);
}

function createLoginForm(){
    let loginform = document.createElement("form");

    return loginform;
}