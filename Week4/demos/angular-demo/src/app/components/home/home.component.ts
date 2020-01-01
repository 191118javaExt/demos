import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public title = 'angular-demo';
  public element = "";
  public array: string[] = ['Red', 'Blue', 'Bananabox',
      'flag', 'Pikachu', "I'm a teapot"];

  constructor() { }

  ngOnInit() {
  }

  public func() {
    // if(this.title === 'angular-demo') {
    //   this.title = "changed-title";
    // } else {
    //   this.title = 'angular-demo';
    // }

    this.array.push(this.element);
  }
}
