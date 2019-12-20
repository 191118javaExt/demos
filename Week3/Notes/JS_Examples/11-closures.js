/*
  What are closures?
  They allow for a few things:
  1) Allow an inner function to access an enclosing function's variables
  2) Allow an inner function to preserve (closure) an enclosing function's scope
    chain when executing the enclosed function
*/

// Example:

var x = function cake() {
  var flour = true;
  var cornMill = false;
  var cupsSugar = 1;

  function bake() {
    var heat = 350;
    console.log("Baking the cake at " + heat + "!");
    console.log("flour: " + flour);
    console.log("cornMill: " + cornMill);
    console.log("Cups of Sugar: " + cupsSugar);

    heat++;
    flour = !flour;
    cornMill = !cornMill;
    cupsSugar++;
  }

  return bake;
}

/*
  So our inner function 'bake' has the scope chains:

  1) It has access to its own scope (the heat variable)
  2) It has access to the outer/enclosing function cake's variables
    (flour, cornMill, cupsSugar)
  3) It also has access to global variables
*/

// Note that the above function returns a function
// This means that the variable x has the function cake
// And we are executing it here, which will return bake
x = x(); // Invokes cake

// Then, we can execute bake
x();
x();
x();
x();

/*
  We have lost access to the cake function, while retaining
  access to the bake function
  The bake function still has access to the variables that
  are scoped to the cake function
  even though we no longer have access to the cake function
  This gives us a sort indirect access to the cake function,
  but that access is enclosed to the bake function.
*/
