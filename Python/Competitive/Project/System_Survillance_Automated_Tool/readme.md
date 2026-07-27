# 🖥️ Platform Surveillance System

An industry-oriented Python automation project that periodically monitors the system resources and generates detailed reports in **LOG** and **CSV** formats. The project also supports **Email Automation** to send generated reports automatically.

---

# 📌 Project Overview

Platform Surveillance System is a Python-based automation tool developed to monitor various system resources at regular intervals.

The application periodically collects information about:

- Running Processes
- CPU Usage
- RAM Usage
- Hard Disk Usage
- Network Statistics

The collected information is stored in a timestamp-based log file. The generated log is automatically converted into CSV format and emailed to the specified recipient.

---

# 🚀 Features

✅ Running Process Monitoring

✅ CPU Usage Monitoring

✅ RAM Usage Monitoring

✅ Hard Disk (HDD) Monitoring

✅ Network Usage Monitoring

✅ Process Counter

✅ Timestamp-based Log Generation

✅ Automatic CSV Report Generation

✅ Email Automation

✅ Command Line Argument Support

✅ Automatic Scheduler

✅ Automatic Scheduler Stop

---

# 📂 Project Structure

```
Platform-Surveillance-System
│
├── ProcessSurvillence_Final.py
├── config.json
├── requirements.txt
├── README.md
├── .gitignore
│
├── Logs
│   ├── Marvellous_2026-07-27_18-20-56.log
│   └── Marvellous_2026-07-27_18-20-56.csv

---

# 🛠 Technologies Used

- Python 3.x
- psutil
- schedule
- csv
- json
- smtplib
- EmailMessage

---

# 📦 Python Modules

Install all required modules using

```bash
pip install -r requirements.txt
```

or

```bash
pip install psutil schedule
```

---

# ⚙️ Configuration

Create a file named

```
config.json
```

Add the following information

```json
{
    "sender_email":"vaishnavimorankar1905@gmail.com",
    "app_password":"gkzy qhiy mghz mhah",
    "receiver_email":"vaishnavimorankar05@gmail.com"
}
```

> **Note**
>
> Gmail SMTP requires a **Google App Password**.
> Your normal Gmail password will not work.

---

# ▶️ How to Run

### Help Menu

```bash
python ProcessSurvillence_Final.py --h
```

---

### Usage

```bash
python ProcessSurvillence_Final.py --u
```

---

### Start Monitoring

```bash
python ProcessSurvillence_Final.py 1 Logs
```

where

```
1     -> Time Interval (Minutes)

Logs  -> Folder Name
```

---

# 📊 Generated Report

The system automatically generates

```
Marvellous_YYYY-MM-DD_HH-MM-SS.log
```

Example

```
Logs/

Marvellous_2026-07-27_18-32-47.log
```

---

# 📄 CSV Report

The generated log file is automatically converted into CSV format.

Example

```
Marvellous_2026-07-27_18-32-47.csv
```

---

# 📧 Email Automation

After generating the log file,

the application automatically

- Connects to Gmail SMTP Server
- Attaches the generated Log File
- Sends it to the configured receiver

---

# 📈 Information Collected

## CPU Information

- Number of CPU Cores
- CPU Usage Percentage

---

## Memory Information

- RAM Usage
- Total RAM

---

## Hard Disk Information

- Total HDD
- Used HDD
- Free HDD
- HDD Usage Percentage

---

## Network Information

- Bytes Sent
- Bytes Received

---

## Process Information

For every running process,

the system stores

- Process Number
- PID
- Process Name
- Username
- Process Status
- CPU Usage
- Memory Usage

---

# ⏲ Scheduler

The application uses the **schedule** module.

Example

```
Every 1 minute
```

↓

Generate Report

↓

Convert to CSV

↓

Send Email

↓

Repeat

↓

Automatically Stop

---

# 📸 Output

```
-------------------------------------------------------
----- Marvellous Platform Surveillance System -----
-------------------------------------------------------

Scheduler started successfully!

Log file created successfully.

CSV File Created

Mail Sent Successfully

Scheduler stopped after 1 minute

-------------------------------------------------------
Thank You for Using our Automation System
-------------------------------------------------------
```

---

# 📚 Command Line Arguments

### Help

```
python ProcessSurvillence_Final.py --h
```

---

### Usage

```
python ProcessSurvillence_Final.py --u
```

---

### Start Scheduler

```
python ProcessSurvillence_Final.py 1 Logs
```

---

# 🎯 Future Enhancements

- ZIP Compression for Log Files
- Automatic Log Rotation
- Delete Old Logs
- PDF Report Generation
- Excel Report Generation
- SQLite Database Storage
- Dashboard using Flask
- Live Monitoring GUI
- Email Multiple Recipients
- SMS Notification
- Cloud Backup
- Process Filtering
- Top 10 CPU Consuming Processes
- Top 10 RAM Consuming Processes

---

# 💻 Developed By

**Vaishnavi Deepak Morankar**

MCA Student

Python Developer | Automation Enthusiast

---

# ⭐ GitHub Repository

If you found this project useful,

please consider giving it a ⭐ on GitHub.

---

# 📄 License

This project is developed for educational and learning purposes.

Feel free to use and modify it for personal or academic projects.

---

## 🙏 Acknowledgements

Special thanks to **Marvellous Infosystems** for providing the learning foundation and inspiration for building automation-based Python projects.
