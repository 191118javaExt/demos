import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pokemon } from '../models/pokemon';
// The above is the location of the HttpClient class

@Injectable({
  providedIn: 'root' // Denotes that this service is available
  // application-wide
})
export class PokeService {

  /*
    In order to send HTTP requests in Angular, we use the HttpClient dependency
    In order to utilize Angular's Dependency Injection framework, we place
    our dependencies in the constructor.
    Note, TypeScript is smart enough to create a member variable that is
    available in this class just from the constructor
  */
  constructor(private http: HttpClient) { }

  getAllPokemon() {
    return this.http.get('https://pokeapi.co/api/v2/pokemon');
  }

  getNextPokemon(url: string) {
    return this.http.get(url);
  }
}
