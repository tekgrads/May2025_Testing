
# HTML Concepts Overview

## 1. What is HTML?

HTML (HyperText Markup Language) is the standard markup language used to create web pages. It describes the structure of a web page using a system of tags and attributes.

---

## 2. Basic HTML Document Structure

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

### Elements in the Structure:
- `<!DOCTYPE html>`: Declares the document type.
- `<html>`: Root element.
- `<head>`: Contains metadata and title.
- `<body>`: Contains visible content.

---

## 3. Common HTML Tags

| Tag         | Description |
|-------------|-------------|
| `<h1>` to `<h6>` | Headings (h1 is largest) |
| `<p>`       | Paragraph |
| `<a>`       | Anchor (link) |
| `<img>`     | Image |
| `<ul>` / `<ol>` | Unordered / Ordered List |
| `<li>`      | List item |
| `<div>`     | Division (block container) |
| `<span>`    | Inline container |
| `<table>`   | Table structure |
| `<form>`    | Form for user input |

---

## 4. Attributes

Attributes provide additional information about elements.

### Example:
```html
<a href="https://example.com" target="_blank">Visit Example</a>
```

- `href`: Link destination
- `target="_blank"`: Opens in new tab

---

## 5. Forms and Input

HTML forms allow users to input data.

### Example:
```html
<form action="/submit" method="post">
    Name: <input type="text" name="username"><br>
    <input type="submit" value="Submit">
</form>
```

---

## 6. Multimedia in HTML

### Image:
```html
<img src="image.jpg" alt="Sample Image" width="200">
```

### Video:
```html
<video controls>
    <source src="video.mp4" type="video/mp4">
</video>
```

---

## 7. Semantic Tags

Semantic tags clearly define their meaning in HTML.

- `<header>`: Top section
- `<nav>`: Navigation links
- `<main>`: Main content
- `<section>`: Section of content
- `<article>`: Independent content
- `<footer>`: Bottom section

---

## 8. HTML5 Features

- Audio and video support
- Local storage APIs
- Geolocation API
- Canvas for graphics

---

## 9. Best Practices

- Use semantic tags for better SEO and accessibility.
- Keep code indented and well-commented.
- Use lowercase for tags and attributes.
- Validate your HTML.

---

