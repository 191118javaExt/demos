'use strict'; // You can put this at the top of your JS file to enforce strict
// variable declarations
// Otherwise, if you use a variable that was not previously declared, JS will
// declare it using var
// a = 55;
// console.log(a);
// var a;

var harry = 'harry';
// larry = 'othertext';
console.log(harry);

/*
  Two main scopes: global and functional scope
  Similar to Java, scope defines a variables visibility.
  Global scope is the outermost scope, that is the most visible. It is available
    everywhere.
  Variables outside of the function scope declared with var will be declared with
    global scope.

*/

funScope();

function funScope() {
  var a = 'hello';

  if(true) {
    var b = 'goodbye';
  }

  console.log(b);
}

/*
  Lexical/block scoping was added in ES6
  It allows for block scoping similar to Java
  In our previous example, b would not be visible outside the
    if statement.

  This is accomplished with new keywords, let and const
*/

function blockScope() {
    let a = 'hello';

  if(true) {
    let b = 'goodbye';
  }

  // The let and const keywords do NOT hoist variables
  // This allows us to use nested block scopes as we like
  console.log(a);
  // console.log(b);
}

blockScope();

/*
  var i;
  var j;
  for(i = 0; i < arr.length; i++) { }

  for(i = 0; i < arr.length; i++) { }
*/

// The const keyword also does not hoist variables, and it works
// similarly to the final keyword for variables in Java
// Bascially, you cannot modify the value after you declare
// the variable

function constfunc() {
  const a = 'temp';
  a = 'notTemp';
}

constfunc();
