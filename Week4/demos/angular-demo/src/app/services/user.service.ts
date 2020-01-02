import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    let body: any =
    {
      username: username,
      password: password
    };

    return this.http.post<User>('http://localhost:8080/ProjectMostFunnerestest/login',
      body);
  }

  logout() {
    return this.http.post<void>("http://localhost:8080/ProjectMostFunnerestest/logout", {});
  }
}
