import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


email:string ="";
username:string ="";
firstname:string ="";
lastname:string="";
address:string="";
state:string="";
zipcode:string="";
password:string="";
password2:string="";

//Testing purposes
  // customerusername:string ="username";
	// customerbankpassword:string= "yes";
	// customerfirstname:string= "firstname";
	// customerlastname:string= "lastname";
	// customeraddress:string= "address";
	// customerstate:string= "state";
	// customerzip:string= "zip";


  constructor(public router:Router) { }

  ngOnInit(): void {

  }
  async register(){

    if(this.email=="" || this.address=="" || this.firstname=="" || this.lastname=="" || this.username=="" || this.password=="" || this.password2=="" || this.zipcode=="" || this.state==""){
      alert("Fields Cannot be Empty");
    }
    else if(this.password != this.password2) {
      alert("Passwords does not match");
    }


    else{
     let url="http://localhost:8080/FullStack_Banking/";

     let user = {
      customerusername:this.username,
      customerbankpassword:this.password, //could be either password 1 or 2 cause you know they are the same
      customerfirstname:this.firstname,
      customerlastname:this.lastname,
      customeraddress:this.address,
      customerstate:this.state,
      customerzip:this.zipcode
     }
     let response = await fetch(url + "createCustomer", {

      method: "POST",

      body: JSON.stringify(user)
     
    });


    if (response.status === 200) {
      alert("Signup successful");
    this.router.navigate(['']);

  }
  else {
    console.log(response.status);
    this.router.navigate(['signup']);
  }


  }
}
}