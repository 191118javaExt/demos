import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css']
})
export class DirectiveComponent implements OnInit {

  public transparent: boolean = false;

  public pokemons: object[] = [{name: 'Pikachu'}, {name: 'Bulbasaur'}, {name: 'Mew'}, {name: 'Charizard'}]

  public styleObject = {
    color: 'red',
    backgroundColor: 'lightblue',
    fontWeight: '800'
  }

  public background: string = '';
  public text: string = '';

  constructor() { }

  ngOnInit() {
  }

  toggleView(): void {
    this.transparent = !this.transparent;
  }

  changeStyle(): void {
    if(this.styleObject.color === 'red') {
      this.styleObject.color = this.text;
      this.styleObject.backgroundColor = this.background;
      this.styleObject.fontWeight = '400';
    } else {
      this.styleObject.color = 'red';
      this.styleObject.backgroundColor = 'lightblue';
      this.styleObject.fontWeight = '800';
    }
  }
}
