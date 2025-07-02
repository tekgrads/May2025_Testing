📦 CSS Box Model
The CSS box model is essentially a box that wraps around every HTML element. It consists of: content, padding, borders, and margins.

1. Content
The content of the box, where text and images appear
Controlled by width & height.
2. Padding
Clears an area around the content.
The padding is transparent.
Pushes content inward.
3. Border
A border that goes around the padding and content.
You can style it (solid, dashed, etc.).
4. Margin
Clears an area outside the border.
The margin is transparent.
Pushes the element away from others.
The box model allows us to add a border around elements and define space between elements.
)
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
➕ Size Calculation
box-sizing: content-box (default)
Total Width = width + padding + border
Total Height = height + padding + border
box-sizing: border-box
Total Width = width (includes padding & border)
Total Height = height
📋 Quick Example
.box {
  width: 200px;
  padding: 20px;
  border: 2px solid black;
  margin: 30px;
  box-sizing: border-box;
}
✍ 2. Fonts in CSS
Fonts give your website character and readability.

🧰 Font Categories
Serif: Classic (e.g., Times New Roman)
Sans-serif: Clean and modern (e.g., Arial, Poppins)
Monospace: Typewriter style (e.g., Courier)
Cursive: Handwriting feel
Fantasy: Decorative
🛠 Font Properties
Property	Description
font-family	Defines font stack
font-size	Controls text size
font-style	Italic, normal, oblique
font-weight	Thickness (100 - 900, bold)
line-height	Vertical spacing between lines
🎨 Google Fonts
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
💡 Example
body {
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
  font-weight: 400;
  font-style: italic;
}
🌀 3. CSS Cascade & Specificity
The cascade decides which styles apply when multiple rules match.

🔢 Cascade Steps
Order of Rules — last one wins
Specificity — more specific selector wins
Origin — Inline > author > browser
Importance — !important overrules everything
🎯 Specificity Calculation
Selector Type	Value
Inline style	1000
ID (#id)	100
Class, attribute, pseudo-class	10
Element (h1, p)	1
🧪 Example
h1 { color: blue; }                /* 1 */
.classname { color: red; }        /* 10 */
#heading { color: green; }        /* 100 */
h1.classname#heading { color: orange; }  /* 111 */
