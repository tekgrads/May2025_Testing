# 🌐 HTML Class 2 Notes (15/06/2025)

---

## 🧱 Block vs Inline Elements

### `<div>`
- A **block-level** element.
- Takes the full width of its container.
- Starts on a **new line**.

```html
<div>This is a block element</div>
```

---

### `<span>`
- An **inline-level** element.
- Takes only as much width as necessary.
- Does **not** start on a new line.

```html
<span>This is an inline element</span>
```

---

## 🎨 CSS Styling

### Class Selector (`.`)
- Targets all elements with a specific class.

```html
<style>
  .highlight {
    color: red;
  }
</style>

<p class="highlight">Styled with class</p>
```

---

### ID Selector (`#`)
- Targets a unique element with an ID.

```html
<style>
  #special {
    background-color: yellow;
  }
</style>

<div id="special">Styled with ID</div>
```

---

## 🖼️ Embedding Images and Videos

### ✅ Video Tag

```html
<body>
  <video src="video.mp4" height="255" controls loop muted poster="download.jpg">
    Your browser does not support the video tag.
  </video>
</body>
```

- `controls` – shows video controls.
- `loop`, `muted`, `poster` – optional attributes.

---

### ✅ SVG (Scalable Vector Graphics)

```html
<svg height="100" width="100">
  <circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
</svg>
```

- Used for drawing vector-based shapes/icons.

---

### ✅ Embedding an SVG image

```html
<img src="image1.svg" alt="My SVG Image" />
```

*Note:* `<img>` should be used, not `<image>`.

---

## 🔳 Iframe – Embedding Other Sites or Content

### ✅ Embed a webpage

```html
<iframe src="https://www.tekgrads.com" width="1920" height="1080"></iframe>
```

---

### ✅ Embed a YouTube Video

To embed:
1. Go to YouTube → Share → Embed → Copy the code

```html
<iframe width="500" height="315" src="https://www.youtube.com/embed/VIDEO_ID"
  title="YouTube video"
  frameborder="0"
  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
  allowfullscreen>
</iframe>
```

---

## 🧠 Semantic vs Non-Semantic HTML

| Semantic HTML          | Non-Semantic HTML        |
|------------------------|--------------------------|
| Tags with **meaning**  | Tags with **no meaning** |
| Examples: `<article>`, `<section>`, `<header>`, `<footer>` | Examples: `<div>`, `<span>` |
| Improves SEO and accessibility | Mostly for layout purposes |

---

## 📝 Special HTML Symbols

- To display `<p></p>` in HTML output:
```html
&lt;p&gt;&lt;/p&gt;
```

- `<pre>`: Preserves **spaces and new lines**.
```html
<pre>
This
   text
      is   formatted.
</pre>
```

- `&copy;` → ©  
- `&nbsp;` → Non-breaking space  

---

## 💻 Displaying Code in HTML

```html
<pre><code>
let x = 10;
console.log(x);
</code></pre>
```

This will preserve formatting and display code cleanly.

---

## ✍️ Lorem Ipsum – Random Placeholder Text

```html
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit...</p>
```

Use `lorem` in many IDEs to auto-generate dummy content.

---

## 🎨 Three Ways to Add CSS in HTML

1. **Inline CSS**  
   Styling added directly to the tag:

   ```html
   <p style="color: red;">This is red</p>
   ```

2. **Internal CSS**  
   Written in `<style>` inside the `<head>`:

   ```html
   <head>
     <style>
       p {
         color: blue;
       }
     </style>
   </head>
   ```

3. **External CSS** ✅ *Recommended*
   Write styles in a `.css` file and link to it:

   ```html
   <head>
     <link rel="stylesheet" href="styles.css" />
   </head>
   ```

---

## 🧩 CSS Selectors Explained with Examples

### 1. **Element Selector**
Targets a specific HTML element:

```css
p {
  color: green;
}
```

---

### 2. **ID Selector**
Targets an element by its ID:

```css
#main-title {
  font-size: 24px;
}
```

---

### 3. **Class Selector**
Targets all elements with a specific class:

```css
.box {
  border: 1px solid black;
}
```

---

### 4. **Child Selector (`>`)**
Targets direct child elements only:

```css
ul > li {
  color: red;
}
```

---

### 5. **Descendant Selector (space)**
Targets all nested elements (not just direct children):

```css
div p {
  font-weight: bold;
}
```

---

### 6. **Universal Selector (`*`)**
Applies styles to all elements:

```css
* {
  margin: 0;
  padding: 0;
}
```

---

### 7. **Pseudo Selectors**

#### a. `a:link`
Styles unvisited links.

```css
a:link {
  color: blue;
}
```

#### b. `a:visited`
Styles visited links.

```css
a:visited {
  color: purple;
}
```

#### c. `a:hover`
Styles link when mouse hovers over.

```css
a:hover {
  text-decoration: underline;
}
```

#### d. `a:active`
Styles link when being clicked.

```css
a:active {
  color: red;
}
```

#### e. `p:first-child`
Styles the first `<p>` tag inside its parent.

```css
p:first-child {
  font-weight: bold;
}
```

---

## ✅ Summary

| Topic | Description |
|-------|-------------|
| `<div>` | Block element – full width |
| `<span>` | Inline element |
| SVG | Scalable graphics format |
| `<iframe>` | Embed other websites or YouTube videos |
| Semantic HTML | Meaningful tags (`<header>`, `<article>`) |
| `<pre>` | Preserves whitespace |
| `&lt;`, `&gt;`, `&copy;` | Special characters |
| CSS Methods | Inline, Internal, External (Best) |
| Selectors | Element, ID, Class, Descendant, Child, Pseudo |

---
