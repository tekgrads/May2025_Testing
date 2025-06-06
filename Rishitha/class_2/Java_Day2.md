
# 🔧 Git & GitHub Desktop Setup and Upload Process (With Branches)

## 🧹 Step 1: Install Git
1. Go to the official Git website: https://git-scm.com/
2. Click on Download for Windows (or your OS)
3. Install using default settings by clicking Next multiple times
4. After installation, open Command Prompt and type:
   ```bash
   git --version
   ```
   ✅ If you see a version number, Git is installed successfully

## 💻 Step 2: Install GitHub Desktop
1. Go to: https://desktop.github.com/
2. Download and install GitHub Desktop
3. Open GitHub Desktop
4. Sign in with the same GitHub account your sir used to share the repo (if access given)

## 🔗 Step 3: Clone Repository
1. In GitHub Desktop, go to File → Clone Repository
2. Choose URL or GitHub.com tab (if repo is listed)
3. Select the repository (e.g., java-notes-repo) which is shared
4. Select the location on your desktop where you want to save the repo locally
5. Click Clone

📁 Now you’ll have a local copy (folder) of the repo on your system.

## 🌳 Step 4: Branch Structure
- **main** → Final/clean code
- **development** → Team development version
- **feature--yourname** → Your personal working branch (e.g., feature--rishitha)

### Create Your Feature Branch:
1. In GitHub Desktop, click on **Current Branch**
2. Click **New Branch** → Name it `feature--rishitha`
3. Base branch should be `development`
4. Click **Create Branch**

✅ Now you're working in your own feature branch.

## 📁 Step 5: Add Notes File
1. Go to your local folder (where repo is cloned)
2. Inside the structure: `may2025_testing/Rishitha/class2/Day2/`
3. Paste your `.md` file (e.g., `Java_Day2.md`)

## 💬 Step 6: Commit Changes
1. Go to GitHub Desktop → You will see the added file listed under **Changes**
2. Write a commit message like:
   ```
   Added Day 2 Notes
   ```
3. Click **Commit to feature--rishitha**

## 🚀 Step 7: Push Changes
1. After committing, click **Push origin** (top-right corner)
2. This will upload your feature branch updates to GitHub online

## 🔀 Step 8: Create Pull Request (Optional)
1. Go to https://github.com/
2. Open your repository
3. You’ll see an option: `Compare & pull request`
4. Base branch → `development`, Compare → `feature--rishitha`
5. Add title (e.g., `Day 2 notes upload`)
6. Click **Create pull request**

## ✅ Summary of Workflow:
```
1. Install Git & GitHub Desktop
2. Clone sir's repository
3. Create your branch → feature--rishitha
4. Add notes file to correct folder
5. Commit your changes
6. Push to GitHub
7. (Optional) Create pull request
```
