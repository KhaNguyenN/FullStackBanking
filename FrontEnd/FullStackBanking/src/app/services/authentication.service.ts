import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
//removed if username === and password === cause the backend already authenticate
//will now store the session
  authenticate(username: any, password: any ) {
      console.log("In authenticate")
      sessionStorage.setItem('username', username)
      return true;
    
  }
//checked if the user is logged in
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }
//removed the session where the user is logged in
  logOut() {
    sessionStorage.removeItem('username')
  }
}