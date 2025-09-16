
## Node and React

1. **Node.js installation**  
2. **VS Code installation**  
   - Go to CMD and check:  
     ```bash
     node -v
     npm -v
     ```

- JavaScript can be executed on the browser.  
- Node.js can be run without the help of the browser.  
- We use Node.js to execute our React applications as well.  
- A React application is a combination of **JavaScript** and **HTML**.  

**Frontend → JS + HTML**  

**npm → Node Package Manager**  
- Used to pull dependencies as libraries.

---

### Creating First React Project

In VS Code Terminal:

```bash
npx create-react-app app1

Then:
cd app1
npm start
•	The app will get created in the browser.
•	To stop the React project: Ctrl + C

Package.json File
	•	Contains dependencies (similar to pom.xml file).
	•	Version example: ^19.1.1 (3 sections)
	•	19 → major version
	•	1 → minor version
	•	1 → patch version

Notes:
	•	If there are bugs in software, they will be interpreted here.
	•	^ → major version should not change.
	•	~ → restricts updates to patch version.

Tracking Dependencies
	•	We can track in package-lock.json:
	•	What got downloaded
	•	From where it got downloaded
	•	They are part of node_modules.
	•	If you delete node_modules, you can regenerate it with:
npm install
Accessing Files
•	You can access your public files with:
localhost:3000/favicon.ico
•	You can access them directly.
Important Files
•	Every project has a file called index.html.
<div id="root"></div>
•	This div placeholder will be used for injecting the rest of the content into index.html.
DOM (Document Object Model)
•	The entire HTML content will be converted into an object called DOM.
•	Logic can be written once and reused again and again.
Component = HTML + JavaScript
Function Creation
let subtract = (a, b) => {
  return a - b;
}
Difference Between var and let
•	var: Though declared inside a block, can be used outside the block (not block-scoped).
•	let: Can only be used within the block (block-scoped).







