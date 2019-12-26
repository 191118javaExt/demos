# HTTP
- Hyper Text Transfer Protocol
- Primary networking protocol used for client-server communication
  - The internet (world-wide-web)
- This is also specifically used for RESTful web services
- For now, it's important to understand the differences between different
  HTTP verbs (methods), such as GET and POST as well as HTTP status codes
- All HTTP messages are composed of a header and a body which contains different
  pieces of information.. The header normally represents the metadata about the
  request. Whereas the body represents the data in the message, or the message itself.
- GET vs POST
  - GET is utilized to retrieve data. We're retrieving data from some url, or endpoint,
    and normally clients and servers are not expecting these messages to contain content
    within the body. (Although, you definitely still can)
  - POST is generally used to send/update information on the url/endpoint, which means
    that the server os expecting the message to have information in the body.
- HTTP responses have a status code that represent the status of the request. We'll talk
  more about them in a moment, but we have seen examples such as 200 OK, and 201 CREATED
- HTTP responses can also have a body. If a GET request was performed, generally,
  the response is stored in the body.

## HTTP Status Codes
- There are 5 different sets of status codes
  1. 1XX Series, informational messages
  2. 2XX Series, requests were successful
    - 200 OK
    - 201 CREATED
  3. 3XX, redirection
    - 301 Moved Permanently
    - 307 Temporary Redirect
  4. 4XX, Client-Side errors
    - 400 Bad Request
    - 401 Not Authorized
    - 403 Forbidden
    - 404 Not Found
    - 418 I'm a Teapot
  5. 5XX, Server-Side errors
    - 500 Internal Server Error
    - 501 Not Implemented
    - 502 Bad Gateway
    - 504 Gateway timeout

## Sessions
- The practice of storing information about the user in the server in order
  to improve user experience

Why do sessions matter?
- User Experience: Saving session information locally prevents
  needless hits to your database, which improves performance and allows you
  to personalize a user's experience.
- Security: Verify that a user actually has access to a resource that was
  provided by your website. Disallow access to sensitive information.

## Sending Users to different locations on the Web / Redirects
- Servlets take requests from clients and forward them to requested resources. How?
  - There are 2 ways:
    - SendRedirect
      - Supplied by Response object
      - This is a method: response.sendRedirect(location);
      - Actually send a response back to the client and then
        sends a new request back.
      - As a result, the information in the previous request is lost
      - Returns a 300 Series status code
    - Forward
      - Supplied by Request object
      - This method is declared on the RequestDispatcher Interface
      - When you use forward, the request never leaves the server
      - You can't request dispatch into another location (stay within same domain)
      - You make only 1 request, not 2

  - Main Takeaway:
    - Use sendRedirect when your client asks for a resource that is in some
      other location (the extra request is visible in the client as a new request)
    - Use forward if the your client is asking for a resource from the same
      project (something you have access to immediately)
    - Forward is handled by the server
    - sendRedirect is handled by the browser/client

## Servlet Config
- ServletConfig (interface) provides objects that are used by the Servlet
  containers (aka web container) to pass information to a servlet during
  initialization
