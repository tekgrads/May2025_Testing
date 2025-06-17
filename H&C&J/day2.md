## 1️⃣ CSS Types

### ✅ Inline CSS
Applied directly to an HTML element using the `style` attribute.

```html
<p style="color: red; font-size: 20px;">
  This is red text using inline CSS.
</p>
✅ Internal CSS
Defined inside a <style> tag, usually within the <head> section.

html
Copy
Edit
<!DOCTYPE html>
<html>
<head>
  <style>
    h1 {
      color: blue;
      text-align: center;
    }
  </style>
</head>
<body>
  <h1>Internal CSS Example</h1>
</body>
</html>
✅ External CSS
Written in a separate .css file and linked to HTML using the <link> tag.

index.html

html
Copy
Edit
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <h2>External CSS Example</h2>
</body>
</html>
styles.css

css
Copy
Edit
h2 {
  color: green;
  font-family: Arial, sans-serif;
}
2️⃣ CSS Selectors
⭐ Universal Selector
Applies to all elements.

css
Copy
Edit
* {
  margin: 0;
  padding: 0;
}
📄 Element Selector
Targets by element name.

css
Copy
Edit
p {
  color: gray;
}
🎯 Class Selector
Targets by class name (use dot .).

css
Copy
Edit
.highlight {
  background-color: yellow;
}
🆔 ID Selector
Targets a specific element with an ID (use #).

css
Copy
Edit
#main {
  font-size: 24px;
}
📚 Group Selector
Applies styles to multiple elements at once.

css
Copy
Edit
h1, h2, p {
  margin-bottom: 10px;
}
🧱 Descendant Selector
Targets elements inside other elements.

css
Copy
Edit
div p {
  color: blue;
}
👶 Child Selector
Targets only the direct children (not deeper nested elements).

css
Copy
Edit
div > p {
  color: green;
}
3️⃣ HTML Video Tag
Use to embed video content with controls:

html
Copy
Edit
<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
4️⃣ SVG (Scalable Vector Graphics)
Draw graphics like shapes directly in HTML.

html
Copy
Edit

5️⃣ Viewport in HTML
Ensures proper scaling and responsiveness on all devices.

html
Copy
Edit
<meta name="viewport" content="width=device-width, initial-scale=1.0">
6️⃣ <pre> Tag
Displays text exactly as written, preserving spaces and line breaks.

html
Copy
Edit
<pre>
  Line one
      Indented line
  Line three
</pre>
7️⃣ &nbsp; – Non-breaking Space
Adds space that won’t break into a new line or collapse.

html
Copy
Edit
<p>This&nbsp;&nbsp;is&nbsp;a&nbsp;paragraph&nbsp;with&nbsp;extra&nbsp;spaces.</p>
