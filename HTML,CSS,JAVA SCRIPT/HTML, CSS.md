# 🌐 HTML, CSS, JavaScript – Web Development Basics

## 🧠 Concept Summary

- **HTML** – Defines the **bare skeletal body** of the website.
- **CSS** – Adds **aesthetic decoration** (colors, layouts, etc.).
- **JavaScript** – Makes the website **interactive**.

> 💡 Files should have the extensions `.html`, `.css`, and `.js` respectively.

---

## 🧱 HTML: Structure

### ✅ Basic HTML Structure
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>

</body>
</html>

Elements Overview
<h1> to <h6> – Headings

The more you go down (h1 → h6), the smaller the heading size.

<p> – Paragraph

Use lorem10 in code editors to generate 10 dummy words.

<img> – Embeds an image
<img src="image.jpg" alt="Description">

<ol> / <ul> – Ordered / Unordered Lists
<ol>
  <li>Item One</li>
</ol>
<ul>
  <li>Item A</li>
</ul>

<table> – Create a Table

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

<form action="..." method="post"> – Create Forms

Use method="post" when sending data to the server.
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
  <input type="submit" value="Submit">
</form>

<div> – Defines a block/section in HTML

<div>
  <p>This is a section</p>
</div>

HTML Attributes
Used inside tags to add additional information:

Image tag
<img src="photo.jpg" alt="My Photo" width="200">

Block vs Inline Elements
Block Elements: Take up full width (e.g. <div>, <p>, <h1>)

Inline Elements: Take only required space (e.g. <span>, <a>, <img>)

🎨 CSS: Styling Your Website
🎨 Ways to Apply CSS
Inline CSS – Directly inside HTML tag

<h1 style="color: red;">Hello</h1>

Internal CSS – Inside <style> tag in the <head>
<style>
  body { background-color: lightblue; }

</style>External CSS – Linked .css file
<!-- In HTML -->
<link rel="stylesheet" href="style.css">

 Example: style.css
body {
    background-color: rgb(240, 240, 240);
}

JavaScript: Interactivity
Used to make the website behave dynamically (like alerts, validations, events).

Example: script.js
alert("Welcome to the website!");

Include in HTML:
<script src="script.js"></script>






