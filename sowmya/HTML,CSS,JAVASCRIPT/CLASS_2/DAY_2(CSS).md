# HTML and CSS Notes

## 📹 Embedding Video in HTML

### Using `<video>` tag

The `<video>` tag is used to embed video content and includes control options:

```html
<video src="video.mp4" height="255" controls loop muted poster="download.jpg"></video>
```

### Using `<iframe>` for YouTube or other external videos

```html
<iframe width="435" height="215" src="https://www.youtube.com/embed/5Vw-fBcBXZo?si=9sUzmkIxcRJ_GqZk"
        title="YouTube video player" frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen>
</iframe>
```

---

## 🔊 Embedding Audio in HTML

The `<audio>` tag is used to embed and control audio:

```html
<audio src="audio1.mp3" controls autoplay loop muted></audio>
```

---

## 🖼️ Adding Images

Use the `<img>` tag to display images:

```html
<img src="img.svg" alt="My Svg Image">
```

---

## 📝 The `<pre>` Tag in HTML

The `<pre>` tag defines preformatted text, displaying it in a fixed-width font and preserving white space and line breaks.

```html
<pre>
    <p>This is a para</p>

    this is after few new lines           and some more
</pre>
```

---

## ␣ Adding Space in HTML

To add a space in HTML use:

```html
&nbsp;
```





---

## 📘 Semantic HTML Tags

Semantic HTML tags add meaning to your webpage structure:

### Common Semantic Tags

* `<header>`: Represents the top section of a web page (logos, navigation).
* `<nav>`: Contains navigation links.
* `<article>`: A self-contained piece of content.
* `<section>`: Thematic grouping of content.
* `<aside>`: Sidebar content.
* `<figure>` and `<figcaption>`: Embeds with captions (images, charts).
* `<main>`: Main content of the page.
* `<footer>`: Footer section.
* `<details>` & `<summary>`: Expandable content.
* `<mark>`: Highlights text.

### Semantic HTML Example

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Semantic Tags</title>
</head>
<body>
  <header>
    <nav>
      <ul>
        <li>Home</li>
        <li>About</li>
        <li>Contact</li>
      </ul>
    </nav>
  </header>

  <main>
    <h1>What are Semantic Tags?</h1>
  </main>

  <footer>
    Copyright CWH | All rights reserved
  </footer>
</body>
</html>
```

---

## 🎨 Types of CSS

There are 3 main types:

### 1. Inline CSS

```html
<p style="color:red; font-size:20px;">Styled text</p>
```

### 2. Internal CSS

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

**style.css**:

```css
p {
  background-color: aquamarine;
}

a {
  background-color: rgb(242, 160, 122);
}
```

Linked in HTML:

```html
<link rel="stylesheet" href="style.css">
```

---

## 🏷️ CSS Selectors

### 1. Element Selector

```css
div {
  background-color: red;
}
```

### 2. Class Selector

```css
.red {
  background-color: red;
}
```

### 3. ID Selector

```css
#green {
  background-color: green;
}
```

### 4. Child Selector

```css
div > p {
  color: blue;
  background-color: brown;
}
```

### 5. Universal Selector

```css
* {
  color: blue;
  background-color: brown;
}
```

### 6. Pseudo Selectors

```css
a:visited {
  color: yellow;
}

a:link {
  color: green;
}

a:active {
  background-color: red;
}

a:hover {
  background-color: yellow;
}

p:first-child {
  background-color: aqua;
}
```

---

## 🧾 HTML for Displaying Code Tags

To display HTML tags like `<p>` on a webpage:

```html
&lt;p&gt;This is a paragraph&lt;/p&gt;
```

For blocks:

```html
<pre><code>
&lt;!DOCTYPE html&gt;
&lt;html lang="en"&gt;
&lt;head&gt;
  &lt;meta charset="UTF-8"&gt;
  &lt;meta name="viewport" content="width=device-width, initial-scale=1.0"&gt;
  &lt;title&gt;Document&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;

&lt;/body&gt;
&lt;/html&gt;
</code></pre>
```

---


