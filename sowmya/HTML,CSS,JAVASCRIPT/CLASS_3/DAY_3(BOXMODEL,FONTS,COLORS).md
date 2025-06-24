# 📦 CSS Box Model

The CSS box model is essentially a box that wraps around every HTML element. It consists of: content, padding, borders, and margins.

## 1. Content

* The content of the box, where text and images appear
* Controlled by width & height.

## 2. Padding

* Clears an area around the content.
* The padding is transparent.
* Pushes content inward.

## 3. Border

* A border that goes around the padding and content.
* You can style it (solid, dashed, etc.).

## 4. Margin

* Clears an area outside the border.
* The margin is transparent.
* Pushes the element away from others.

The box model allows us to add a border around elements and define space between elements.

```
+-----------------------------+
|         Margin              |
|  +-----------------------+  |
|  |      Border           |  |
|  |  +-----------------+  |  |
|  |  |    Padding      |  |  |
|  |  |  +------------+ |  |  |
|  |  |   Content       |  |  | 
|  |  |  +------------+ |  |  |
|  |  +-----------------+  |  |
|  +-----------------------+  |
+-----------------------------+
```

### Total Size Calculation:

#### box-sizing: content-box (default):

* Total Width = width + padding-left + padding-right + border-left + border-right
* Total Height = height + padding-top + padding-bottom + border-top + border-bottom

#### box-sizing: border-box:

* Total Width = width (includes padding & border)
* Total Height = height (includes padding & border)

## 📄 HTML Example for Box Model

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CSS Boxmodel</title>
  <style>
    * {
      margin: 0;
      padding: 0;
    }
    .box {
      background-color: rgb(37, 168, 55);
    }
    .box1 {
      color: rgb(194, 69, 138);
      padding: 35px;
      margin: 40px;
      border: 2px solid red;
      height: 100px;
      box-sizing: border-box;
    }
    .box2 {
      color: yellow;
      padding: 10px;
      margin: 50px;
      border: 2px solid black;
      height: 200px;
      box-sizing: border-box;
    }
  </style>
</head>
<body>
  <div class="box box1">box1</div>
  <div class="box box2">box2</div>
</body>
</html>
```

---

# ✍️ Fonts

Using a font that is easy to read is important. The font adds value to your text. Choose the correct color and size.

## Generic Font Families

* **Serif**: Formal and elegant
* **Sans-serif**: Modern and minimal
* **Monospace**: Fixed width, mechanical look
* **Cursive**: Handwritten style
* **Fantasy**: Decorative/playful

## Font Properties

* `font-family`: Font name fallback system
* `font-style`: `normal`, `italic`, `oblique`
* `font-weight`: Font thickness
* `font-variant`: Small-caps
* `font-size`: Absolute or relative

### Absolute Size

* Fixed size, not user-adjustable
* Useful when output size is known

### Relative Size

* Adjusts with surroundings
* User-friendly and accessible

### Google Fonts

```html
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide|Sofia|Trirong">
```

## 📄 HTML Example with Fonts

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Fonts</title>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Baloo+Bhai+2&family=Poppins:wght@300&display=swap');
    h1 {
      font-family: 'Poppins', sans-serif;
    }
    p {
      font-family: 'Baloo Bhai 2', sans-serif;
      font-size: 20px;
      line-height: 4;
      letter-spacing: 1px;
      font-style: italic;
      font-weight: 500;
    }
    h2 {
      text-align: center;
      text-transform: uppercase;
      text-decoration: underline;
      text-decoration-color: rgb(209, 200, 70);
      text-decoration-thickness: 7px;
    }
    .lorem {
      border: 2px solid rgb(66, 22, 138);
      width: 145px;
      word-break: break-all;
    }
  </style>
</head>
<body>
  <div>
    <h1>Fonts</h1>
    <h2>about Fonts</h2>
    <p>This is a video on fonts</p>
    <p class="lorem">Lorem ipsum dolor sit amet consectetur adipisicing elit...</p>
  </div>
</body>
</html>
```

---

# 🎯 CSS Cascade Algorithm

CSS = Cascading Style Sheets.
The **cascade** resolves conflicts where multiple rules apply.

### Cascade Stages

1. **Position and Order**: Last declared wins.
2. **Specificity**: Stronger selectors override others.
3. **Origin**: Inline > author > browser.
4. **Importance**: `!important` wins all.

### Specificity Weights

* Inline Style: 1000
* ID Selector: 100
* Class/Attribute: 10
* Element Selector: 1
* Universal Selector: 0
* `!important`: +10000

## 📄 HTML Example with Specificity

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CSS Specificity</title>
  <style>
    h1 { color: aqua; }              /* specificity = 1 */
    .cpurple { color: purple; }      /* specificity = 10 */
    h1.yellow { color: yellow; }     /* specificity = 11 */
    [data-x=a] { color: maroon; }    /* specificity = 10 */
    .cred { color: red; }            /* specificity = 10 */
  </style>
</head>
<body>
  <h1 class="yellow cred cpurple" data-x="a">CSS Specificity</h1>
</body>
</html>
```
