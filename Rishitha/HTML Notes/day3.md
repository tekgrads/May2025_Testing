
# 🧱 CSS Concepts: Box Model, Fonts, Cascade

---

## 📦 1. CSS Box Model

The **Box Model** is the foundation of layout in CSS. Every element is wrapped in a box made of:

* **Content**: Actual content like text, images
* **Padding**: Space around content (inside the border)
* **Border**: Outlines the element
* **Margin**: Space outside the border (between elements)

```
+-------------------------------+
|           Margin             |
|  +------------------------+  |
|  |        Border          |  |
|  |  +------------------+  |  |
|  |  |     Padding      |  |  |
|  |  |  +-----------+   |  |  |
|  |  |  | Content   |   |  |  |
|  |  |  +-----------+   |  |  |
|  |  +------------------+  |  |
|  +------------------------+  |
+-------------------------------+
```

### ➕ Size Calculation

#### `box-sizing: content-box` (default)

* `Total Width = width + padding + border`
* `Total Height = height + padding + border`

#### `box-sizing: border-box`

* `Total Width = width` (includes padding & border)
* `Total Height = height`

### 📋 Quick Example

```css
.box {
  width: 200px;
  padding: 20px;
  border: 2px solid black;
  margin: 30px;
  box-sizing: border-box;
}
```

---

## ✍️ 2. Fonts in CSS

Fonts give your website character and readability.

### 🧰 Font Categories

* **Serif**: Classic (e.g., Times New Roman)
* **Sans-serif**: Clean and modern (e.g., Arial, Poppins)
* **Monospace**: Typewriter style (e.g., Courier)
* **Cursive**: Handwriting feel
* **Fantasy**: Decorative

### 🛠 Font Properties

| Property      | Description                    |
| ------------- | ------------------------------ |
| `font-family` | Defines font stack             |
| `font-size`   | Controls text size             |
| `font-style`  | Italic, normal, oblique        |
| `font-weight` | Thickness (100 - 900, bold)    |
| `line-height` | Vertical spacing between lines |

### 🎨 Google Fonts

```html
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
```

### 💡 Example

```css
body {
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
  font-weight: 400;
  font-style: italic;
}
```

---

## 🌀 3. CSS Cascade & Specificity

The **cascade** decides which styles apply when multiple rules match.

### 🔢 Cascade Steps

1. **Order of Rules** — last one wins
2. **Specificity** — more specific selector wins
3. **Origin** — Inline > author > browser
4. **Importance** — `!important` overrules everything

### 🎯 Specificity Calculation

| Selector Type                  | Value |
| ------------------------------ | ----- |
| Inline style                   | 1000  |
| ID (`#id`)                     | 100   |
| Class, attribute, pseudo-class | 10    |
| Element (`h1`, `p`)            | 1     |

### 🧪 Example

```css
h1 { color: blue; }                /* 1 */
.classname { color: red; }        /* 10 */
#heading { color: green; }        /* 100 */
h1.classname#heading { color: orange; }  /* 111 */
```

The browser uses the rule with the **highest specificity score**.

---
