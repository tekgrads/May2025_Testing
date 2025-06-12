🌐 Web Development Basics – HTML, CSS, JavaScript
🧠 Concept Summary
HTML – Defines the skeletal structure of the website.(Hypertext Markup Language)
CSS – Adds styling and layout to the website.(Cascading Styling Sheets)
JavaScript – Makes the website interactive and dynamic.
File extensions:
.html → HTML
.css → CSS
.js → JavaScript
🧱 HTML: Structure
✅ Basic HTML Template
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>

</body>
</html>
🏷️ Common HTML Elements
Headings (<h1> to <h6>)
<h1>Heading 1</h1>
<h2>Heading 2</h2>
<h3>Heading 3</h3>
<h4>Heading 4</h4>
<h5>Heading 5</h5>
<h6>Heading 6</h6>
Paragraph (<p>)
<p>This is a paragraph of text.</p>
Image (<img>)
<img src="image.jpg" alt="Image description" width="200">
Ordered List (<ol>)
<ol>
  <li>Item One</li>
  <li>Item Two</li>
</ol>
Unordered List (<ul>)
<ul>
  <li>Item A</li>
  <li>Item B</li>
</ul>
Table (<table>)
<table>
  <thead>
    <tr>
      <th>Header</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2">Row Data</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td>Footer</td>
    </tr>
  </tfoot>
</table>
Form (<form>)
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
  <input type="submit" value="Submit">
</form>
Division (<div>)
<div>
  <p>This is a section</p>
</div>
✨ HTML Attributes
<img src="photo.jpg" alt="My Photo" width="200">
src: Image source path
alt: Alternative text
width: Width in pixels
🧩 Block vs Inline Elements
Block Elements: Take full width, start on a new line
Example: <div>, <p>, <h1>, <table>

Inline Elements: Take only required width, appear in-line
Example: <span>, <a>, <img>

🎨 CSS: Styling
1️⃣ Inline CSS
<h1 style="color: red;">Hello</h1>
2️⃣ Internal CSS
<head>
  <style>
    body {
      background-color: lightblue;
    }
  </style>
</head>
3️⃣ External CSS
<!-- In HTML file -->
<link rel="stylesheet" href="style.css">
/* style.css */
body {
  background-color: rgb(240, 240, 240);
}
🔧 JavaScript: Interactivity
Example JavaScript File
// script.js
alert("Welcome to the website!");
Include in HTML
<script src="script.js"></script>
📋 Table in HTML
✅ Basic Table Structure
<table>
  <thead>
    <tr>
      <th>Header</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2">Row Data</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td>Footer</td>
    </tr>
  </tfoot>
</table>
🧩 Explanation of Table Tags
Tag	Meaning	Description
<table>	Table container	Wraps the whole table.
<thead>	Table Head	Contains header rows (usually bold). Appears at the top.
<tbody>	Table Body	Contains the main rows of data.
<tfoot>	Table Footer	Optional. Contains summary or footer rows, often at the bottom.
<tr>	Table Row	Defines a single row of cells (both header and data).
<th>	Table Header Cell	Creates a header cell (bold & centered by default). Inside <thead>.
<td>	Table Data Cell	Standard data cell used inside <tr> under <tbody> or <tfoot>.
rowspan	Attribute (used in <td> or <th>)	Makes a cell span multiple rows vertically.
colspan	Attribute (used in <td> or <th>)	Makes a cell span multiple columns horizontally.
📝 Example with rowspan and colspan
<table border="1">
  <thead>
    <tr>
      <th colspan="2">Header (colspan)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2">Left cell (rowspan)</td>
      <td>Right Top</td>
    </tr>
    <tr>
      <td>Right Bottom</td>
    </tr>
  </tbody>
</table>
colspan="2": Makes the header cell stretch across 2 columns.
rowspan="2": Makes the left cell span 2 rows vertically.
📝 HTML Forms – Collecting User Input
HTML forms are used to collect data from users, such as names, emails, passwords, or feedback. Forms usually contain input fields, labels, buttons, and are submitted to a server.

✅ Basic Form Example
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">

  <label for="email">Email:</label>
  <input type="email" id="email" name="email">

  <input type="submit" value="Submit">
</form>
🧩 Explanation of Form Tags & Attributes
Tag / Attribute	Purpose
<form>	Defines the form container.
action="/submit"	URL where the form data will be sent.
method="post"	HTTP method used to send data (post = secure, get = URL visible).
<label>	Text label for an input field.
for="name"	Connects the label to an input using the input's id.
<input>	Field for user input. Requires a type.
type="text"	Creates a single-line text input.
type="email"	Creates an email input (validates email format).
type="submit"	Creates a button to submit the form.
id="..."	Unique identifier for linking labels and for CSS/JavaScript targeting.
name="..."	Name of the input (key used when sending data to server).
🎯 Common Input Types
<input type="text">        <!-- Single-line text input -->
<input type="password">    <!-- Hides typed characters -->
<input type="email">       <!-- Email input with validation -->
<input type="number">      <!-- Numeric input -->
<input type="checkbox">    <!-- Checkbox -->
<input type="radio">       <!-- Radio button -->
<input type="file">        <!-- File upload -->
<input type="submit">      <!-- Submit button -->