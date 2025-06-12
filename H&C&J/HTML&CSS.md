# 🌐 HTML, CSS, JavaScript – Web Development Basics

---

## 🧠 Concept Summary

- **HTML** – Defines the basic structure of the webpage.
- **CSS** – Adds styling and layout to make the site look good.
- **JavaScript** – Adds interactivity and dynamic behavior.

> 💡 File Extensions:
> - `.html` for HTML
> - `.css` for CSS
> - `.js` for JavaScript

---

## 🧱 HTML: Structure

### ✅ Basic HTML Template

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>

</body>
</html>
📋 Common HTML Elements
<h1> to <h6> – Headings (h1 is largest, h6 is smallest)

<p> – Paragraph
Use lorem10 in code editors to generate 10 dummy words.

<img> – Embeds an image
Example:

html
Copy
Edit
<img src="image.jpg" alt="Description">
<ol> / <ul> – Ordered and Unordered Lists
Example:

html
Copy
Edit
<ol>
  <li>Item One</li>
</ol>

<ul>
  <li>Item A</li>
</ul>
<table> – Create a Table
Example:

html
Copy
Edit
<table>
  <thead>
    <tr><th>Header</th></tr>
  </thead>
  <tbody>
    <tr><td rowspan="2">Row Data</td></tr>
  </tbody>
  <tfoot>
    <tr><td>Footer</td></tr>
  </tfoot>
</table>
<form> – Create a Form
Use method="post" to send data to a server
Example:

html
Copy
Edit
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
  <input type="submit" value="Submit">
</form>
<div> – A block element used to group content

html
Copy
Edit
<div>
  <p>This is a section</p>
</div>
⚙️ HTML Attributes
Used inside tags to provide extra information.

Example:

html
Copy
Edit
<img src="photo.jpg" alt="My Photo" width="200">
🧱 Block vs Inline Elements
Type	Behavior	Examples
Block	Takes full width of the page	<div>, <p>, <h1>
Inline	Takes only as much width as needed	<span>, <a>, <img>

🎨 CSS: Styling Your Website
🎨 Ways to Apply CSS
Inline CSS – Directly in the HTML tag

html
Copy
Edit
<h1 style="color: red;">Hello</h1>
Internal CSS – Inside a <style> tag in the HTML <head>

html
Copy
Edit
<style>
  body { background-color: lightblue; }
</style>
External CSS – In a separate .css file
Link it in HTML:

html
Copy
Edit
<link rel="stylesheet" href="style.css">
Example style.css:

css
Copy
Edit
body {
    background-color: rgb(240, 240, 240);
}
⚙️ JavaScript: Interactivity
JavaScript is used to make the website dynamic – like showing alerts, responding to clicks, validating forms, etc.

Example script.js
javascript
Copy
Edit
alert("Welcome to the website!");
Link JS to HTML
html
Copy
Edit
<script src="script.js"></script>
