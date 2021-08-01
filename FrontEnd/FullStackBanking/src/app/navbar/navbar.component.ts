import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  entered_user_name: string = 'username'
  entered_user_password: string = 'password'
  invalidLogin = false
  
  
  
  constructor(public router: Router,
    public loginService: AuthenticationService) { }

  ngOnInit() {
  }

async submit() {

    let url="http://localhost:8080/FullStack_Banking/";

    let user = {
      userName: this.entered_user_name,
      userPass: this.entered_user_password
    }
    //testing
    console.log(this.entered_user_name);
    console.log(this.entered_user_password);
   

    let response = await fetch(url + "login", {

      method: "POST",

      body: JSON.stringify(user),
     
      credentials: "include"
    });
    console.log("cutomer ID" + response)

    if (response.status === 200) {
      if (this.loginService.authenticate(this.entered_user_name, this.entered_user_password)
      ) {
        this.router.navigate(['user'])
        this.invalidLogin = false
      } else
        this.invalidLogin = true
        console.log(response.status);
        console.log("failed");
        
    }
      //testing purposes
      console.log("cutomer ID" + response)
      this.router.navigate(['user']);
    }



  }

