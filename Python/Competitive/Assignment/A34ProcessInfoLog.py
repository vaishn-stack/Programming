import os
import sys
import psutil
import smtplib
from email.message import EmailMessage
from datetime import datetime

# ----------------- Collect Process Information -----------------

def ProcessDisplay():
    listprocess = []

    for proc in psutil.process_iter():
        try:
            info = proc.as_dict(attrs=['pid', 'name', 'username'])
            listprocess.append(info)
        except (psutil.NoSuchProcess,
                psutil.AccessDenied,
                psutil.ZombieProcess):
            pass

    return listprocess

# ----------------- Create Log File -----------------

def CreateLog(dirname):
    if not os.path.exists(dirname):
        os.mkdir(dirname)

    timestamp = datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
    filename = os.path.join(dirname, "ProcessLog_%s.log" % timestamp)

    processlist = ProcessDisplay()

    with open(filename, "w") as f:
        f.write("Marvellous Infosystems Process Log\n")
        f.write("Generated at : %s\n\n" % datetime.now())
        f.write("{:<10} {:<35} {:<30}\n".format("PID", "Process Name", "Username"))
        f.write("-" * 80 + "\n")

        for process in processlist:
            f.write("{:<10} {:<35} {:<30}\n".format(
                process['pid'],
                str(process['name']),
                str(process['username'])
            ))

    return filename

# ----------------- Send Email -----------------

def SendMail(receiver, logfile):

    sender = "vaishnavimorankar1905@gmail.com"
    password = "gkzy qhiy mghz mhah"

    msg = EmailMessage()
    msg["Subject"] = "Process Log File"
    msg["From"] = sender
    msg["To"] = receiver

    msg.set_content("Attached is the Process Log File.")

    with open(logfile, "rb") as f:
        data = f.read()
        name = os.path.basename(logfile)

    msg.add_attachment(data,
                       maintype="application",
                       subtype="octet-stream",
                       filename=name)

    server = smtplib.SMTP("smtp.gmail.com", 587)
    server.starttls()
    server.login(sender, password)
    server.send_message(msg)
    server.quit()

    print("Mail sent successfully.")

# ----------------- Main -----------------

def main():

    if len(sys.argv) != 3:
        print("Usage : ProcInfoLog.py DirectoryName EmailID")
        sys.exit()

    dirname = sys.argv[1]
    email = sys.argv[2]

    logfile = CreateLog(dirname)

    try:
        SendMail(email, logfile)
    except Exception as e:
        print("Unable to send mail.")
        print(e)

if __name__ == "__main__":
    main()