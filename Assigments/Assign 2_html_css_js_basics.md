# Introduction to HTML, CSS, JS & DNS

## HTML (HyperText Markup Language)
HTML is the standard markup language used to create the structure of web pages.

### Example:
```html
<!DOCTYPE html>
<html>
<head>
  <title>My First Web Page</title>
</head>
<body>
  <h1>Hello, world!</h1>
</body>
</html>
```

---

## CSS (Cascading Style Sheets)
CSS is used to style and layout HTML elements, including colors, fonts, and spacing.

### Example:
```html
<style>
  body {
    background-color: lightblue;
  }
</style>
```

---

## JavaScript (JS)
JavaScript is a programming language that enables interactive web pages.

### Alert Example:
```html
<script>
  alert("Welcome to my website!");
</script>
```

---

## Importance of DNS
DNS (Domain Name System) translates human-readable domain names (e.g., google.com) into IP addresses that computers use to identify each other on the network.

---

## HTML Tags

### Heading Tags
Headings range from `<h1>` to `<h6>`, where `<h1>` is the most important.
```html
<h1>Main Heading</h1>
<h2>Sub Heading</h2>
```

### Tables
```html
<table border="1">
  <tr>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <tr>
    <td>Alice</td>
    <td>22</td>
  </tr>
</table>
```

### Background Color (CSS)
```html
<body style="background-color:yellow;">
  This page has a yellow background.
</body>
```

### Insert Image Tag
```html
<img src="image.jpg" alt="My Image" width="300" height="200">
```

### Form Tag
```html
<form action="submit.php" method="post">
  <input type="text" name="username">
  <input type="submit">
</form>
```

### Div Tag
```html
<div style="border:1px solid black; padding:10px;">
  This is a division block.
</div>
```

### Label Tag
```html
<label for="email">Email:</label>
<input type="email" id="email" name="email">
```

### Button Tag
```html
<button onclick="alert('Button clicked!')">Click Me</button>
```

### Class Attribute
Used in HTML to define a class name that can be styled using CSS.
```html
<style>
  .highlight {
    color: red;
    font-weight: bold;
  }
</style>
<p class="highlight">This is a highlighted paragraph.</p>
```

---

