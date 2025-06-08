 Java Notes - Day 2 (05-06-2025)

## 🔄 Git and GitHub Overview

- **Git** is an open-source version control software that stores all versions of your data locally.
- **GitHub** is a cloud-based UI version of Git, used to manage repositories online.

---

## 🛠️ Prerequisites for Git & GitHub Setup

- Install **Git** 
- Create a **GitHub Account**
- Install **GitHub Desktop App**

---

## 🔧 Step-by-Step: GitHub Desktop Setup

### Step 1: Setup GitHub Desktop
- Install GitHub Desktop.
- Log in with your GitHub credentials.
- Clone or create a new repository:
  - `File → New Repository` — to create a repo
  - `File → Clone Repository` — to clone an existing one

### Step 2: Create or Clone Repository

**Option A: Create a New Repository**
- Open GitHub Desktop → `File → New Repository`
- Fill in:
  - Name
  - Local Path
  - Description (optional)
  - Check "Initialize with README" (recommended)
- Click **Create Repository**

**Option B: Clone an Existing Repository**
- `File → Clone Repository`
- Choose from your GitHub account or enter a URL
- Select local path to save

### Step 3: Add Project Files
- Add or create project files (e.g., `.html`, `.css`, `.js`, `.py`, etc.) in your local repo folder
- GitHub Desktop will auto-detect file changes

### Step 4: Commit Changes
- In GitHub Desktop:
  - Check files to commit
  - Write a meaningful commit message
  - Click **Commit to `<branch-name>`**

### Step 5: Work with Branches
- **Create a New Branch**:
  - `Current Branch → New Branch`
  - Name the branch (e.g., `feature-login`)
- **Switch Branches**:
  - `Current Branch → Select another branch`

### Step 6: Push to GitHub
- After committing, click **Push origin** to upload changes
- If it's a new branch, it will be created on GitHub

### Step 7: Pull & Sync Changes
- To fetch latest updates from GitHub:
  - Click **Fetch origin**
  - Then click **Pull**

### Step 8: Merge Branches
- Switch to the branch you want to merge into (e.g., `main`)
- Go to `Branch → Merge into current branch`
- Select the branch to merge
- Click **Push origin** to push changes
