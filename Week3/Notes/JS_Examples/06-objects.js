let personLiteral = {
  name: 'Ram',
  hairColor: 'Black',
  favoriteFood: 'Rice',
}
/*
  The above is a object literal in JavaScript.
  It allows us to declare an object, which is
  simply a bunch of key-value pairs.
*/
console.log(personLiteral);
console.log(personLiteral.name);
// We can access individual keys on an object using dot notation
// We can also access individual keys using brackets with the key
// as a string
console.log(personLiteral["name"]);
let key = "favoriteFood";

console.log(personLiteral[key]);
// The bracket notation is also convenient to access keys that you do
// not necessarily know when writing the code

personLiteral.age = 35;
// JS will let you set properties even if they didn't exist

console.log(personLiteral);

// =============There is another way to create Person objects ===========

function Person(name, hairColor, favoriteFood) {
  this.name = name;
  this.hairColor = hairColor;
  this.favoriteFood = favoriteFood;
  this.sayHello = function() {
    console.log(`Hello from ${this.name}`);
  }
}

let larry = new Person('Larry', 'Brown', 'Burger');
larry.sayHello();
console.log(larry);

// Classes were eventually added in ES6

class PersonClass {
  constructor(name, hairColor, favoriteFood) {
    this.name = name;
    this.hairColor = hairColor;
    this.favoriteFood = favoriteFood;
  }

  sayHello() {
    console.log(`Hello from ${this.name}`);
  }
}

console.log(new PersonClass('Harry', 'Hot Pink', 'Green Beans'));
