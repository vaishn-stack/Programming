import os
import sys
import time
import hashlib
import datetime
import schedule

################################################################################
# Function Name : CalculateCheckSum
################################################################################

def CalculateCheckSum(FileName):
    fobj = open(FileName,"rb")
    
    hobj = hashlib.md5()
    
    Buffer = fobj.read(1024)
    
    while(len(Buffer) > 0):
        hobj.update(Buffer)
        Buffer = fobj.read(1024)
        
    fobj.close()
    
    return hobj.hexdigest()

################################################################################
# Function Name : CreateLog
################################################################################

def CreateLog(DirectoryName, TotalFiles, DuplicateGroups, DeletedFiles, DuplicateList):
    if not os.path.exists("Logs"):
        os.mkdir("Logs")
    
    CurrentTime = datetime.datetime.now()

    LogName = "Logs/Log_" + CurrentTime.strftime("%Y%m%d_%H%M%S") + ".txt"

    with open(LogName, "w") as fobj:

        fobj.write("=====================================================\n")
        fobj.write("          Duplicate File Cleaner Log\n")
        fobj.write("=====================================================\n\n")

        fobj.write("Date : " + CurrentTime.strftime("%d/%m/%Y") + "\n")
        fobj.write("Time : " + CurrentTime.strftime("%H:%M:%S") + "\n\n")

        fobj.write("Directory : " + DirectoryName + "\n\n")

        fobj.write("Total Files Scanned : " + str(TotalFiles) + "\n")
        fobj.write("Duplicate Groups    : " + str(DuplicateGroups) + "\n")
        fobj.write("Deleted Files       : " + str(DeletedFiles) + "\n\n")

        fobj.write("Duplicate Files\n")
        fobj.write("-------------------------------------------\n")

        for value in DuplicateList:
            for file in value:
                fobj.write(file + "\n")

            fobj.write("-------------------------------------------\n")

    print("Log Generated :", LogName)
    
################################################################################
# Function Name : FindDuplicate
################################################################################

def FindDuplicate(DirectoryName):
    Duplicate = {}

    TotalFiles = 0

    if not os.path.exists(DirectoryName):
        print("Invalid Path")
        return None, 0

    if not os.path.isdir(DirectoryName):
        print("Path is not Directory")
        return None, 0

    for FolderName, SubFolder, FileNames in os.walk(DirectoryName):

        for fname in FileNames:

            TotalFiles += 1

            FilePath = os.path.join(FolderName, fname)

            CheckSum = CalculateCheckSum(FilePath)

            if CheckSum is None:
                continue

            if CheckSum in Duplicate:
                Duplicate[CheckSum].append(FilePath)
            else:
                Duplicate[CheckSum] = [FilePath]

    return Duplicate, TotalFiles
    

################################################################################
# Function Name : DeleteDuplicate
################################################################################

def DeleteDuplicate(DirectoryName):
    MyDict, TotalFiles = FindDuplicate(DirectoryName)

    if MyDict is None:
        return

    Result = list(filter(lambda x: len(x) > 1, MyDict.values()))

    Deleted = 0

    print("\nDuplicate Files Found\n")

    for value in Result:

        print("--------------------------------")

        for file in value:
            print(file)

        print("--------------------------------")

    for value in Result:

        First = True

        for file in value:

            if First:
                First = False
                continue
            
            try:
                os.remove(file)
                Deleted += 1
                print("Deleted :", file)

            except Exception:
                print("Unable to Delete :", file)

    CreateLog(
        DirectoryName,
        TotalFiles,
        len(Result),
        Deleted,
        Result
    )

    print("\nSummary")
    print("---------------------------")
    print("Total Files Scanned :", TotalFiles)
    print("Duplicate Groups    :", len(Result))
    print("Deleted Files       :", Deleted)
    print("---------------------------")
    
################################################################################
# Scheduler Function
################################################################################

def Job(Path):

    print("\n====================================")
    print("Scanning Started...")
    print(datetime.datetime.now())
    print("====================================\n")

    DeleteDuplicate(Path)


################################################################################
# Main
################################################################################

def main():
    if len(sys.argv) != 2:
        print("Usage : python DuplicateCleaner.py DirectoryName")
        return

    DirectoryName = sys.argv[1]

    Job(DirectoryName)

    print("\nScheduler Started...")
    print("Scanning every 1 minutes...\n")

    schedule.every(1).minutes.do(Job, DirectoryName)

    while True:
        schedule.run_pending()
        time.sleep(1)
    
################################################################################

if __name__ == "__main__":
    main()
  