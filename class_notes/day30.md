Cookies and Servlets in Java

---

## 🌐 What is a Servlet?

A **Servlet** is a Java class used to handle HTTP requests and generate responses in web applications. It runs on a **Servlet container** like Apache Tomcat.

---

## 🍪 What is a Cookie?

A **Cookie** is a small piece of data stored on the **client-side (browser)** and sent back to the server with every request to maintain **session tracking**, **user preferences**, or **login states**.

---

## 📌 Why Use Cookies?

- Track user sessions
- Remember login credentials
- Personalize user experience

---

## 🧱 Types of Cookies

| Type            | Description                               |
|------------------|-------------------------------------------|
| **Persistent Cookie** | Stored on the client’s device with expiration time |
| **Session Cookie**    | Stored in memory, removed when browser closes     |

---

## 🧰 Cookie API in Java Servlet

Java provides the `javax.servlet.http.Cookie` class to create and manage cookies.

### ✅ Creating a Cookie (Server Side)

```java
Cookie cookie = new Cookie("username", "john");
cookie.setMaxAge(3600); // expires in 1 hour
response.addCookie(cookie);
✅ Reading Cookies (Server Side)
java
Copy
Edit
Cookie[] cookies = request.getCookies();
for(Cookie c : cookies) {
    if(c.getName().equals("username")) {
        String value = c.getValue();
    }
}
✅ Deleting a Cookie
java
Copy
Edit
Cookie cookie = new Cookie("username", "");
cookie.setMaxAge(0); // Deletes cookie
response.addCookie(cookie);
🔁 How Cookies Work with Servlets
🔹 Step-by-Step Flow:
Client sends request to server

Server creates a cookie using new Cookie()

Server sends cookie in response using response.addCookie()

Client browser stores the cookie

For future requests, the browser automatically sends the cookie back to the server

Server reads it using request.getCookies()

🧪 Example: Servlet Using Cookies
java
Copy
Edit
@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Cookie cookie = new Cookie("user", "laxmi");
        cookie.setMaxAge(600); // 10 minutes
        response.addCookie(cookie);
        response.getWriter().println("Cookie set successfully!");
    }
}
java
Copy
Edit
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("user")) {
                response.getWriter().println("Welcome " + cookie.getValue());
            }
        }
    }
}
🛠 Key Methods of Cookie Class
Method	Description
getName()	Returns cookie name
getValue()	Returns cookie value
setMaxAge(int sec)	Sets expiration time in seconds
setValue(String val)	Updates the value
getPath()	Returns path of the cookie


Edit









