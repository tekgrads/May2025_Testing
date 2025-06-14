
# Setting Up the JDK Environment

This guide will walk you through downloading and installing the Java SE Development Kit (JDK) on Windows.

---

## Step 1: Download the JDK

Visit the [Java SE Development Kit Downloads](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html) page and choose the appropriate installer.

![JDK Download Page](jdk_step_1.png)

You can choose from:
- `.zip` for manual extraction
- `.exe` for a typical Windows installation
- `.msi` for Windows Installer-based installation

---

## Step 2: Launch the Installer

Once downloaded, launch the installer. You will be welcomed by the installation wizard.

![Installation Wizard](jdk_step_2.png)

Click **Next** to proceed.

---

## Step 3: Choose Features to Install

Select the components to install. By default, it installs:
- Development Tools
- Source Code
- Public JRE

![Custom Setup](jdk_step_3.png)

Click **Next** and follow the prompts to complete the installation.

---

## Step 4: Verify the Installation

After installation, verify JDK is installed correctly by running:

```bash
java -version
javac -version
```

## Step 5: Set Environment Variables (Optional but Recommended)

Set `JAVA_HOME` and update the `Path` variable:
- JAVA_HOME: `C:\Program Files\Java\jdk-24`
- Path: Add `%JAVA_HOME%\bin`

---

Congratulations! Your JDK environment is now set up.
