# 🎨 CSS (Cascading Style Sheets) Notes

CSS is used to **style** and **layout** HTML elements.

---

## 📌 1. Ways to Apply CSS

| Method       | Syntax Example                                | Description                      |
|--------------|------------------------------------------------|----------------------------------|
| Inline       | `<p style="color:red;">Text</p>`              | Inside HTML tag                  |
| Internal     | `<style>p {color:red;}</style>`               | Inside `<head>` of HTML file     |
| External     | `<link rel="stylesheet" href="style.css">`    | In a separate `.css` file        |

---

## 🏷️ 2. CSS Syntax

```css
selector {
  property: value;
}
p {
  color: blue;
  font-size: 16px;
}

3. Types of Selectors
Selector	Example	Description
Universal	*	Targets all elements
Element	p	Targets all <p> tags
Class	.box	Targets elements with class="box"
ID	#header	Targets element with id="header"
Group	h1, h2	Targets both h1 and h2
Child	div > p	Targets <p> directly inside <div>
Descendant	div p	Targets <p> inside <div> at any level

🎨 4. Text and Font Properties
css
Copy
Edit
color: red;
font-size: 18px;
font-family: Arial, sans-serif;
font-weight: bold;
text-align: center;
text-decoration: underline;
line-height: 1.5;
letter-spacing: 1px;
📦 5. Box Model
Each element is a box made of:

mathematica
Copy
Edit
| Margin  |
| Border  |
| Padding |
| Content |
Example:

css
Copy
Edit
div {
  margin: 10px;
  padding: 15px;
  border: 2px solid black;
}
🔲 6. Display and Position
📌 Display
Value	Description
block	Element takes full width
inline	No line break, flows with content
inline-block	Inline + allows setting width/height
none	Hides the element
flex	Enables Flexbox layout

📌 Position
Value	Behavior
static	Default
relative	Offset relative to normal position
absolute	Positioned relative to the nearest ancestor
fixed	Fixed position in the viewport
sticky	Sticks to position within a scroll container

🌈 7. Colors
css
Copy
Edit
color: red;             /* Color name */
color: #ff0000;         /* Hex code */
color: rgb(255,0,0);    /* RGB */
color: rgba(255,0,0,0.5); /* RGBA with transparency */
📐 8. Units
Unit	Example	Description
px	font-size: 16px;	Fixed pixels
%	width: 50%;	Percentage of parent element
em	Relative to parent font-size	
rem	Relative to root (html) font-size	

🔁 9. Flexbox Layout
css
Copy
Edit
.container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
Property	Values
flex-direction	row, column
justify-content	center, space-between, space-around
align-items	center, flex-start, flex-end, stretch

🎯 10. Important Concepts
z-index: Controls overlapping of elements

overflow: Handles content overflow (hidden, scroll, auto)

visibility: visible or hidden

opacity: 0 (invisible) to 1 (fully visible)

cursor: pointer, default, etc.

📱 11. Media Queries (Responsive Design)
css
Copy
Edit
@media (max-width: 600px) {
  body {
    background-color: lightblue;
  }
}
✨ 12. Animations and Transitions
✅ Transitions
css
Copy
Edit
div {
  transition: all 0.3s ease-in-out;
}
✅ Animations
css
Copy
Edit
@keyframes slide {
  from { left: 0; }
  to { left: 100px; }
}

div {
  position: relative;
  animation: slide 2s infinite;
}
📁 13. Common Classes
Class	Usage
.container	Layout wrapper
.btn	Styled button
.card	Box/card-style layout
.hidden	Hides element

🧠 14. Best Practices
Use external CSS for maintainability

Follow naming conventions (e.g., BEM)

Use comments to organize large stylesheets

Keep CSS DRY (Don’t Repeat Yourself)

Use variables for colors and fonts (in modern CSS)




<!-- CSS Box Model and Fonts Example -->

<!-- Box Model HTML + CSS -->
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

<!-- Font Styling Example -->
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

<!-- CSS Specificity Example -->
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



