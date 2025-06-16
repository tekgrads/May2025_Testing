Here is a markdown-formatted document for **Setting Up the JDK Environment**, suitable for a Git repository:

```markdown
# Setting Up the JDK Environment

## 1. Download and Install JDK

1. Go to the official [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-downloads.html) or use [OpenJDK](https://jdk.java.net/).
2. Choose the appropriate JDK version and OS (Windows/Linux/macOS).
3. Download and run the installer.
4. Follow the on-screen instructions to complete the installation.

---

## 2. Set Environment Variables (For Windows)

### Step 1: Locate the JDK Installation Path
Example path:
```

C:\Program Files\Java\jdk-XX

```

### Step 2: Set `JAVA_HOME`
1. Right-click on **This PC** or **My Computer** → **Properties**.
2. Click on **Advanced system settings** → **Environment Variables**.
3. Under **System Variables**, click **New**:
   - **Variable name**: `JAVA_HOME`
   - **Variable value**: JDK path (e.g., `C:\Program Files\Java\jdk-XX`)

### Step 3: Update `Path`
1. In the **System Variables** list, find and select the `Path` variable, then click **Edit**.
2. Click **New** and add:
```

%JAVA\_HOME%\bin

````
3. Click OK to save all changes.

---

## 3. Verify the Installation

Open Command Prompt and run:
```bash
java -version
javac -version
````

You should see the installed JDK version.

---

## 4. (Optional) For Linux/macOS

### Add to `.bashrc` or `.zshrc`:

```bash
export JAVA_HOME=/usr/lib/jvm/java-XX-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

Then run:

```bash
source ~/.bashrc   # or source ~/.zshrc
```

### Verify:

```bash
java -version
javac -version
```

---

✅ **JDK Environment is now set up successfully.**

```

Let me know if you'd like it customized for a specific OS or JDK version.
```
