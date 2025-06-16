
# HTML Notes

## CSS Types

### 1. Inline CSS
- CSS is applied directly on the HTML element using the `style` attribute.
```html
<p style="color: red; font-size: 20px;">This is inline CSS</p>
```
- Used for quick, small styling needs.
- Not recommended for large projects due to poor maintainability.

### 2. Internal CSS
- CSS rules are placed inside a `<style>` tag within the `<head>` section of the HTML file.
```html
<!DOCTYPE html>
<html>
<head>
  <style>
    p {
      color: blue;
      font-size: 18px;
    }
  </style>
</head>
<body>
  <p>This is internal CSS</p>
</body>
</html>
```
- Suitable for single-page applications.

### 3. External CSS
- CSS rules are written in a separate `.css` file and linked using the `<link>` tag.
```html
<!-- HTML File -->
<head>
  <link rel="stylesheet" href="styles.css">
</head>
```
```css
/* styles.css */
p {
  color: green;
  font-size: 16px;
}
```
- Recommended for larger projects as it separates structure and style.

## Types of Selectors

### 1. Universal Selector
```css
* {
  margin: 0;
  padding: 0;
}
```
- Targets all HTML elements.

### 2. Element Selector
```css
p {
  color: black;
}
```
- Targets all `<p>` tags.

### 3. ID Selector
```css
#header {
  background-color: gray;
}
```
- Targets an element with a specific `id` attribute.

### 4. Class Selector
```css
.button {
  padding: 10px;
}
```
- Targets all elements with the class `button`.

### 5. Group Selector
```css
h1, h2, h3 {
  font-family: Arial;
}
```
- Applies the same styles to multiple elements.

### 6. Descendant Selector
```css
div p {
  color: orange;
}
```
- Targets `<p>` elements inside `<div>`.

### 7. Child Selector
```css
ul > li {
  list-style: none;
}
```
- Selects direct children only.

### 8. Attribute Selector
```css
input[type="text"] {
  border: 1px solid black;
}
```
- Targets elements based on attribute values.

---
