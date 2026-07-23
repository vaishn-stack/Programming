import schedule
import time
import shutil
import os
from datetime import datetime

def Backup():

    Source = input("Enter Source File Path : ")
    Destination = input("Enter Destination Directory : ")

    if not os.path.isfile(Source):
        print("Source file does not exist.")
        return

    if not os.path.isdir(Destination):
        print("Destination directory does not exist.")
        return

    FileName = os.path.basename(Source)
    Name, Extension = os.path.splitext(FileName)

    TimeStamp = datetime.now().strftime("%d_%m_%Y_%H_%M_%S")

    BackupFile = Name + "_" + TimeStamp + Extension
    BackupPath = os.path.join(Destination, BackupFile)

    shutil.copy2(Source, BackupPath)

    with open("backup_log.txt", "a") as fobj:
        fobj.write("Backup completed successfully at ")
        fobj.write(datetime.now().strftime("%d-%m-%Y %I:%M:%S %p"))
        fobj.write("\n")

    print("Backup completed successfully.")

def main():

    print("Scheduler Started...")
    print("Backup will run every hour.\n")

    schedule.every(1).hours.do(Backup)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()