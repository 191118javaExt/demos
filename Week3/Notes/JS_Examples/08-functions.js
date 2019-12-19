function add(a = 0, b = 0) {
  // JavaScript supports default values for functions
  // From right to left, we can opt not to include a parameter,
  // And JavaScript will use the default
  return a + b;
}

console.log(add(10, 20));
console.log(add(15));
console.log(add());
console.log(add(10, 20, 30, 40, 50));
// There is no error when additional parameters are provided,
// they are simply ignored

// This is called arrow notation for declaring anonymous functions
// The right side of the equal sign is in a way a function literal
// And it only has a name, because we assigned it to the variable
// otherAdd
let otherAdd = (one = 0, two = 0) => {
  return one + two;
}
// Arrow notation was added to JavaScript in ES6, similar to
// lambdas in Java

console.log(otherAdd(5, 10));
console.log(otherAdd());

// Note that you do not have to put the parenthesis if you only have
// one parameter
// This function will implicitly return something if you do not
// include curly braces and have only one line of code.

let func = a => a + 5;
console.log(func(10));

// This notation is very important because it allows us to create
// functions in a very concise shorthand
