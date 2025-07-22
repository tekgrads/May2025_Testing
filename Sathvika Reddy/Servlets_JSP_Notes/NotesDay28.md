# Servlets and Tomcat Installation:

# Servlet Example Using Tomcat and Eclipse

## HTML Code Used

**File: `Sample1.html`**

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1>Hello Sathvika Welcome to Servlet Topic</h1>
</body>
</html>
```

---

## Output in Browser

**URL:** `http://localhost:8080/FirstServlet/Sample1.html`

**Output Displayed in Browser:**

> **Hello Sathvika Welcome to Servlet Topic**

As seen in the second image, the message appears in large heading (`<h1>`) format on the web page.

---

## Servlet System Architecture Diagram (Text Explanation)

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

### Servlet Execution Flow:

1. **Client (Browser)** sends a request to `/hello` or HTML page.
2. **Tomcat Server** receives it and identifies the target servlet.
3. Servlet handles request in `doGet()` method.
4. Servlet generates response dynamically (e.g., "Hello, Servlet!").
5. **Browser** displays the HTML output.

---

## How to Install Tomcat 10 and Attach to Eclipse (Web Version)

### Step 1: Install Apache Tomcat 10

1. Go to: [https://tomcat.apache.org/download-10.cgi](https://tomcat.apache.org/download-10.cgi)
2. Download the **zip version** (32/64-bit Windows zip).
3. Extract it to a known folder like `C:\apache-tomcat-10.0.xx`.

---

### Step 2: Install Eclipse IDE for Java EE Developers

1. Go to: [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/)
2. Choose **Eclipse IDE for Enterprise Java and Web Developers**.
3. Install and open Eclipse.

---

### Step 3: Attach Tomcat Server to Eclipse

1. Go to **Servers tab** (bottom Eclipse panel).
2. Click **"No servers are available. Click this link to create a new server..."**
3. Choose:

   * Apache → Tomcat v10.0 Server
   * Click **Next**
4. Browse to the folder where you extracted Tomcat (e.g., `C:\apache-tomcat-10.0.xx`)
5. Finish setup.
6. Now right-click on Tomcat server → **Start** to run.

---

### Step 4: Deploy HTML/Servlet Project

1. Create a **Dynamic Web Project** in Eclipse.
2. Place `Sample1.html` inside `WebContent` folder.
3. Right-click project → **Run on Server**.
4. Browser opens with output on `localhost:8080`.


