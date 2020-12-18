import $ from 'jquery';
import _ from 'lodash';
//import {user} from './util/User.js';
import {baseUrl} from './fetch/FetchUtil.js';
import {logout} from './Login.js';
import './style.css';

class Navbar{
    constructor(brandText, action){
        this.head = document.createElement("nav");

        this.head.classList.add("navbar",  "navbar-expand-lg", "navbar-fixed-top", "navbar-dark", "bg-dark");

        let mainDiv = document.createElement('div');
        mainDiv.classList.add('container-fluid');
        this.head.appendChild(mainDiv);

        let brand = document.createElement("a");
        brand.classList.add("navbar-brand");
        brand.href = "#";
        brand.onclick = action;
        brand.textContent = brandText;
        mainDiv.appendChild(brand);

        let contentDiv = document.createElement('div');
        contentDiv.classList.add('collapse', 'navbar-collapse');
        mainDiv.appendChild(contentDiv);

        let leftListDiv = document.createElement("div");
        leftListDiv.classList.add("navbar-nav", "me-auto", "mb-2", "mb-lg-0");
        contentDiv.appendChild(leftListDiv);

        this.leftList = document.createElement("ul");
        this.leftList.classList.add("navbar-nav", "bd-navbar-nav", "flex-row");
        leftListDiv.appendChild(this.leftList);

        this.rightList = document.createElement("ul");
        this.rightList.classList.add("navbar-nav", "bd-navbar-nav", "ml-md-auto", "flex-row");
        contentDiv.appendChild(this.rightList);
    }
    addLeftListItem(text, action){
        let item = document.createElement("li");
        item.classList.add("nav-item");
        let link = document.createElement("a");
        link.classList.add("nav-link");
        link.innerHTML = text;
        link.href = "#";
        link.onclick = action;
        item.appendChild(link);
        this.leftList.appendChild(item);
    }
    addRightListItem(text, action, svgPath = null, viewBox = null){
        let item = document.createElement("li");
        item.classList.add("nav-item");

        let link = document.createElement("a");
        link.classList.add("nav-link");
        link.href = "#";
        link.onclick = action;
        let titleElement = document.createElement("title");
        titleElement.innerHTML = text;

        if(text && !svgPath){
            link.innerHTML = text;
        }
        if(svgPath){
            let svgElement = document.createElement("svg");
            svgElement.className = "navbar-nav-svg";
            link.classList.add("pl-2", "pr-1", "mx-1", "py-3", "my-n2");
            svgElement.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            svgElement.setAttribute("viewBox",  viewBox);
            svgElement.setAttribute("role", "img");
            svgElement.setAttribute("focusable", "false");
            link.style.width = "10mm";
            let path = document.createElement("path");
            path.setAttribute("fill", "currentColor");
            path.setAttribute("fill-rule", "evenodd");
            path.setAttribute("d", svgPath);
            svgElement.appendChild(titleElement);
            svgElement.appendChild(path);
            link.innerHTML= svgElement.outerHTML;
        }
        item.appendChild(link);
        this.rightList.appendChild(item);
    }
}

let nav = new Navbar("Wiswell", ()=>window.open("home.html", "_self"));
nav.addLeftListItem("Home", ()=>window.open("home.html", "_self"));

async function createLoginButton(){
    $.ajax({
        url: baseUrl + 'login',
        xhrFields: {withCredentials: true},
        context: document.body,
        method: 'GET',
        dataType: 'json',
    }).done((data, textStatus, jqXHR)=>{
        createProfileDropdown(data.full_name);
        nav.addLeftListItem('Reimbursements', ()=>window.open('reimbursements.html', '_self'));
    }).fail(()=>{
        nav.addRightListItem('Login', ()=>window.open('login.html', '_self'));
        nav.addLeftListItem('Reimbursments', ()=>window.open('login.html', '_self'));
    });
}

createLoginButton();

function createProfileDropdown(name){
    let dropdown = document.createElement("div");
    dropdown.classList.add("dropdown");

    let button = document.createElement("button");
    button.classList.add("btn", "btn-dark", "dropdown-toggle");
    button.setAttribute("data-toggle", "dropdown");
    button.type = "button";
    button.id = "profileDropdown";
    button.innerHTML =  _.startCase(_.toLower(name)) + ' ';

    let menu = document.createElement("div");
    menu.classList.add("dropdown-menu", "bg-dark");

    let logoutLink = document.createElement("a");
    logoutLink.classList.add("dropdown-item", "text-light");
    logoutLink.href = "#";
    logoutLink.onclick = logout;
    logoutLink.innerHTML = "Logout";

    menu.appendChild(logoutLink);

    dropdown.appendChild(button);
    dropdown.appendChild(menu);
    nav.rightList.appendChild(dropdown);
}

document.body.prepend(nav.head);