
#  HTML CSS Styling & Selectors

## 🎯 Inline CSS

It’s like dressing up inside the house — local to one element.

```html
<p style="color: red; font-weight: bold;">I am angry text! 😠</p>
```

## 🏠 Internal CSS

Styling written inside a `<style>` tag in the HTML file's `<head>` — like family dress code.

```html
<html>
<head>
<style>
p {
  color: green;
  font-style: italic;
}
</style>
</head>
<body>
<p>I’m a stylish paragraph 🍀</p>
</body>
</html>
```

## 🌐 External CSS

Linking to a `.css` file — fashion consultant from outside! 💼

**style.css**
```css
p {
  color: blue;
  text-decoration: underline;
}
```

**HTML file**
```html
<link rel="stylesheet" href="style.css">
<p>I follow the external fashion guide 👔</p>
```

## 🎯 CSS Selectors

### 🧱 Element Selector

Selects by HTML tag.

```css
h1 {
  color: purple;
}
```

### 🪧 Class Selector (you wrote "solid", assuming you meant "class")

Selects all elements with a given class. Like group outfits! 👯‍♀️

```css
.funny {
  font-family: Comic Sans MS;
  color: orange;
}
```

```html
<p class="funny">This paragraph is hilarious 😂</p>
```

### 🆔 ID Selector

Selects one special element. Like a VIP pass 🎫

```css
#unique {
  background-color: gold;
}
```

```html
<div id="unique">I'm the chosen one! 🌟</div>
```

### 👶 Child Selector

Selects only *direct children*.

```css
div > p {
  color: brown;
}
```

```html
<div>
  <p>I’m the child 👶</p>
  <section><p>I'm a grandchild 👵</p></section>
</div>
```

Only the first `<p>` is styled brown.

### 🎭 Pseudo-selectors

#### :hover

When you *touch* it with your mouse! 🐭

```css
button:hover {
  background-color: lime;
}
```

```html
<button>Hover over me! 🖱️</button>
```

#### ::first-child (Pseudo Child Selector)

Targets the first child only. Like the eldest sibling! 👦

```css
ul li:first-child {
  font-weight: bold;
}
```

```html
<ul>
  <li>First item (bold)</li>
  <li>Second item</li>
</ul>
```


