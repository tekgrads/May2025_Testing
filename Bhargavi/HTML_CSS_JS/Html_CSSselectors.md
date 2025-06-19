# 🌐 HTML Class 2 – Notes (15/06/2025)

## 🧱 Block vs Inline Elements

- **Block Element – `<div>`**
```html
<div>This is a block element</div>
```

- **Inline Element – `<span>`**
```html
<span>This is inline</span>
```

---

## 🎨 CSS Styling

- **Class Selector**
```html
<style>
  .highlight { color: red; }
</style>
<p class="highlight">Red text</p>
```

- **ID Selector**
```html
<style>
  #special { background-color: yellow; }
</style>
<div id="special">Yellow background</div>
```

---

## 🖼 Embedding Media

- **Video**
```html
<video src="video.mp4" height="255" controls loop muted poster="poster.jpg">
  Your browser does not support the video tag.
</video>
```

- **SVG**
```html
<svg height="100" width="100">
  <circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
</svg>
```

- **Image with SVG**
```html
<img src="image1.svg" alt="SVG Image" />
```

- **Iframe – Webpage**
```html
<iframe src="https://www.tekgrads.com" width="600" height="400"></iframe>
```

- **Iframe – YouTube**
```html
<iframe width="500" height="315" src="https://www.youtube.com/embed/VIDEO_ID" allowfullscreen></iframe>
```

---

## 🧠 Semantic vs Non-Semantic

| Semantic Tags             | Non-Semantic Tags     |
|--------------------------|-----------------------|
| `<header>`, `<section>`  | `<div>`, `<span>`     |

---

## 📝 HTML Symbols

- **Special Characters**
```html
&lt;p&gt;&lt;/p&gt; → <p></p>
&copy; → ©
&nbsp; →  
```

- **Preserve Formatting**
```html
<pre>
  This
     is
        spaced
</pre>
```

- **Code Block**
```html
<pre><code>
let x = 10;
console.log(x);
</code></pre>
```

---

## ✍ Dummy Text

- **Lorem Ipsum**
```html
<p>Lorem ipsum dolor sit amet...</p>
```

---

## 🎨 CSS Methods

- **Inline CSS**
```html
<p style="color: red;">Red Text</p>
```

- **Internal CSS**
```html
<head>
  <style>
    p { color: blue; }
  </style>
</head>
```

- **External CSS**
```html
<!-- In HTML -->
<link rel="stylesheet" href="style.css">
```
```css
/* In style.css */
p {
  color: blue;
}
```

---

## 🧩 CSS Selectors

- **Element Selector**
```css
h1 { color: purple; }
```

- **Class Selector**
```css
.funny { color: orange; }
```
```html
<p class="funny">Funny Paragraph 😂</p>
```

- **ID Selector**
```css
#unique { background-color: gold; }
```
```html
<div id="unique">Special Element 🌟</div>
```

- **Child Selector**
```css
div > p { color: brown; }
```
```html
<div>
  <p>Direct child</p>
  <section><p>Not selected</p></section>
</div>
```

- **Descendant Selector**
```css
div p { font-weight: bold; }
```

- **Universal Selector**
```css
* { margin: 0; padding: 0; }
```

- **Pseudo-classes**
```css
a:link { color: blue; }
a:visited { color: purple; }
a:hover { text-decoration: underline; }
a:active { color: red; }
p:first-child { font-weight: bold; }
```
