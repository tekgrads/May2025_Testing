
# HTML and CSS Concepts with Examples

## 1. CSS Types

### Inline CSS
- Applied directly to an HTML element using the `style` attribute.
```html
<p style="color: red; font-size: 20px;">This is red text using inline CSS.</p>
```

### Internal CSS
- Defined within a `<style>` tag inside the `<head>` section.
```html
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
```

### External CSS
- Written in a separate `.css` file and linked using the `<link>` tag.
```html
<!-- index.html -->
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <h2>External CSS Example</h2>
</body>
</html>
```
```css
/* styles.css */
h2 {
  color: green;
  font-family: Arial, sans-serif;
}
```

## 2. CSS Selectors

### Types of Selectors:

- **Universal Selector**: Applies to all elements
  ```css
  * {
    margin: 0;
    padding: 0;
  }
  ```

- **Element Selector**: Targets by element name
  ```css
  p {
    color: gray;
  }
  ```

- **Class Selector**: Targets by class
  ```css
  .highlight {
    background-color: yellow;
  }
  ```

- **ID Selector**: Targets by unique ID
  ```css
  #main {
    font-size: 24px;
  }
  ```

- **Group Selector**: Combines multiple selectors
  ```css
  h1, h2, p {
    margin-bottom: 10px;
  }
  ```

- **Descendant Selector**: Targets elements inside others
  ```css
  div p {
    color: blue;
  }
  ```

- **Child Selector**: Targets direct children only
  ```css
  div > p {
    color: green;
  }
  ```

## 3. HTML Video Tag

```html
<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
```

## 4. SVG (Scalable Vector Graphics)

```html
<svg width="100" height="100">
  <circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
</svg>
```

## 5. Viewport in HTML

- Used for responsive design
```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

## 6. `<pre>` Tag

- Preserves formatting including spaces and line breaks.
```html
<pre>
  Line one
      Indented line
  Line three
</pre>
```

## 7. `&nbsp;` (Non-breaking Space)

- Used to insert space that won’t collapse or break into a new line.
```html
<p>This&nbsp;&nbsp;is&nbsp;a&nbsp;paragraph&nbsp;with&nbsp;extra&nbsp;spaces.</p>
```
