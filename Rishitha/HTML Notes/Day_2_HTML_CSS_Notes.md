
# 🧑‍💻 HTML & CSS - Day 2 Notes

---

## 🎞️ Embedding Video in HTML

### Using `<video>` tag

```html
<video src="video.mp4" height="255" controls loop muted poster="download.jpg"></video>
```

### Using `<iframe>` for YouTube or external videos

```html
<iframe width="435" height="215" src="https://www.youtube.com/embed/5Vw-fBcBXZo?si=9sUzmkIxcRJ_GqZk"
        title="YouTube video player" frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
```

---

## 🔊 Embedding Audio in HTML

```html
<audio src="audio1.mp3" controls autoplay loop muted></audio>
```

---

## 🖼️ Adding Images

```html
<img src="img.svg" alt="My Svg Image">
```

---

## 📝 `<pre>` Tag

```html
<pre>
    <p>This is a para</p>

    this is after few new lines           and some more
</pre>
```

---

## ␣ Adding Space in HTML

```html
&nbsp;
```

---

## 🔤 Semantic HTML Tags

### Examples:

- `<header>`
- `<nav>`
- `<article>`
- `<section>`
- `<aside>`
- `<figure>` + `<figcaption>`
- `<main>`
- `<footer>`
- `<details>` & `<summary>`
- `<mark>`

### Example Code:

```html
<!DOCTYPE html>
<html>
<head><title>Semantic Tags</title></head>
<body>
  <header><nav><ul><li>Home</li><li>About</li><li>Contact</li></ul></nav></header>
  <main><h1>What are Semantic Tags?</h1></main>
  <footer>Copyright CWH | All rights reserved</footer>
</body>
</html>
```

---

## 🎨 Types of CSS

### 1. Inline CSS

```html
<p style="color:red; font-size:20px;">Styled text</p>
```

### 2. Internal CSS

```html
<head>
  <style>.main { background-color: red; }</style>
</head>
```

### 3. External CSS

```css
/* style.css */
p { background-color: aquamarine; }
a { background-color: rgb(242, 160, 122); }
```

Link it in HTML:

```html
<link rel="stylesheet" href="style.css">
```

---

## 🏷️ CSS Selectors

### Element Selector

```css
div { background-color: red; }
```

### Class Selector

```css
.red { background-color: red; }
```

### ID Selector

```css
#green { background-color: green; }
```

### Child Selector

```css
div > p { color: blue; background-color: brown; }
```

### Universal Selector

```css
* { color: blue; background-color: brown; }
```

### Pseudo Selectors

```css
a:visited { color: yellow; }
a:link { color: green; }
a:active { background-color: red; }
a:hover { background-color: yellow; }
p:first-child { background-color: aqua; }
```

---

## 🧾 Displaying HTML Code in a Webpage

```html
&lt;p&gt;This is a paragraph&lt;/p&gt;
```

Code block:

```html
<pre><code>
&lt;!DOCTYPE html&gt;
&lt;html&gt;
&lt;head&gt;&lt;/head&gt;
&lt;body&gt;&lt;/body&gt;
&lt;/html&gt;
</code></pre>
```

---

## ✅ Summary

| Topic                  | Description                               |
|------------------------|-------------------------------------------|
| `<video>`, `<audio>`  | Embeds multimedia                         |
| Semantic Tags          | Adds meaning and structure to HTML       |
| CSS Types              | Inline, Internal, External               |
| CSS Selectors          | Element, Class, ID, Child, Pseudo        |
