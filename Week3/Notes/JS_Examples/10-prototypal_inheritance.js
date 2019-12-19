var car = {
  wheels: 3,
  engine: 5,
  getStats: function() {
    return this.wheels + ' ' + this.engine;
  }
}
// When the 'this' keyword is used within an object's method, it
// refers to the owner of the method
// In this case, it refers to the car object

var mustang = {
  wheels: 18,
  engine: 102,
  color: 'hot-rod red with bumblebee yellow stripes with flames',
}


/*
  All objects have a hidden property in JavaScript called a "prototype"
  If you attempt to access a property or a method which does not exist
  on the object, JS will look for it in the prototype
  You can access the prototype in the following way
*/
mustang.__proto__ = car;
console.log(car);
console.log(mustang);
console.log(mustang.color);
console.log(mustang.engine);
console.log(mustang.getStats());
console.log(car.getStats());
