import smtplib
import os

from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders


# ----------------------------------------------------------
# Send Mail Function
# ----------------------------------------------------------

def SendMail(SenderEmail,
             AppPassword,
             ReceiverEmail,
             LogFile,
             StartTime,
             EndTime,
             Directory,
             TotalFiles,
             DuplicateFiles,
             DeletedFiles):

    try:

        Message = MIMEMultipart()

        Message["From"] = SenderEmail
        Message["To"] = ReceiverEmail
        Message["Subject"] = "Duplicate File Removal Report"

        Body = f"""
Jay Ganesh,

The duplicate-file removal operation has been completed successfully.

Operation Statistics

Starting Time : {StartTime}

Completion Time : {EndTime}

Directory Scanned : {Directory}

Total Files Scanned : {TotalFiles}

Duplicate Files Found : {DuplicateFiles}

Duplicate Files Deleted : {DeletedFiles}

Please find the attached log file.

Regards,

Marvellous Automation System
"""

        Message.attach(MIMEText(Body, "plain"))

        # Attach Log File

        Attachment = open(LogFile, "rb")

        Payload = MIMEBase("application", "octet-stream")

        Payload.set_payload(Attachment.read())

        encoders.encode_base64(Payload)

        Payload.add_header(
            "Content-Disposition",
            "attachment; filename=" + os.path.basename(LogFile)
        )

        Message.attach(Payload)

        Attachment.close()

        # Gmail SMTP Server

        Server = smtplib.SMTP("smtp.gmail.com", 587)

        Server.starttls()

        Server.login(SenderEmail, AppPassword)

        Text = Message.as_string()

        Server.sendmail(SenderEmail,
                        ReceiverEmail,
                        Text)

        Server.quit()

        return True

    except Exception as e:

        print("Unable to send email")
        print(e)

        return False