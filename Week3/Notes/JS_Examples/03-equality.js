/*
  JS has 2 equality operators, == and ===

  They both perform equality in the same sense that it does in Java,
  however, == will use what is called 'type coercion', which means
  JS will attempt to convert types to match and then compare values
  Things like '5' == 5 will be true

  === Does not use type coercion, so '5' === 5 will be false

*/

function compare(one, two) {
  console.log(`
  one = ${one}, and is of type ${typeof(one)}
  two = ${two}, and is of type ${typeof(two)}
  one == two evaluates to ${one == two}
  one === two evaluates to ${one === two}`)
}

compare('5', 5);
compare(97, 'a');
compare(true, 1);
compare(true, 37);
compare(false, 0);
compare(null, undefined);
compare({}, {}); // In JS, different object instances are never equal to each other
var a = {};
compare(a, a);
var b = a;
compare(a, b);
compare("turtle", "tortoise");
compare(true, false);
compare(NaN, NaN); // NaN is never equal to itself
var c = 5 / 'hello';
compare(c, NaN);
compare([], null);
compare(Infinity, Infinity);
compare(Infinity, -Infinity);
compare(5 / 0, Infinity);
compare(5 / -0, -Infinity);
compare(0, -0);
compare("false", true);
compare("true", true);
compare("", true);
compare(undefined, false);
compare(NaN, false);
compare(NaN, undefined);
compare(NaN, null);
compare("whatever", false); // The empty string can be coerced into false,
// but no other strings can be coerced
compare("", false);
compare("false", false);
compare('100', 100);
