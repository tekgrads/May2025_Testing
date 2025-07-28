
#  Servlets and Tomcat Installation Guide

---

##  HTML Code Used

**File: Sample1.html**
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1>Hello Charitha  Welcome to Servlet Topic</h1>
</body>
</html>
```

---

##  Output in Browser

**URL:** `http://localhost:8080/FirstServlet/Sample1.html`

**Output Displayed in Browser:**

```
Hello Charitha Welcome to Servlet Topic
```

Displayed using `<h1>` tag — appears as a large heading on the web page.

---

##  Servlet System Architecture (Text Diagram)

```
Browser
   |
   | Sends a request to
   V
Tomcat Server (Servlet Container)
   |
   | Hosts multiple web apps like:
   | -> FirstServlet
   | -> Other applications
   |
   | Finds the appropriate servlet (via web.xml or annotations)
   | Processes the request in doGet()
   | Generates HTML Response
   V
Response is sent back to browser
```

---

## Servlet Execution Flow

1. Client (Browser) sends a request to `/hello` or HTML page.
2. Tomcat Server receives it and identifies the target servlet.
3. Servlet handles request in `doGet()` method.
4. Servlet generates response dynamically (e.g., "Hello, Servlet!").
5. Browser displays the HTML output.

---

##  How to Install Tomcat 10 and Attach to Eclipse (Web Version)

###  Step 1: Install Apache Tomcat 10
- Go to: [Tomcat Downloads](https://tomcat.apache.org/download-10.cgi)
- Download the zip version (32/64-bit Windows zip).
- Extract it to a known folder like `C:\apache-tomcat-10.0.xx`.

###  Step 2: Install Eclipse IDE for Java EE Developers
- Go to: [Eclipse Downloads](https://www.eclipse.org/downloads/)
- Choose **Eclipse IDE for Enterprise Java and Web Developers**.
- Install and open Eclipse.

### Step 3: Attach Tomcat Server to Eclipse
1. Go to **Servers tab** (bottom Eclipse panel).
2. Click `"No servers are available. Click this link to create a new server..."`.
3. Choose:
   - **Apache → Tomcat v10.0 Server**
4. Click **Next**.
5. Browse to the folder where you extracted Tomcat (e.g., `C:\apache-tomcat-10.0.xx`)
6. Finish setup.
7. Right-click on Tomcat server → **Start** to run.

###  Step 4: Deploy HTML/Servlet Project
- Create a **Dynamic Web Project** in Eclipse.
- Place `Sample1.html` inside **WebContent** folder.
- Right-click project → **Run on Server**.
- Browser opens with output on `localhost:8080`.


