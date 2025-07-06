# HTML & CSS Guide for Git (Markdown Format)

---

## 1. HTML

**HTML** stands for **HyperText Markup Language**. It is used to create webpages using HTML tags.

### Example:

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <video src="video4.mp4" controls></video>
</body>
</html>
```

---

## 2. CSS

**CSS** stands for **Cascading Style Sheets**. It is used to style webpages by adding colors, backgrounds, fonts, and more.

### Linking CSS:

```html
<link rel="stylesheet" href="style.css">
```

---

## 3. Important HTML Tags

| Tag              | Description                             |
| ---------------- | --------------------------------------- |
| `<head>`         | Defines the head section of the webpage |
| `<title>`        | Sets the title of the webpage           |
| `<body>`         | Main content of the webpage             |
| `<img>`          | Adds an image                           |
| `<video>`        | Adds a video                            |
| `<h1>` to `<h6>` | Headings                                |
| `<br>`           | Line break                              |
| `<b>`            | Bold text                               |
| `<i>`            | Italic text                             |
| `<u>`            | Underlined text                         |
| `<li>`           | List item                               |
| `<ol>`           | Ordered list                            |
| `<ul>`           | Unordered list                          |
| `<table>`        | Table                                   |
| `<tr>`           | Table row                               |
| `<td>`           | Table data                              |
| `<tbody>`        | Table body                              |
| `<tfoot>`        | Table footer                            |
| `<th>`           | Table header                            |
| `<a>`            | Hyperlink                               |
| `<form>`         | Form creation                           |
| `<hr>`           | Horizontal line                         |
| `<caption>`      | Table caption                           |
| `<div>`          | Division or section                     |

---

## 4. HTML Form Example

```html
<form method="post">
  <div>
    <label for="username">Enter your Username</label>
    <input type="text" id="username" name="username" placeholder="Enter your username" autofocus>
  </div>

  <div>
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label>
  </div>

  <div>
    <input type="checkbox" id="subscribe" name="subscribe" value="yes">
    <label for="subscribe">Subscribe to newsletter</label>
  </div>

  <div>
    <label for="comment">Enter your comment</label><br>
    <textarea id="comment" name="comment" rows="4" cols="50"></textarea>
  </div>

  <div>
    <select name="fruits">
      <option value="apple">Apple</option>
      <option value="banana">Banana</option>
      <option value="cherry">Cherry</option>
    </select>
  </div>
</form>
```

---

## 5. CSS Example

**Create a new file named `style.css` and link it in your HTML file.**

```css
p {
  background-color: aquamarine;
}

a {
  background-color: rgb(242, 160, 122);
}

div {
  background-color: yellow;
}

.bg-yellow {
  background-color: yellow; /* class style */
}

#firstdiv {
  background-color: red; /* id style */
}
```

---

## 6. Types of CSS

### 1. Inline CSS

Used directly in the HTML tag.

```html
<p style="color: red; font-size: 20px;">Text</p>
```

### 2. Internal CSS

Defined within `<style>` tags in the HTML file.

```html
<head>
  <style>
    .main {
      background-color: red;
    }
  </style>
</head>
```

### 3. External CSS

Defined in a separate `.css` file and linked to the HTML.

```css
/* style.css */
p {
  background-color: aquamarine;
}
```

---
