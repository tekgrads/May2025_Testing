
# Cookies and Sessions in Java Servlets

## What are Cookies?
Cookies are small pieces of data sent from a server to a client and stored in the user's web browser. They help maintain user information across different requests and sessions.

### Key Features of Cookies:
- Stored on the client-side.
- Can store small pieces of information (up to 4KB).
- Can be persistent or temporary (session cookies).
- Each cookie is a key-value pair.

### Creating and Sending Cookies from Servlet
```java
import java.io.IOException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Cookie cookie = new Cookie("username", "tekgrads");
        cookie.setMaxAge(60 * 60); // 1 hour
        res.addCookie(cookie);
        res.getWriter().println("Cookie created successfully");
    }
}
```

### Reading Cookies in Servlet
```java
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    res.getWriter().println("Hello " + cookie.getValue());
                }
            }
        }
    }
}
```

---

## What is a Session?
A **Session** is a server-side storage mechanism used to store user data across multiple requests from the same user. Sessions are more secure than cookies since the data is stored on the server.

### Key Features of Sessions:
- Server-side storage.
- Automatically created when a user interacts with a servlet.
- Tracks user interaction using a session ID stored in a cookie.

### Creating and Using Sessions in Servlets
```java
import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/loginSession")
public class LoginSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session.setAttribute("user", username);
        res.getWriter().println("Session created for user: " + username);
    }
}
```

### Accessing Session Attributes
```java
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false); // false = don't create if it doesn't exist
        if (session != null) {
            String username = (String) session.getAttribute("user");
            res.getWriter().println("Welcome back, " + username);
        } else {
            res.getWriter().println("No active session found. Please log in.");
        }
    }
}
```

### Invalidating a Session
```java
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        res.getWriter().println("You have been logged out.");
    }
}
```

---

## Comparison: Cookies vs Sessions

| Feature         | Cookies                         | Sessions                        |
|-----------------|----------------------------------|----------------------------------|
| Storage         | Client-side                      | Server-side                      |
| Capacity        | Limited (~4KB)                   | Large                            |
| Security        | Less secure (stored on browser)  | More secure (stored on server)   |
| Lifespan        | Can be persistent                | Ends with logout/session timeout |
| Use case        | Store non-sensitive info         | Track user login/data            |

---

## Sample HTML Forms

### LoginForm.html
```html
<form action="loginSession" method="post">
    <input type="text" name="username" placeholder="Enter username" required />
    <input type="submit" value="Login" />
</form>
```

### Dashboard Link
```html
<a href="dashboard">Go to Dashboard</a>
<a href="logout">Logout</a>
```

---

