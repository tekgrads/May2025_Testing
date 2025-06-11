## 🌐 Web Development Basics – HTML, CSS, JavaScript

### 🧠 Concept Summary

* **HTML**: Provides the skeletal layout of web content.
* **CSS**: Adds style, colors, spacing, and fonts.
* **JavaScript**: Introduces dynamic interaction and functionality.

**File Extensions Used:**

* `.html` → Webpage structure
* `.css` → Styling rules
* `.js` → Scripting behavior

---

### 🧱 HTML: Web Structure

#### 🧾 Standard HTML Layout

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Website Example</title>
</head>
<body>

</body>
</html>
```

#### 🔑 Common HTML Elements

* **Headings (`<h1>` to `<h6>`)**

```html
<h1>Main Heading</h1>
<h4>Sub-heading</h4>
```

* **Paragraph (`<p>`)**

```html
<p>This is an HTML paragraph example.</p>
```

* **Image (`<img>`)**

```html
<img src="pic.jpg" alt="Picture" width="180">
```

* **Lists**

```html
<ol>
  <li>Step 1</li>
  <li>Step 2</li>
</ol>

<ul>
  <li>Apple</li>
  <li>Banana</li>
</ul>
```

* **Table Example**

```html
<table border="1">
  <thead>
    <tr><th>Title</th></tr>
  </thead>
  <tbody>
    <tr><td>Details</td></tr>
  </tbody>
  <tfoot>
    <tr><td>End</td></tr>
  </tfoot>
</table>
```

* **Form Example**

```html
<form action="/login" method="post">
  <label for="user">User:</label>
  <input type="text" id="user" name="user">
  <input type="submit" value="Submit">
</form>
```

* **Division (`<div>`)**

```html
<div>
  <p>This content is inside a division tag</p>
</div>
```

#### 🧩 HTML Attributes

```html
<img src="image.jpg" alt="My Image" width="200">
```

* `src`: Location of image
* `alt`: Text if image fails to load
* `width`: Width of image

#### 🔲 Block vs Inline Tags

* **Block**: Occupy full width. E.g., `<div>`, `<h1>`, `<p>`
* **Inline**: Only take up needed space. E.g., `<span>`, `<a>`, `<img>`

---

### 🎨 CSS: Styling the Page

#### 🖌️ CSS Types

1. **Inline** – Style within the tag

```html
<h2 style="color: blue;">Styled Heading</h2>
```

2. **Internal** – Style block inside HTML head

```html
<head>
  <style>
    body {
      margin: 20px;
    }
  </style>
</head>
```

3. **External** – Linked CSS file

```html
<!-- HTML -->
<link rel="stylesheet" href="main.css">
```

```css
/* main.css */
body {
  font-family: Arial;
}
```

---

### 🔧 JavaScript: Making Pages Interactive

#### 🔁 Basic JavaScript Example

```javascript
// file: main.js
console.log("Website Loaded Successfully!");
```

#### 📎 Linking JS to HTML

```html
<script src="main.js"></script>
```

---

### 📋 Tables in HTML

#### 📐 Table Sample

```html
<table border="1">
  <thead>
    <tr>
      <th colspan="2">Subject Info</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="2">Mathematics</td>
      <td>Algebra</td>
    </tr>
    <tr>
      <td>Geometry</td>
    </tr>
  </tbody>
</table>
```

#### 📑 Table Tags Summary

| Tag / Attribute | Description                |
| --------------- | -------------------------- |
| `<table>`       | Table wrapper              |
| `<thead>`       | Header rows                |
| `<tbody>`       | Main content rows          |
| `<tfoot>`       | Footer content (optional)  |
| `<tr>`          | Row container              |
| `<th>`          | Header cell                |
| `<td>`          | Data cell                  |
| `rowspan`       | Merge rows vertically      |
| `colspan`       | Merge columns horizontally |

---

### 📨 HTML Forms – Data Collection

#### 📝 Simple Form Example

```html
<form action="/submit" method="post">
  <label for="email">Email:</label>
  <input type="email" id="email" name="email">
  <input type="submit" value="Send">
</form>
```

#### ⚙️ Common Form Attributes

| Attribute  | Meaning                        |
| ---------- | ------------------------------ |
| `action`   | Server endpoint                |
| `method`   | How data is sent (POST or GET) |
| `type`     | Field type (text, email, etc.) |
| `name`     | Field key for server           |
| `id`       | Unique field identifier        |
| `required` | Must be filled                 |
| `value`    | Default field value            |

#### 📂 Complete Form Example

```html
<form action="/register" method="post">
  <label for="uname">Username:</label>
  <input type="text" id="uname" name="uname" required>

  <label for="pwd">Password:</label>
  <input type="password" id="pwd" name="pwd" required>

  <label>Gender:</label>
  <input type="radio" name="gender" value="male"> Male
  <input type="radio" name="gender" value="female"> Female

  <label for="news">Subscribe:</label>
  <input type="checkbox" id="news" name="news" checked>

  <input type="submit" value="Register">
</form>
```

#### ✅ Good Practices

* Always link `<label>` to `id` with `for`
* Use `name` for data binding
* Prefer `method="post"` for secure form handling
* Use suitable input types for validation and UX

---

### 🧩 Final Recap

* **HTML** creates the structure
* **CSS** styles the content
* **JavaScript** adds behavior

Together, they create engaging and fully functional web applications.

