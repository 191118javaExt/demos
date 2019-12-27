/*
  JavaScript is the programming language of HTML and the web.
  It's generally used to program the behavior of webpages to achieve
  dynamic behavior on a webpage.
  As we saw previously, we can include JS with a <script> and </script> tags.
  You can place any number of these script tags in your HTML document, and they will
  executed sequentially as they are encountered.
  They can be placed in the <body>, the <head>, or you can link to an external js file.
  Note that JavaScript files are generally denoted with a .js extension.
  You can also use JS to change attributes and css classes, as well as the the HTML
  content itself.

  We talked about this already, but JavaScript =/= Java.
*/

/*
  There are several datatypes in JS

  number
  string
  boolean
  null*
  undefined
  object
  function*
*/

// A JS function is a block of code that can be executed when "called on"
// You know, like a function in Java
function logType(input) {
  console.log('input is: ' + input + '\n\t and is of type: ' + typeof(input));
}
// ` not ' The first is called backtick, and the second is an apostrophe
logType(5);

// We can declare variables in JS in a few ways, but the oldest and simplest
// is with the var keyword.

var a = 'hello'; // This is a string
logType(a);

a = 5;
logType(a);
// The above statement is okay in JavaScript
// We do not have to restrict ourselves to keeping our variables
// to only 1 type.

logType(5.5);
logType(true);
logType({}); // This is a JS Object, we can declare them as literals, similar to
// how you declare strings in Java, you do not need to use the new keyword or
// anything along those lines

// JS objects are simply key-value pairs
// We define object literals using curly braces and list the key-value pairs within them
var obj = {
  key1: 1,
  key2: 'hello',
  key3: true,
}

logType(obj);
// The output looks like [object Object] because we were concatenating an object
// with a string
// We can instead directly log the object, and JS will convert into a string
// representation in order to print
console.log(obj);

logType([1, 2, 3]);
// Arrays are objects in JavaScript

logType(logType);
// The typeof function will show functions as type function
// However, functions in JS are also just objects

logType(null);

logType(b);

var b;

b = 'something';

logType(b);

logType(5 / 'a'); // NaN

console.log(isNaN(5 / 'a'));

logType(5 / 0);

logType(5 / Infinity);
