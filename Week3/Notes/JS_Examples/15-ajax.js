/*
  AJAX stands for Asynchronous JavaScript And XML

  It allows for performing javascript actions asynchronously.
  Generally used in conjunction with http requests, as we can wait
  for the response in the background while still doing other things.

  One of the biggest advantages of JS is the responsiveness it provides
  to our webpages. We can easily respond to events on our frontend and manipulate
  the DOM using basic JS functions.

  But the magic JS does not end there. We can use JS to make asynchronous
  requests to servers. We do this with AJAX.
  We want our application to continue to be responsive, while waiting
  for the server to respond. By sending the request and receiving the
  response asynchronously, we accomplish this.

  Note that AJAX has XML in it's name, but that primarily has its origin in
  and older era, where XML was used far more frequently as a data interchange
  format. Nowadays, we primarily use JSON. There are still some places that
  use XML, but JSON is a bit more popular.
*/

let button = document.getElementById("btn");

button.addEventListener("click", ajaxFunc);




let input = document.getElementById("input");
// Represents the HTML element that is going to receive text

// In AJAX, you send a request using the XMLHttpRequest object,
// which is built into JS

function ajaxFunc() {

  let number = document.getElementById("field").value;

  // STEP 1
  let xhr = new XMLHttpRequest();
  // This object is used for asynchronous requests. You will
  // be required to know some of its properties.

  /*
    A readyState is a property which signifies that state that
    the request is currently in.
    There are several states:

    0. UNSENT : open() has not yet been called
    1. OPENED : open() has been called
    2. HEADERS_RECEIVED : send() has been called, and the headers of
        the response as well as the status are now available
    3. LOADING : Downloading the response. responseText (the xhr property) holds
        partial data
    4. DONE : The entire operation is now complete
  */

  // STEP 2
  xhr.onreadystatechange = function() {
    // An HTTP status code of 200, means OK
    // This means the request was processed correctly
    // and we should have acceptable data
    // readyState == 4 means that the operation is done
    if(this.readyState == 4 && this.status == 200) {
      let data = JSON.parse(xhr.responseText);

      // console.log(data);
      renderHTML(data);
    }
  }

  // STEP 3
  // Open the request
  xhr.open("GET", 'https://pokeapi.co/api/v2/pokemon/' + number);
  // This URL is setup to respond with a type of application/json
  // when it receives a GET request
  // GET is an HTTP verb/method which means we will be retrieving data
  // with this request
  // We also have the url

  // STEP 4
  // Send the request
  xhr.send();
}

function renderHTML(data) {
  input.append("Name: " + data.name);
  input.append(document.createElement("br"));

  input.append("ID: " + data.id);
  input.append(document.createElement("br"));

  let image = document.createElement("img");
  image.setAttribute("src", data.sprites.front_default);
  image.setAttribute("height", "300");
  image.setAttribute("width", "300");
  input.append(image);
  input.append(document.createElement("hr"));
}
