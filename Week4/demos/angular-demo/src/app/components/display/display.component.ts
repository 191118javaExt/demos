import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeService } from 'src/app/services/poke.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  public allPokes: Pokemon[] = [];
  public nextUrl: string = '';
  public allPokesObs: Observable<object> = this.poke.getAllPokemon();
  constructor(private poke: PokeService) { }

  ngOnInit() {
  }

  /*
    Observables and Promises are ways to make asynchronous calls.
    They are rather similar, but Observables are a bit more modern
    and used a bit more widely.
    Promises guarantee a response.
    Observables, while similar, do not.
    We can subscribe to these and perform some action when a response
    is received.

    Note *VERY IMPORTANT*: If you do not subscribe, then the request will NOT
    be sent!!!! It is only sent when the request is subscribed to.

    It is a VERY common mistake to forget to subscribe to your observables.
    Make sure you do this!
  */

  retrieve() {
    this.poke.getAllPokemon().subscribe(
      data => {
        this.allPokes = data.results;
        this.nextUrl = data.next;
      }, error => {
        console.log(error);
      }
      // We defined 2 anonymous functions
      // The first is when the data is successfully retrieved
      // The second is when something goes wrong
      // In this case, if something goes wrong,
      // we simply want to output it to the console
    )
  }

  retrieveNext() {
    this.poke.getNextPokemon(this.nextUrl).subscribe(
      data => {
        this.allPokes = data.results;
        this.nextUrl = data.next;
      }, error => {
        console.log(error);
      }
    )
  }

  func(stuff: object) {
    console.log(stuff);
  }
}
