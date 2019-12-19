// A callback is simply a function that is used as a parameter to another function
function caller(callback) {
  console.log(`Caller has been called with param:
  ${callback}`);
  callback(5, 6);
}

function func(one, two) {
  let result = one * two;
  console.log(result);
  return result;
}

caller(func);

caller( (one, two) => {
  let result = one + two;
  console.log(result);
  return result;
})
