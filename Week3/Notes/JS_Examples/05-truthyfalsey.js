/*
  JavaScript has a way to coerce all different values into booleans in different
  ways. This is called truthy/falsey.
  We would say a value that is coerced into true is a truthy value
  and same for false and falsey.
*/

function checkTruthy(input) {
  console.log(`
  input = ${input}, and is of type ${typeof(input)}
  it has a truthy value of ${!!input}`);
}

checkTruthy(true);
checkTruthy(1);
checkTruthy(0);
checkTruthy(-1);
checkTruthy(NaN);
checkTruthy(null);
checkTruthy(undefined);
checkTruthy("");
checkTruthy("false");
checkTruthy({});
checkTruthy([]);
checkTruthy(Infinity);
checkTruthy(-Infinity);

/*
  There are only a few falsey values, and everything else is truthy
  The falsey values are:
    0,
    empty string,
    null,
    false,
    NaN,
    undefined
*/

let a = checkTruthy
checkTruthy(a);
a(0.5);
checkTruthy(checkTruthy);
