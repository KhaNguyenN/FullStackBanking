import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username = 'username'
  password = 'password'
  invalidLogin = false
  
  
  
  constructor(public router: Router,
    public loginService: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    console.log("login-here");
    if (this.loginService.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['user'])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

}