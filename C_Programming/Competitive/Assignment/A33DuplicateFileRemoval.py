import sys
import time
import datetime

import A33.A33MarvellousFunctions as A33MarvellousFunctions
import A33.A33MailSender as A33MailSender


# ---------------------------------------------------------
# Help
# ---------------------------------------------------------

def DisplayHelp():

    print("------------------------------------------------------")
    print("Duplicate File Removal Automation")
    print("------------------------------------------------------")
    print("This application removes duplicate files")
    print("and sends the log file through Email.")
    print()
    print("Command :")
    print("python DuplicateFileRemoval.py Directory Interval Email")
    print()
    print("Example :")
    print("python DuplicateFileRemoval.py D:\\Data 60 abc@gmail.com")
    print("------------------------------------------------------")


# ---------------------------------------------------------
# Usage
# ---------------------------------------------------------

def DisplayUsage():

    print("------------------------------------------------------")
    print("Usage :")
    print("DuplicateFileRemoval.py Directory Interval Email")
    print()
    print("Directory : Folder to scan")
    print("Interval  : Time in seconds")
    print("Email     : Receiver Email")
    print("------------------------------------------------------")


# ---------------------------------------------------------
# Main
# ---------------------------------------------------------

def main():

    if len(sys.argv) == 2:

        if sys.argv[1] == "--help":
            DisplayHelp()
            return

        elif sys.argv[1] == "--usage":
            DisplayUsage()
            return

    if len(sys.argv) != 4:

        print("Invalid number of arguments")
        print("Use --help or --usage")
        return

    Directory = sys.argv[1]
    Interval = sys.argv[2]
    ReceiverEmail = sys.argv[3]

    if A33MarvellousFunctions.ValidateDirectory(Directory) == False:
        print("Invalid Directory")
        return

    if A33MarvellousFunctions.ValidateInterval(Interval) == False:
        print("Invalid Interval")
        return

    if A33MarvellousFunctions.ValidateEmail(ReceiverEmail) == False:
        print("Invalid Email")
        return

    # ------------------------------
    # Sender Email Configuration
    # ------------------------------

    SenderEmail = "vaishnavimorankar1905@gmail.com"

    AppPassword = "gkzy qhiy mghz mhah"
    
    Interval = int(Interval)

    print("Duplicate File Removal Started...")

    while True:

        StartTime = datetime.datetime.now()

        LogFile = A33MarvellousFunctions.CreateLogFile()

        DuplicateData = A33MarvellousFunctions.FindDuplicateFiles(Directory)

        TotalFiles = len(A33MarvellousFunctions.ScanDirectory(Directory))

        DuplicateFound = 0

        for Key in DuplicateData:

            if len(DuplicateData[Key]) > 1:
                DuplicateFound += len(DuplicateData[Key]) - 1

        DeletedFiles = A33MarvellousFunctions.DeleteDuplicateFiles(DuplicateData)

        EndTime = datetime.datetime.now()

        A33MarvellousFunctions.WriteLog(
            LogFile,
            Directory,
            StartTime,
            EndTime,
            TotalFiles,
            DuplicateFound,
            DeletedFiles
        )

        A33MarvellousFunctions.DisplayStatistics(
            TotalFiles,
            DuplicateFound,
            DeletedFiles
        )

        Status = A33MailSender.SendMail(
            SenderEmail,
            AppPassword,
            ReceiverEmail,
            LogFile,
            StartTime,
            EndTime,
            Directory,
            TotalFiles,
            DuplicateFound,
            len(DeletedFiles)
        )

        if Status == True:
            print("Email Sent Successfully")
        else:
            print("Unable to Send Email")

        print("---------------------------------------")
        print("Waiting for next execution...")
        print("---------------------------------------")

        time.sleep(Interval)


# ---------------------------------------------------------
# Starter
# ---------------------------------------------------------

if __name__ == "__main__":
    main()