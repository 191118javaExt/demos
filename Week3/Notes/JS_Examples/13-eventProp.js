/*
  Event propagation describes what will occur in the event of more
  than one event listener being triggered at the same time.

  It comes in two different types, capturing and bubbling.
  With capturing, the outermost element will occur first, and then
  propagate inwards.
  With bubbling, it will be the opposite, and start from the innermost
  element and propagate outwards.
  Note that the event propagation will default to bubbling.

  The syntax for specifying event propagation is as follows:
    elementVariable.addEventListener("eventName", callback, bubbleOrCapture)
    where bubbleOrCapture is a boolean. By default it is false, and will instead
    be in capturing mode if set to true.
*/

let capturing = true;
let bubbling = false;

// document.getElementById("inner").addEventListener("click", () => {
//   alert("INNER - bubbling");
// }, bubbling);

// document.getElementById("middle").addEventListener("click", () => {
//   alert("MIDDLE - bubbling");
// }, bubbling);

// document.getElementById("outer").addEventListener("click", () => {
//   alert("OUTER - bubbling");
// }, bubbling);

// document.getElementById("inner").addEventListener("click", () => {
//   alert("INNER - capturing");
// }, capturing);

// document.getElementById("middle").addEventListener("click", () => {
//   alert("MIDDLE - capturing");
// }, capturing);

// document.getElementById("outer").addEventListener("click", () => {
//   alert("OUTER - capturing");
// }, capturing);

document.getElementById("inner").addEventListener("click", () => {
  alert("INNER - bubbling");
}, bubbling);

document.getElementById("middle").addEventListener("click", (e) => {
  alert("MIDDLE - bubbling");
  // e.stopPropagation(); // Prevents the event from propagating
  // However, event listeners on this same element will still occur
  e.stopImmediatePropagation(); // Stops the event from propagating
  // and also prevents other event listeners on this same element
  // from occurring
}, bubbling);

document.getElementById("outer").addEventListener("click", () => {
  alert("OUTER - bubbling");
}, bubbling);

document.getElementById("inner").addEventListener("click", () => {
  alert("INNER - capturing");
}, capturing);

document.getElementById("middle").addEventListener("click", () => {
  alert("MIDDLE - capturing");
}, capturing);

document.getElementById("outer").addEventListener("click", () => {
  alert("OUTER - capturing");
}, capturing);
