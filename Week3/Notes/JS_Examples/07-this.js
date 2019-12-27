/*
  As we saw in the previous example, JavaScript has a 'this' keyword.
  It can be used similarly in JS as it is in Java, but it is not
  so simple.
  We can use the 'this' keyword in many places, and it refers to different
  things in different places.

  When used alone, it refers to the global window object.
  When used inside a function, it refers to the global window object.
  When used with event handlers, it refers to the HTML element that
  is the recipient of the event.
*/

let windowObject = this;
var bigFoot = "BigFoot is absolutely real, I don't know what you're talking about.";
console.log(windowObject.bigFoot);
console.log(this.bigFoot);

console.log(this);

function func() {
  var bigFoot = "BigFoot is a myth!";
  console.log(this.bigFoot); // <-- This refers to the bigFoot that is attached to the
  // global window object
  console.log(bigFoot); // <-- This refers to the bigFoot declared in the
  // functional scope
}

func();

/*
Class A {
  int i = 0;

  if(true) {
    int i = 15;
    this.i;
  }

}
*/

// There's a 3rd way

/*
  If you do something along these lines in HTML:

  <button onclick="this.style.display='none">Text</button>

  When you do the above, this refers to the actual object
  (in this case the button)
*/
