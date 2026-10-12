
# Study Tracker 📚

A Java-based Study Tracker application with a Graphical User Interface (GUI) developed using Java Swing. This application helps students record their daily study activities, track study duration, organize subjects, and generate study summaries.

The application also supports importing and exporting study records using CSV files, making it easy to maintain and share study data.

## 🚀 Features

- **Add Study Logs:** Record study details, including date, subject, duration, and description.
- **Manual Date Selection:** Enter a study date in `YYYY-MM-DD` format.
- **Subject Selection:** Select predefined subjects or enter a custom subject.
- **Study Log Table:** Display all study records in a tabular format.
- **Export to CSV:** Save study records into a CSV file.
- **Import from CSV:** Load existing study records from a CSV file.
- **Summary by Date:** Calculate the total study duration for each date.
- **Summary by Subject:** Calculate the total study duration for each subject.
- **Total Study Hours:** View the total time spent studying.
- **Clear Fields:** Reset the input fields for a new record.
- **Refresh Table:** Update the displayed study records.
- **Input Validation:** Validate dates, subjects, and study duration.
- **CSV Handling:** Support quoted CSV fields and commas inside descriptions.
- **User-Friendly Interface:** Interactive desktop GUI built with Java Swing.

## 🛠️ Technologies Used

- Java
- Java Swing
- Java AWT
- Java Collections Framework
- Java I/O
- Java NIO (`Files`, `Path`)
- Java Time API (`LocalDate`)
- CSV File Handling

## 📂 Project Structure

```text
Marvellous-Study-Tracker/
│
├── program868.java
├── README.md
└── StudyLogs.csv        (created when you export study records)
```

## ⚙️ Prerequisites

Before running the project, ensure that you have:

- Java Development Kit (JDK) 8 or later
- A text editor or IDE such as Visual Studio Code, IntelliJ IDEA, or Eclipse
- Windows, Linux, or macOS

**Note:** The project uses only standard Java libraries. No external JAR files or third-party dependencies are required.

## ▶️ How to Run the Project

### Step 1: Open the Project Folder

Open the folder containing `program868.java` in Visual Studio Code or a terminal.

### Step 2: Check Java Installation

Open the terminal and execute:

```bash
java -version
javac -version
```

If both commands display version information, Java is installed and available.

### Step 3: Compile the Program

Run the following command:

```bash
javac program868.java
```

If compilation succeeds, Java generates the required `.class` files.

### Step 4: Run the Application

Execute:

```bash
java program868
```

The **Marvellous Study Tracker** GUI window will open.

## 🖥️ How to Use the Application

### 1. Add a Study Log

Enter the following information:

| Field | Description | Example |
|---|---|---|
| Date | Study date in YYYY-MM-DD format | `2026-10-12` |
| Subject | Select or enter a subject | `Java` |
| Duration | Study time in hours | `2.5` |
| Description | Details about the study session | `Practiced Java collections` |

Click **Add Log** to save the record in the application's in-memory database.

### 2. View Study Logs

All added records appear in the table with the following columns:

- Date
- Subject
- Duration (hours)
- Description

Click **Refresh Table** to refresh the displayed records.

### 3. Clear Input Fields

Click **Clear Fields** to reset the input fields and prepare for a new study entry.

### 4. Export Study Logs

1. Add at least one study record.
2. Click **Export CSV**.
3. Choose the destination folder and file name.
4. Save the file.

The application exports the study records in CSV format.

### 5. Import Study Logs

1. Click **Import CSV**.
2. Select a previously exported or correctly formatted CSV file.
3. The imported records will appear in the table.

The expected CSV header is:

```csv
Date,Subject,Duration,Description
```

Example CSV data:

```csv
Date,Subject,Duration,Description
2026-10-12,Java,2.5,Practiced collections
2026-10-12,DBMS,1.5,Revised SQL queries
2026-10-11,Python,2.0,Practiced file handling
```

Descriptions containing commas or quotation marks are supported by the CSV parser.

### 6. View Study Summaries

**Summary by Date**

Displays the total study duration for each date.

**Summary by Subject**

Displays the total study duration for each subject.

Both reports also display the total study time across all records.

## 🧠 Concepts Implemented

### Object-Oriented Programming

- **Classes and Objects:** `StudyLog`, `StudyTracker`, and `program868`.
- **Encapsulation:** Private fields and public getter methods in `StudyLog`.
- **Abstraction:** Separate classes for study records, data management, and GUI functionality.

### Java Collections

- `ArrayList` stores study records.
- `TreeMap` organizes summaries by date and subject.
- `Collections.unmodifiableList()` provides a read-only view of the study records.

### Exception Handling

- `DateTimeParseException` handles invalid dates.
- `NumberFormatException` handles invalid duration values.
- `IOException` handles file import and export errors.

### GUI Programming

- `JFrame` creates the main application window.
- `JPanel` organizes interface components.
- `JTable` displays study records.
- `JTextField` and `JTextArea` collect user input.
- `JComboBox` supports subject selection.
- `JButton` triggers application operations.
- `JFileChooser` selects CSV files.
- `JOptionPane` displays messages and reports.

### File Handling

- `BufferedReader` reads CSV files.
- `BufferedWriter` writes CSV files.
- `Files` and `StandardCharsets.UTF_8` support file operations and text encoding.

## 📊 Example Output

### Study Logs

| Date | Subject | Duration (hours) | Description |
|---|---|---:|---|
| 2026-10-12 | Java | 2.50 | Practiced collections |
| 2026-10-12 | DBMS | 1.50 | Revised SQL queries |
| 2026-10-11 | Python | 2.00 | Practiced file handling |

### Summary by Subject

```text
Study duration by subject

DBMS     | 1.50 hours
Java     | 2.50 hours
Python   | 2.00 hours

Total study time: 6.00 hours
```

*The displayed values are illustrative examples.*

## ⚠️ Limitations

- Study records are stored in memory while the application is running.
- Records added during a session are not automatically saved when the application closes.
- Export your records to CSV before closing the application if you want to preserve them.
- Importing the same CSV file multiple times adds duplicate records.
- The CSV importer expects one record per line; multiline quoted CSV fields are not supported.
- The application does not currently use a database such as MySQL or MongoDB.

## 🔮 Future Enhancements

- Add MySQL or SQLite database integration.
- Automatically save study logs.
- Add daily and weekly study goals.
- Display study progress using charts.
- Generate monthly study reports.
- Add edit and delete functionality for study records.
- Add search and filtering options.
- Add dark mode and customizable themes.
- Track completed tasks and study streaks.

## 🎯 Learning Outcomes

This project demonstrates practical knowledge of:

- Java programming and object-oriented concepts.
- Swing-based GUI development.
- Collections and data structures.
- Exception handling and input validation.
- File handling and CSV processing.
- Data aggregation using maps.
- Event-driven programming.

## 👩‍💻 Author

**Vaishnavi Morankar**

- GitHub: [vaishn-stack](https://github.com/vaishn-stack)
- LinkedIn: [Vaishnavi Morankar](https://linkedin.com/in/vaishnavimorankar)
- Portfolio: [vaish-stack.github.io](https://vaish-stack.github.io)

## 📄 License

This project is available for educational and learning purposes. You may modify and extend it for your own practice and academic projects.
