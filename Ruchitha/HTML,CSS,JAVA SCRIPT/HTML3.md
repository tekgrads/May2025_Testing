
# CSS Concepts Overview

---

## 📦 CSS Box Model

The CSS Box Model consists of:

- **Content**
- **Padding**
- **Border**
- **Margin**

### ✅ HTML Example for Box Model

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>CSS Boxmodel</title>
  <style>
    * {
      margin: 0;
      padding: 0;
    }

    .box {
      background-color: aqua;
    }

    .box1 {
      color: yellow;
      padding: 10px;
      margin: 35px;
      border: 2px solid blue;
      height: 200px;
      box-sizing: border-box;
    }

    .box2 {
      color: red;
      padding: 10px;
      margin: 25px;
      border: 2px solid black;
      height: 200px;
      box-sizing: border-box;
    }
  </style>
</head>
<body>
  <div class="box box1">I am a box</div>
  <div class="box box2">I am another box</div>
</body>
</html>
```

### 📐 Box Model Dimensions

- **Total Width** = Width + Left/Right Padding + Left/Right Border + Left/Right Margin  
- **Total Height** = Height + Top/Bottom Padding + Top/Bottom Border + Top/Bottom Margin

---

## 🎨 CSS Colors

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Colors</title>
  <style>
    h1 {
      color: hsl(130, 61%, 44%);
      background-color: rgb(76, 125, 59);
    }
  </style>
</head>
<body>
  <h1>Lets learn about colors</h1>
  <p>
    Color can be represented in:
    <ol>
      <li>Color Keywords</li>
      <li>Hex Color Code</li>
      <li>RGB</li>
      <li>RGBA</li>
      <li>HSL</li>
    </ol>
  </p>
</body>
</html>
```

### 🎨 HSL Explained

- **Hue (H):** 0–360 degrees (0 = Red, 120 = Green, 240 = Blue)
- **Saturation (S):** 0% (gray) to 100% (full color)
- **Lightness (L):** 0% (black), 50% (normal), 100% (white)

---

## 🖋️ CSS Fonts

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Fonts</title>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Baloo+Bhai+2&family=Poppins:wght@300&display=swap');

    h1 {
      font-family: 'Poppins', 'Lucida Sans', sans-serif;
    }

    p {
      font-family: 'Baloo Bhai 2', sans-serif;
      font-size: 20px;
    }

    h2 {
      text-align: center;
      text-transform: uppercase;
      text-decoration: underline;
      text-decoration-color: blue;
      text-decoration-thickness: 7px;
    }

    .lorem {
      border: 2px solid red;
      width: 145px;
      word-break: break-all;
    }
  </style>
</head>
<body>
  <div>
    <h1>Fonts</h1>
    <h2>About Fonts</h2>
    <p>This is a video on fonts</p>
    <p class="lorem">
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos sequi...
    </p>
  </div>
</body>
</html>
```

---

## 🎯 CSS Specificity

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>CSS Specificity</title>
  <style>
    h1 {
      color: aqua; /* Specificity: 1 */
    }

    .cpurple {
      color: purple; /* Specificity: 10 */
    }

    h1.yellow {
      color: yellow; /* Specificity: 1 + 10 = 11 */
    }

    [data-x=a] {
      color: maroon; /* Specificity: 10 */
    }

    .cred {
      color: red; /* Specificity: 10 */
    }

    a.Rajeshclass.rohan-class[href]:hover {
      color: blueviolet; /* Specificity: 1 + 10 + 10 + 10 + 10 = 41 */
    }
  </style>
</head>
<body>
  <div>
    <h1 class="yellow cred cpurple" data-x="a">CSS Specificity</h1>
  </div>
</body>
</html>
```

---

> 💡 **Useful Resources:**
- [Google Fonts](https://fonts.google.com/)
- [CSS Specificity Calculator](https://specificity.keegan.st/)
- [Codepen Colors Example](https://codepen.io/web-dot-dev/pen/ZELGraM)
