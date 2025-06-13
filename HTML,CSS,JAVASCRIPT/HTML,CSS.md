# Web Development Basics – HTML, CSS, JavaScript

## 📄 HTML (HyperText Markup Language)
HTML is the standard markup language for creating web pages and web applications. It defines the structure of web content.

### 🔹 Structure of an HTML Document
```html
<!DOCTYPE html>
<html>
  <head>
    <title>My First Web Page</title>
  </head>
  <body>
    <h1>Hello, World!</h1>
    <p>This is a paragraph.</p>
  </body>
</html>
```

### 🔹 Common HTML Tags
| Tag | Description |
|-----|-------------|
| `<h1>` to `<h6>` | Headings |
| `<p>` | Paragraph |
| `<a>` | Anchor (links) |
| `<img>` | Image |
| `<div>` | Division/Container |
| `<span>` | Inline container |
| `<ul>`, `<ol>`, `<li>` | Lists |
| `<form>`, `<input>`, `<button>` | Forms |
| `<table>`, `<tr>`, `<td>` | Tables |

### 🔹 Semantic HTML
Tags like `<article>`, `<section>`, `<header>`, `<footer>`, `<main>`, `<aside>`, and `<nav>` help structure a page meaningfully and improve accessibility and SEO.

### 🔹 HTML Forms Example
```html
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
  <button type="submit">Submit</button>
</form>
```

---

##  CSS (Cascading Style Sheets)
CSS describes how HTML elements are to be displayed on screen.

### 🔹 Types of CSS
1. **Inline CSS**: added directly into the HTML tag.
2. **Internal CSS**: included within a `<style>` tag in the head.
3. **External CSS**: linked via a `.css` file using `<link>` tag.

### 🔹 CSS Syntax
```css
selector {
  property: value;
}
```

### 🔹 Example
```css
body {
  background-color: #f0f0f0;
  font-family: Arial, sans-serif;
}

h1 {
  color: navy;
  text-align: center;
}
```

### 🔹 CSS Properties
- `color`, `background-color`
- `font-size`, `font-family`, `font-weight`
- `margin`, `padding`, `border`
- `display`, `position`, `flex`, `grid`

### 🔹 Responsive Design
- Use of `@media` queries for different screen sizes:
```css
@media (max-width: 768px) {
  body {
    background-color: lightblue;
  }
}

