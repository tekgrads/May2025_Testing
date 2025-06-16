

HTML and CSS Concepts
📹 Embedding Media in HTML
<video> Tag
Used to play video files directly in the browser.

<video src="video.mp4" height="255" controls loop muted poster="download.jpg"></video>
<iframe> for Embedding YouTube Videos
<iframe width="435" height="215" src="https://www.youtube.com/embed/5Vw-fBcBXZo?si=9sUzmkIxcRJ_GqZk" title="YouTube video player" frameborder="0" 
allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
<audio> Tag
Used to play audio files.

<audio src="audio1.mp3" controls autoplay loop muted></audio>
<img> Tag
Used to add images.

<img src="img.svg" alt="My Svg Image">
📝 Preformatted Text
<pre> Tag
Displays preformatted text preserving line breaks and spaces.

<pre>
    <p>This is a para</p>

    this is after few new lines           and some more
</pre>
Use &nbsp; for non-breaking spaces.

🏷️ Semantic Tags in HTML
Semantic tags add meaning to the HTML elements.

Common Semantic Tags:
Tag	Description
<header>	Top section of a page (logo, nav)
<nav>	Navigation links
<article>	Self-contained content
<section>	Thematic grouping of content
<aside>	Side content or sidebar
<figure>	Image or media content
<figcaption>	Caption for <figure>
<main>	Main content of a page
<footer>	Bottom section, copyright, etc.
<details>	Expandable section for details
<summary>	Summary/label for <details>
<mark>	Highlighted text
<time>	Date/time values
Sample Semantic HTML:
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Semantic Tags</title>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li>Home</li>
                <li>About</li>
                <li>Contact</li>
            </ul>
        </nav>
    </header>

    <main>
        <h1>What are Semantic Tags</h1>
    </main>

    <footer>
        Copyright CWH | All rights reserved
    </footer>
</body>
</html>
🧾 Display HTML Code in Webpage
Use HTML entities:

<pre><code>
&lt;!DOCTYPE html&gt;
&lt;html lang="en"&gt;
&lt;head&gt;
    &lt;meta charset="UTF-8"&gt;
    &lt;title&gt;Document&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
    
&lt;/body&gt;
&lt;/html&gt;
</code></pre>
🎨 Types of CSS
Inline CSS

<p style="color:red; font-size:20px;">This is styled inline</p>
Internal CSS

<head>
<style>
   .main {
      background-color: red;
   }
</style>
</head>
External CSS

<!-- HTML File -->
<link rel="stylesheet" href="style.css">
/* style.css */
h1 {
    background-color: red;
    color: yellow;
}
🧩 CSS Selectors
1. Element Selector
div {
    background-color: red;
}
2. Class Selector
.p {
    background-color: red;
}
3. ID Selector
#green {
    background-color: green;
}
4. Child Selector
div > p {
    color: blue;
    background-color: brown;
}
5. Universal Selector
* {
    color: blue;
    background-color: brown;
}
6. Pseudo Selectors
Pseudo-Class	Description
:hover	On mouse hover
:focus	When element is focused
:active	When element is clicked
:visited	Visited links
:link	Unvisited links
:first-child	First child of the parent
:nth-child(n)	nth child of the parent
Sample HTML and CSS:
<!DOCTYPE html>
<html>
<head>
    <style>
        .red { background-color: red; }
        #green { background-color: green; }

        div > p {
            color: blue;
            background-color: brown;
        }

        * {
            margin: 0;
            padding: 0;
        }

        a:visited { color: yellow; }
        a:link { color: green; }
        a:active { background-color: red; }
        a:hover { background-color: yellow; }

        p:first-child {
            background-color: aqua;
        }
    </style>
</head>
<body>
    <main class="one">
        <p>I am first</p>
        <p>I am second</p>
    </main>
    <div class="red">
        I am a div
        <article>
            <p>I am a para inside div</p>
        </article>
    </div>

    <div id="green">I am another div</div>
    <a href="https://www.google.com">Go to Google</a>
    <a href="https://www.facebook.com">Go to Facebook</a>
</body>
</html>
