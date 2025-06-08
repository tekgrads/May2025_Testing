# HTML and CSS Markdown Guide for GitHub

## HTML

**HTML (HyperText Markup Language)** is the standard markup language for creating web pages.

* Used to structure content.
* Webpages are built using HTML tags.

### Basic HTML Tags

| Tag              | Description            |
| ---------------- | ---------------------- |
| `<head>`         | Metadata container     |
| `<title>`        | Page title             |
| `<body>`         | Page content container |
| `<img>`          | Inserts an image       |
| `<video>`        | Embeds a video         |
| `<h1>` to `<h6>` | Headings               |
| `<br>`           | Line break             |
| `<b>`            | Bold text              |
| `<i>`            | Italic text            |
| `<u>`            | Underline text         |
| `<li>`           | List item              |
| `<ol>`           | Ordered list           |
| `<ul>`           | Unordered list         |
| `<table>`        | Table element          |
| `<tr>`           | Table row              |
| `<td>`           | Table cell             |
| `<th>`           | Table header           |
| `<tbody>`        | Table body             |
| `<tfoot>`        | Table footer           |
| `<a>`            | Hyperlink              |
| `<form>`         | Form element           |
| `<hr>`           | Horizontal line        |
| `<caption>`      | Table caption          |
| `<div>`          | Document section       |

### HTML Sample

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

## HTML Forms

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forms - Lets learn it</title>
</head>
<body>
    <h1>WEB DESIGNING PAGE</h1>
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
            <label for="comment">Enter your comment</label>
            <br>
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
</body>
</html>
```

### Notes

* Form method should be `post`.
* `label for` must match the `input id`.
* Use the same `name` for related radio inputs.
* Use `<select>` with `<option>` for dropdowns.

## CSS

**CSS (Cascading Style Sheets)** is used to style HTML documents.

* Controls color, layout, fonts, spacing, etc.
* Linked using: `<link rel="stylesheet" href="style.css">`

### CSS Syntax

```css
/* Style for all paragraphs */
p {
  background-color: aquamarine;
}

/* Style for links */
a {
  background-color: rgb(242, 160, 122);
}

/* Style for divs */
div {
  background-color: yellow;
}

/* Class selector */
.bg-yellow {
  background-color: yellow;
}

/* ID selector */
#firstdiv {
  background-color: red;
}
```

### Types of CSS

1. **Inline CSS** – Style written directly in the HTML tag:

   ```html
   <p style="color:red;font-size:20px;">Text</p>
   ```

2. **Internal CSS** – CSS inside a `<style>` block within the HTML file:

   ```html
   <style>
     .main {
       background-color: red;
     }
   </style>
   ```

3. **External CSS** – CSS in a separate `.css` file linked to the HTML:

   ```html
   <link rel="stylesheet" href="style.css">
   ```
