# 🌐 Web Technologies Day 1 Notes – HTML, CSS & JavaScript

## 1. What is HTML?
**HTML (HyperText Markup Language)** is the standard language used to create and structure web pages. It defines the layout using elements like headings, paragraphs, links, images, tables, etc.

- HTML gives structure to the content.
- It is a markup language, not a programming language.
- Common file extension: `.html`

---

## 2. What is CSS?
**CSS (Cascading Style Sheets)** is used to style and design HTML elements. It defines the look and feel of a web page such as layout, colors, fonts, spacing, and alignment.

- CSS separates design from content.
- You can write CSS inside the HTML file (internal) or in a separate file (external).
- Common file extension: `.css`

---

## 3. What is JavaScript?
**JavaScript** is a client-side scripting language used to make a web page interactive. It helps respond to user actions such as clicking a button, submitting a form, or fetching data dynamically.

- JavaScript is a programming language.
- It is mostly used in the browser, but can also be used on the server (Node.js).
- Common file extension: `.js`

---

## 4. Basic HTML Structure Example

```html
<!DOCTYPE html>
<html>
  <head>
    <title>My First Web Page</title>
    <style>
      body {
        font-family: Arial;
        background-color: #f0f0f0;
      }
      h1 {
        color: green;
      }
    </style>
  </head>
  <body>
    <h1>Hello, World!</h1>
    <p>This is a simple web page using HTML, styled with CSS.</p>

    <button onclick="showMessage()">Click Me</button>

    <script>
      function showMessage() {
        alert("Hello from JavaScript!");
      }
    </script>
  </body>
</html>
```

---

## 5. Explanation of the Code

| Tag/Section      | Purpose                                                                 |
|------------------|-------------------------------------------------------------------------|
| `<!DOCTYPE html>` | Declares the document type (HTML5)                                      |
| `<html>`          | Root element of the HTML document                                       |
| `<head>`          | Contains metadata, title, and style information                         |
| `<title>`         | Sets the title of the web page (shown in browser tab)                  |
| `<style>`         | Contains CSS code to style HTML elements                               |
| `<body>`          | Contains the content visible on the web page                            |
| `<h1>`            | Main heading of the page                                                |
| `<p>`             | Paragraph text                                                          |
| `<button>`        | Clickable button element                                                |
| `onclick="..."`   | JavaScript event handler that runs code when the button is clicked      |
| `<script>`        | Contains JavaScript code                                                |
| `alert()`         | JavaScript function that shows a popup message                         |

---

## 6. Summary

- **HTML** builds the structure of the webpage.
- **CSS** designs the structure with colors, fonts, and layout.
- **JavaScript** adds interactivity like button clicks, alerts, and form handling.

All three together help create modern, dynamic web applications.
