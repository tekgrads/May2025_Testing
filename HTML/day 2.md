
# HTML Concepts Explained

## 1. `<video>` Tag
The `<video>` tag is used to embed video content in a webpage. It supports attributes like `controls`, `autoplay`, `loop`, `muted`, and `poster`.

**Example:**
```html
<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
```

## 2. SVG (Scalable Vector Graphics)
SVG is an XML-based format for vector graphics. It is used to define graphics such as lines, shapes, and text.

**Example:**
```html
<svg width="100" height="100">
  <circle cx="50" cy="50" r="40" stroke="green" stroke-width="4" fill="yellow" />
</svg>
```

## 3. Viewport
The viewport is the user's visible area of a web page. It varies with the device and is set using the meta tag in HTML.

**Example:**
```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

## 4. `<iframe>` Tag
The `<iframe>` tag is used to embed another HTML page within the current page.

**Example:**
```html
<iframe src="https://example.com" width="300" height="200"></iframe>
```

## 5. `<pre>` Tag
The `<pre>` tag defines preformatted text. Text inside this tag is displayed in a fixed-width font and preserves spaces and line breaks.

**Example:**
```html
<pre>
function sayHello() {
  console.log("Hello, World!");
}
</pre>
```

## 6. ID Selector in CSS
The ID selector is used to style a specific element with a unique ID using `#`.

**Example:**
```html
<p id="main">This is a paragraph.</p>

<style>
  #main {
    color: blue;
  }
</style>
```

## 7. Child Selector in CSS
The child selector (`>`) selects only the direct children of a specified element.

**Example:**
```html
<div>
  <p>This is selected</p>
  <section><p>This is not selected</p></section>
</div>

<style>
  div > p {
    color: green;
  }
</style>
```

## 8. Semantic Tags in HTML
Semantic tags clearly describe their meaning in a human- and machine-readable way. Examples: `<header>`, `<footer>`, `<article>`, `<section>`, `<nav>`.

**Example:**
```html
<article>
  <h2>Article Title</h2>
  <p>This is the article content.</p>
</article>
```

These tags help with SEO, accessibility, and maintainability of the HTML code.
