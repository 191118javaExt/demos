a = 'hello';
console.log(a);
// If you declare a variable with no keyword, it will use var

// console.log(b); // Throws an error, since let is not hoisted, which we will talk about
// later
let b = 'somethingelse';
console.log(b);
// Afterwards, it works as normal

// let was introduced in 2015 with the ES6 standard
// ES6, aka, ECMA Script 6 is basically the name of a version of JS
// We'll talk more about this later

let templateLiteral = ``;
// We can use the backtick character to declare what are
// called template literals. It is effectively a string, however
// it supports string interpolation.
// This means we can insert placeholders for variables
// and the template literal will use the value of the variable
// when used.

templateLiteral = `
You can declare template literals
across multiple lines as well
and use it for string interpolation like this
a = ${a}
b = ${b}
5 + 5 = ${5 + 5}`;
console.log(templateLiteral);
a = 'not hello';
console.log(templateLiteral);
// The template literal does not update with newer values
// of the variables
// It only uses the values at creation
