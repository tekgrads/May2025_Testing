# Node.js Installation and Application Creation Guide

This guide explains **how to install Node.js** step by step and how to create a simple Node.js application with examples.

---

## 1. What is Node.js?

- Node.js is a **JavaScript runtime environment** built on Chrome's V8 engine.  
- It allows you to run JavaScript code outside of the browser.  
- Used to build **backend applications**, **APIs**, **real-time applications**, etc.

---

## 2. Installing Node.js

### Step 1: Download Node.js
- Visit the official site: [https://nodejs.org](https://nodejs.org)  
- You will find two versions:
  - **LTS (Long Term Support):** Stable version (recommended for most users).  
  - **Current:** Latest features, but not always stable.

Choose **LTS** for production or learning.

---

### Step 2: Install Node.js on Different OS

#### Windows
1. Download the `.msi` installer from [nodejs.org](https://nodejs.org).  
2. Run the installer → Click *Next*.  
3. Accept License → Select installation folder.  
4. Ensure the option **“Add to PATH”** is checked.  
5. Finish installation.

#### macOS
1. Download `.pkg` file from [nodejs.org](https://nodejs.org).  
2. Run installer → follow steps.  
3. Alternatively, install using Homebrew:
   ```bash
   brew install node
   ```

#### Linux (Ubuntu/Debian)
Run commands:
```bash
sudo apt update
sudo apt install nodejs npm -y
```

---

### Step 3: Verify Installation

Check Node.js and npm version:
```bash
node -v
npm -v
```

Example output:
```
v20.0.0
10.5.0
```

---

## 3. Creating a Node.js Application

### Step 1: Setup Project Folder
```bash
mkdir my-node-app
cd my-node-app
```

### Step 2: Initialize Project
```bash
npm init -y
```
This creates a `package.json` file.

---

### Step 3: Create First App (Hello World)

Create a file `app.js`:

```javascript
// app.js
const http = require('http');

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello, World! This is my first Node.js app.');
});

server.listen(3000, () => {
  console.log('Server running at http://localhost:3000/');
});
```

Run the app:
```bash
node app.js
```

Visit → [http://localhost:3000](http://localhost:3000)

Output:
```
Hello, World! This is my first Node.js app.
```

---

## 4. Using Express Framework

Instead of using raw `http`, most applications use **Express.js**.

### Install Express
```bash
npm install express
```

### Example: Express App
```javascript
// index.js
const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('Hello from Express.js!');
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
```

Run:
```bash
node index.js
```

Open → [http://localhost:3000](http://localhost:3000)

---

## 5. Next Steps

- Learn about **routing** in Express.  
- Work with **middleware**.  
- Connect Node.js to **databases** (MySQL, MongoDB).  
- Use **nodemon** to auto-restart server:
  ```bash
  npm install -g nodemon
  nodemon index.js
  ```

---

# 🔑 Summary

- Installed **Node.js + npm** on Windows/Mac/Linux.  
- Verified installation using `node -v` and `npm -v`.  
- Created a **basic server using http module**.  
- Built a simple app using **Express.js**.  
- Ready to build REST APIs and full-stack applications.

