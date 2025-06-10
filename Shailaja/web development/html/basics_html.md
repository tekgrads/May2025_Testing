
📘 HTML (HyperText Markup Language) 
1. What is HTML?
HTML stands for HyperText Markup Language.

It is the standard language for creating webpages.

Describes the structure of a webpage using a system of elements and tags.

2. Basic Structure of an HTML Page
html
Copy
Edit
<!DOCTYPE html>
<html>
<head>
  <title>Page Title</title>
</head>
<body>
  <h1>This is a Heading</h1>
  <p>This is a paragraph.</p>
</body>
</html>
3. HTML Tags
Tags are keywords surrounded by angle brackets.

Tags usually come in pairs: <tag> and </tag>.

Examples:

<h1> to <h6> – Headings (h1 is largest)

<p> – Paragraph

<a href="url"> – Anchor (link)

<img src="url" alt="desc"> – Image

<ul>, <ol>, <li> – Lists (unordered/ordered)

4. Common HTML Tags
Tag	Use
<div>	Division or container
<span>	Inline container
<br>	Line break
<hr>	Horizontal line
<strong>	Bold important text
<em>	Emphasized text (italic)
<input>	Input field in form
<form>	Form for user input
<button>	Clickable button

5. Attributes
Provide additional information about elements.

Example: <img src="logo.png" alt="Company Logo">

Common attributes:

href, src, alt, id, class, style, type, value, placeholder

6. Semantic HTML
These tags convey meaning and improve accessibility:

<header>, <footer>, <article>, <section>, <nav>, <aside>, <main>

7. Forms in HTML
html
Copy
Edit
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>
  <input type="submit" value="Submit">
</form>
method: get or post

input types: text, password, radio, checkbox, submit, etc.

🔹 1. <div> Tag
Full Form: Division

Type: Block-level

Purpose: Groups elements to apply CSS styling or JavaScript logic.

Usage Example:

html
Copy
Edit
<div class="container">
  <p>This is inside a div</p>
</div>
🔹 2. class Attribute
Used to apply CSS styles or JavaScript to multiple elements.

Reusable across many elements.

Example:

html
Copy
Edit
<div class="card">Card 1</div>
<div class="card">Card 2</div>
🔹 3. id Attribute
Used to uniquely identify an element.

Only one element should have a given id.

Example:

html
Copy
Edit
<p id="intro">Hello!</p>
🔹 4. Block vs Inline Elements
✅ Block-Level Elements
Start on a new line.

Occupy full width available.

Can contain other block and inline elements.

Examples:

<div>, <p>, <h1> to <h6>, <section>, <article>, <form>, <header>, <footer>

✅ Inline Elements
Do not start on a new line.

Occupy only the necessary width.

Cannot contain block-level elements.

Examples:

<span>, <a>, <strong>, <em>, <img>, <input>, <label>

🔹 5. <span> Tag
Inline container, used to style part of a line.

Useful for targeting small portions of text.

html
Copy
Edit
<p>This is a <span style="color:red;">red</span> word.</p>
🔹 6. Semantic Tags (Block-level with meaning)
Improve readability, SEO, and accessibility.

Examples:

<header>, <nav>, <main>, <article>, <section>, <aside>, <footer>

🔹 7. Non-Semantic Tags
Don't convey any specific meaning.

Examples:

<div>, <span>

🔹 8. <style> & Inline CSS
CSS can be applied directly to elements:

html
Copy
Edit
<div style="color:blue; font-size:20px;">Styled Text</div>
🔹 9. Display Property in CSS
Property	Description
display: block	Element behaves like a block element
display: inline	Behaves like an inline element
display: inline-block	Inline layout but allows width/height
display: none	Hides the element

🔹 10. Grouping & Layout Tags
Tag	Description
<div>	Generic block container
<span>	Generic inline container
<section>	Thematic grouping of content
<article>	Self-contained content
<aside>	Sidebar or additional content
<main>	Primary content area
<header>	Top section of a page or section
<footer>	Bottom section of a page or section