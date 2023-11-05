import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class HardcodedAuthenticationService {
  constructor() {}

  authenticate(user: string, password: string) {
    if (user === 'nosst-bot' && password === 'dummy') {
      sessionStorage.setItem('authenticateUser', user);
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticateUser');
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('authenticateUser');
  }
}
