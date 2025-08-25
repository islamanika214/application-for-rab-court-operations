# A Java Desktop Application for Managing the Operations of the Rapid Action Battalion (RAB) in Bangladesh

## Overview

The **RAB Mobile Court System** is a desktop-based Java application designed to simulate the real-life mobile court process operated by the Rapid Action Battalion (RAB) in Bangladesh. It enables multiple stakeholders — magistrates, RAB officers, lawyers, clerks, and defendants — to perform their roles digitally. The system ensures **faster, transparent, and more organized legal proceedings** while providing a modular and object-oriented design.

This project was developed as part of the **CSE213 course at Independent University, Bangladesh**, focusing on applying **object-oriented programming (OOP) principles** and **JavaFX-based GUI development**.


## Features

### User Roles
- **Magistrate**: Issue warrants, announce verdicts, manage schedules.
- **RAB Officer**: File cases, request search warrants, manage operations.
- **Lawyer**: View assigned cases, comment on proceedings, manage client information.
- **Clerk**: File reports, contact officials, handle case documentation.
- **Defendant**: View case details, hire/change lawyers, apply for bail or appeal.

### Case & Court Management
- Create and manage case files.
- Assign lawyers and officers.
- Track evidence, incident reports, and witness statements.
- Generate verdicts, case reports, and charts.

### Warrant & Operations Handling
- Issue, track, and manage search or service warrants.
- Manage subordinate officers and emergency support.

### Survey & Investigation
- Schedule and conduct surveys of institutions.
- Submit initial and follow-up reports.
- Generate charts and summaries.

### UI/UX
- Built using **JavaFX** with multiple FXML-based scenes for modularity.
- Distinct dashboards for each role (e.g., `MagistrateDashScene`, `RabOfficerDashScene`, `LawyerDashBoard`).
- Integrated assets (logos, role-specific icons).


## Project Structure

The repository is organized as follows:

- **`src/mainPkg/`**: Core package with main application, controllers, and role-specific scenes.
- **`src/rabproject/`**: Additional modules for operations like bail, lawyer hiring, punishment reduction, and appeals.
- **`src/Assets/`**: Icons, logos, and other graphical assets.
- **`build/`**: Compiled class files and artifacts.
- **`.bin` & `.txt` files**: Serialized objects and case data for simulation (cases, budgets, warrants, etc.).


## Technologies Used

- **Language**: Java (OOP principles applied throughout).
- **GUI**: JavaFX with FXML for scene design.
- **Data Handling**: Binary serialization (`.bin` files) and text storage for persistence.
- **Build Tool**: Apache Ant (`build.xml` included).


## Getting Started

### Prerequisites
- Java Development Kit (**JDK 8 or later**).
- NetBeans IDE (recommended, as project files like `nbproject` are included).
- JavaFX SDK.

### Running the Project
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/rab-mobile-court-system.git
   ```
2. Open the project in **NetBeans** (or another IDE that supports Ant builds).
3. Ensure JavaFX libraries are configured.
4. Run the `MainApplication.java` file to launch the system.


## Future Improvements

- Integration with a real database (e.g., MySQL/PostgreSQL) instead of serialized `.bin` files.
- More secure authentication and role-based access control.
- Enhanced UI/UX with modern JavaFX styling.
- Reporting dashboards with real-time analytics.


## License

This project was created for academic purposes. You may adapt or extend it for learning and research. For any other usage, please contact the author.
