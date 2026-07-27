#################################################################################################
# 
# Importing required libraries
#
#################################################################################################

import psutil
import sys
import os
import time
import schedule

import csv
import json
import smtplib

from email.message import EmailMessage

#################################################################################################
#
# Function Name :    ProcessScan
# Input         :    None
# Output        :    List
# Description   :    Scans all running processes and returns their information
# Author        :    Vaishnavi Deepak Morankar
# Date          :    27/07/2026
#
#################################################################################################

def ProcessScan():
    listprocess = []
    
    for proc in psutil.process_iter():
        try:
            info = proc.as_dict(attrs = ["pid","name","username","status"])
            info["cpu_percent"] = proc.cpu_percent(None)
            info["memory_percent"] = proc.memory_percent()
            
            listprocess.append(info)
        except(psutil.NoSuchProcess,
                psutil.AccessDenied,
                psutil.ZombieProcess):
            pass
        
    return listprocess

#################################################################################################
#
# Function Name :    PlatformSurvillance
# Input         :    Folder Name
# Output        :    Log File
# Description   :    Creates a log file and stores CPU, RAM, HDD,
#                    Network and Running Process information.
# Author        :    Vaishnavi Deepak Morankar
# Date          :    27/07/2026
#
#################################################################################################

def PlatformSurvillance(FolderName):
    Border = "-"*55
    
    Ret = False
    
    Ret = os.path.exists(FolderName) 
    
    if(Ret == True):
        Ret = os.path.isdir(FolderName)
        if(Ret == False):
            print("Unable to proceed as folder name is existing but its not a directory")
            return 
    else:
        os.mkdir(FolderName)
        print("Directory for the log file gets created successfully!")
        
    timestamp = time.strftime("%Y-%m-%d_%H-%M-%S")
    
    FileName = os.path.join(FolderName,"Marvellous_%s.log" %timestamp)
    
    fobj = open(FileName,"w")
    
    print(f"Log file gets successfully created with name {FileName}")

    fobj.write(Border + "\n")
    fobj.write("-----Marvellous Platform Survillence System-----\n")
    fobj.write("Log file gets created at : " + timestamp + "\n")
    fobj.write(Border + "\n\n")
    
    fobj.write("------------------System Report------------------\n")
    
    # CPU Information
    
    fobj.write("Number of active CPU Cores : %s\n" %psutil.cpu_count())
    fobj.write("CPU Usage : %s %%\n" %psutil.cpu_percent(interval = 1))
    fobj.write(Border + "\n")
    
    # RAM Information
    
    memory = psutil.virtual_memory()
    fobj.write("RAM Usage : %s %%\n" %memory.percent)
    fobj.write("Total RAM Available : %s Bytes\n" %memory.total)
    fobj.write(Border + "\n")
    
    # HARDDISK Information
    
    disk = psutil.disk_usage("C:\\")
    fobj.write("HDD Information\n")
    fobj.write("Total HDD : %.2f GB\n"%(disk.total/(1024**3)))
    fobj.write("Used HDD : %.2f GB\n"%(disk.used/(1024**3)))
    fobj.write("Free HDD : %.2f GB\n"%(disk.free/(1024**3)))
    fobj.write("HDD Usage : %.2f %%\n"%(disk.percent))
    fobj.write(Border+"\n")
    
    # Network Usage
    
    netobj = psutil.net_io_counters()
    fobj.write("Network Usage Report \n")
    fobj.write("Sent : %.2f MB\n" %(netobj.bytes_sent / (1024 * 1024)))
    fobj.write("Receive : %.2f MB\n" %(netobj.bytes_recv / (1024 * 1024)))
    fobj.write(Border + "\n")
    
    # Process log
    Data = ProcessScan()
    
    Count = 1
    
    for info in Data:
        fobj.write("PID : %s\n" %info.get("pid")) 
        fobj.write("Name : %s\n" %info.get("name")) 
        fobj.write("Username : %s\n" %info.get("username")) 
        fobj.write("Status : %s\n" %info.get("status")) 
        fobj.write("CPU Usage : %.4f\n" %info.get("cpu_percent")) 
        fobj.write("RAM Usage : %.4f\n" %info.get("memory_percent")) 
        fobj.write("Process Number : %d\n"%Count)
        fobj.write(Border + "\n")
        
        Count = Count + 1
        
    fobj.write("Total Running Processes : %d\n" %(Count-1))
 
    fobj.write(Border + "\n")
    fobj.write("------------------End of Log File-----------------\n")
    fobj.write(Border + "\n")
    
    fobj.close()

    ConvertLogToCSV(FileName)
    SendMail(FileName)
    
#################################################################################################
#
# Function Name :    ConvertLogToCSV
# Input         :    Log File Name
# Output        :    CSV File
# Description   :    Converts the generated log file into CSV format.
# Author        :    Vaishnavi Deepak Morankar
# Date          :    27/07/2026
#
#################################################################################################

def ConvertLogToCSV(LogFile):

    CSVFile = LogFile.replace(".log",".csv")

    with open(LogFile,"r") as fobj:

        lines = fobj.readlines()

    with open(CSVFile,"w",newline="") as cobj:

        writer = csv.writer(cobj)

        writer.writerow(["Log Data"])

        for line in lines:

            writer.writerow([line.strip()])

    print("CSV File Created :",CSVFile)
    
#################################################################################################
#
# Function Name :    SendMail
# Input         :    Log File Name
# Output        :    None
# Description   :    Sends the generated log file as an email attachment.
# Author        :    Vaishnavi Deepak Morankar
# Date          :    27/07/2026
#
#################################################################################################

def SendMail(FileName):

    try:
        with open("config.json","r") as f:

            config = json.load(f)

        EMAIL = config["sender_email"]
        PASSWORD = config["app_password"]
        RECEIVER = config["receiver_email"]

        msg = EmailMessage()

        msg["Subject"] = "Platform Surveillance Report"

        msg["From"] = EMAIL

        msg["To"] = RECEIVER

        msg.set_content("Latest System Report Attached")

        with open(FileName,"rb") as f:

            data = f.read()

        msg.add_attachment(data,
                            maintype="application",
                            subtype="octet-stream",
                            filename=os.path.basename(FileName))

        smtp = smtplib.SMTP("smtp.gmail.com",587)

        smtp.starttls()

        smtp.login(EMAIL,PASSWORD)

        smtp.send_message(msg)
        print("Mail sent to :", RECEIVER)
        print("Subject :", msg["Subject"])
        
        smtp.quit()

        print("=" * 50)
        print("Email Status")
        print("Receiver :", RECEIVER)
        print("Attachment :", os.path.basename(FileName))
        print("Status : Mail Sent Successfully")
        print("=" * 50)
    except Exception as e:
        print("Unable to send mail :",e)

#################################################################################################
#
# Function Name :    main
# Input         :    Command Line Arguments
# Output        :    None
# Description   :    Entry point of the automation script. It validates
#                    command line arguments and starts the scheduler.
# Author        :    Vaishnavi Deepak Morankar
# Date          :    27/07/2026
#
#################################################################################################

def main():
    Border = "-"*55
    print(Border)
    print("----- Marvellous Platform Survillence System -----")
    print(Border)

    # --h and --u handling
    if(len(sys.argv) == 2):
        if(sys.argv[1]== "--h" or sys.argv[1]== "--H"):
            print("This automation script is used to perform")
            print("1: It fetch information of running processes")
            print("2: It fetch information about the primary storage as RAM")
            print("3: It fetch information about the primary storage as HDD")
            print("4: It fetch information about the microprocessor")
            print("5: It gets auto scheduled periodically")
            print("6: It maintains all records into log file")
            print("7: It sends the log files through mail periodically")
            print("8: Converts Log into CSV File")
                 
        elif(sys.argv[1]== "--u" or sys.argv[1]== "--U"):
            print("Use automation script as : ")
            print(f"python {sys.argv[0]} Time_Interval Folder_Name")
            print("Time Interval : Time in minutes for periodic execution")
            print("Folder_Name : Name of the folder for the log file creation")
            
        else:
            print("Unable to proceed as there is no matching arguments")
            print("Please use --h or --u flag for getting more details")
        
    # Actual project code    
    elif(len(sys.argv) == 3):
        
        print("Scheduler started successfully!...")
        print("Press Ctrl + C to abort the automation Script")
        
        schedule.every(int(sys.argv[1])).minutes.do(PlatformSurvillance, sys.argv[2])   
        StartTime = time.time()
        
        while True:

            STOP_TIME = 60
            
            schedule.run_pending()

            if(time.time() - StartTime >= STOP_TIME):

                print("Scheduler stopped after 1 minutes")

                break

            time.sleep(1)
        
    else:
        print("Inavalid number of Arguments")
        print("Unable to proceed as arguments are not matching")
        print("Please use --h or --u flag for getting more details")
        
    print(Border)
    print("-----Thank you for using our Automation System-----")
    print(Border)
 
#################################################################################################
# 
# Starter of the automation script
#
#################################################################################################
   
if __name__ == "__main__":
    main()
    