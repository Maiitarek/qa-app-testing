# MENT App — QA Automation Framework

[![Java](https://img.shields.io/badge/Java-21+-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://java.com)
[![SHAFT_ENGINE](https://img.shields.io/badge/SHAFT__ENGINE-8.4-blueviolet?style=flat)](https://github.com/ShaftHQ/SHAFT_ENGINE)
[![Appium](https://img.shields.io/badge/Appium-2.x-662D91?style=flat)](https://appium.io)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-FF6C37?style=flat)](https://testng.org)
[![Allure](https://img.shields.io/badge/Allure-Report-orange?style=flat)](https://allurereport.org)

End-to-end mobile test automation framework for the **MENT app** — a professional networking and contact management platform. Built using **SHAFT_ENGINE** on top of Appium and TestNG, with Allure reporting and data-driven test execution.

Developed as part of a remote QA engagement covering the Contact Profile module across multiple Jira epics.

---

## What it covers

| Epic | Feature | Tests |
|---|---|---|
| MNT-497 | Add new contact | Mandatory fields only, all fields |
| MNT-1159 | Professional contact profile | Business info, team members, career, academics, languages, topics, expertise, profile name |
| MNT-1160 | Personal contact profile | Personal info, contacts, overview |
| MNT-1330 | Delete contact | Delete flow validation |

---

## Tech stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Mobile automation | SHAFT_ENGINE (wraps Appium) |
| Test runner | TestNG |
| Reporting | Allure |
| Test data | JSON files + JavaFaker |
| Build tool | Maven |

---

## Framework architecture

```
qa-app-testing/
├── src/
│   ├── main/java/pages/              # Page Object classes
│   │   ├── CommonMethodsPage.java    # Shared login + reusable actions
│   │   ├── ContactsPage.java         # Contact list + add contact
│   │   ├── HomePage.java             # Home screen assertions
│   │   ├── OverviewPage.java         # Contact overview tab
│   │   ├── ProfessionalPage.java     # Professional profile tab
│   │   ├── PersonalPage.java         # Personal profile tab
│   │   ├── EmailPage.java            # Login — email step
│   │   └── PasswordPage.java         # Login — password step
│   └── test/
│       ├── java/TestPackage/
│       │   ├── MNT497_ContactProfile/
│       │   ├── MNT1159_ProfessionalContactProfile/
│       │   ├── MNT1160_PersonalContactProfile/
│       │   └── MNT497_OverviewContactProfile/
│       └── resources/
│           ├── testDataFiles/
│           │   ├── loginData.json.example         # Copy to loginData.json and fill in
│           │   └── environmentData.json.example   # Copy to environmentData.json and fill in
│           └── apk/                               # Place your .apk here (not committed)
├── testng.xml
└── pom.xml
```

---

## Setup

**1. Clone and install**
```bash
git clone https://github.com/Maiitarek/qa-app-testing.git
cd qa-app-testing
mvn install
```

**2. Configure credentials**
```bash
cp src/test/resources/testDataFiles/loginData.json.example src/test/resources/testDataFiles/loginData.json
# Edit loginData.json and fill in your test account credentials
```

**3. Configure environment URLs**
```bash
cp src/test/resources/testDataFiles/environmentData.json.example src/test/resources/testDataFiles/environmentData.json
# Edit environmentData.json and add your environment URLs
```

**4. Add APK and configure device**

Place the `.apk` in `src/test/resources/apk/` then update `src/main/resources/properties/custom.properties`:
```properties
mobile_app=src/test/resources/apk/your-app.apk
mobile_deviceName=your_device_name
```

---

## How to run

```bash
# Start Appium server
appium

# Start emulator (or connect real device)
emulator -avd your_emulator_name

# Run tests
mvn clean test
```

---

## Allure report

```bash
# Windows
generate_allure_report.bat

# Mac / Linux
./generate_allure_report.sh

# Or via CLI
allure serve allure-results/
```

---

## Author

**Mai Ibrahim** — Senior SDET / QA Engineer
[LinkedIn](https://www.linkedin.com/in/mai-tarek/) · [GitHub](https://github.com/Maiitarek)
