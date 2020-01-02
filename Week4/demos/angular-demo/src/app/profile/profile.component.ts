import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: User;
  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
    let userString: string = sessionStorage.getItem('currentUser');
    if(userString === null) {
      this.router.navigate(['/login']);
    } else {
      this.currentUser = JSON.parse(userString);
    }
  }

  logout() {
    this.us.logout();
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }
}
