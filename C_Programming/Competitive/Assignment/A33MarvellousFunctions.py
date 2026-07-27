import os
import hashlib
import datetime

# ---------------------------------------------------------
# Validate Directory
# ---------------------------------------------------------

def ValidateDirectory(path):
    if not os.path.exists(path):
        return False

    if not os.path.isdir(path):
        return False

    return True


# ---------------------------------------------------------
# Validate Email
# ---------------------------------------------------------

def ValidateEmail(email):
    if "@" in email and "." in email:
        return True
    return False


# ---------------------------------------------------------
# Validate Interval
# ---------------------------------------------------------

def ValidateInterval(interval):
    try:
        interval = int(interval)

        if interval > 0:
            return True
        else:
            return False

    except:
        return False


# ---------------------------------------------------------
# Create Log Directory
# ---------------------------------------------------------

def CreateLogDirectory():

    DirectoryName = "Marvellous"

    if not os.path.exists(DirectoryName):
        os.mkdir(DirectoryName)

    return DirectoryName


# ---------------------------------------------------------
# Create Log File
# ---------------------------------------------------------

def CreateLogFile():

    Directory = CreateLogDirectory()

    TimeStamp = datetime.datetime.now().strftime("%d_%m_%Y_%H_%M_%S")

    FileName = os.path.join(
        Directory,
        "DuplicateRemovalLog_" + TimeStamp + ".log"
    )

    return FileName


# ---------------------------------------------------------
# Calculate MD5 Checksum
# ---------------------------------------------------------

def CalculateChecksum(path):

    BlockSize = 65536

    md5 = hashlib.md5()

    try:

        file = open(path, "rb")

        Buffer = file.read(BlockSize)

        while len(Buffer) > 0:
            md5.update(Buffer)
            Buffer = file.read(BlockSize)

        file.close()

        return md5.hexdigest()

    except:
        return None


# ---------------------------------------------------------
# Scan Directory
# ---------------------------------------------------------

def ScanDirectory(path):

    Files = []

    for FolderName, SubFolders, FileNames in os.walk(path):

        for File in FileNames:

            FullPath = os.path.join(FolderName, File)

            Files.append(FullPath)

    return Files


# ---------------------------------------------------------
# Find Duplicate Files
# ---------------------------------------------------------

def FindDuplicateFiles(path):

    Files = ScanDirectory(path)

    Duplicate = {}

    for File in Files:

        Checksum = CalculateChecksum(File)

        if Checksum is None:
            continue

        if Checksum in Duplicate:
            Duplicate[Checksum].append(File)
        else:
            Duplicate[Checksum] = [File]

    return Duplicate


# ---------------------------------------------------------
# Delete Duplicate Files
# ---------------------------------------------------------

def DeleteDuplicateFiles(Duplicate):

    DeletedFiles = []

    for Key in Duplicate.keys():

        if len(Duplicate[Key]) > 1:

            for File in Duplicate[Key][1:]:

                try:
                    os.remove(File)
                    DeletedFiles.append(File)

                except:
                    pass

    return DeletedFiles


# ---------------------------------------------------------
# Write Log File
# ---------------------------------------------------------

def WriteLog(LogFile,
             Directory,
             StartTime,
             EndTime,
             TotalFiles,
             DuplicateFound,
             DeletedFiles):

    fp = open(LogFile, "w")

    fp.write("*****************************************\n")
    fp.write("Duplicate File Removal Log\n")
    fp.write("*****************************************\n\n")

    fp.write("Directory : " + Directory + "\n")
    fp.write("Start Time : " + str(StartTime) + "\n")
    fp.write("End Time : " + str(EndTime) + "\n\n")

    fp.write("Total Files : " + str(TotalFiles) + "\n")
    fp.write("Duplicate Files Found : " +
             str(DuplicateFound) + "\n")
    fp.write("Duplicate Files Deleted : " +
             str(len(DeletedFiles)) + "\n\n")

    fp.write("Deleted Files\n")
    fp.write("------------------------------\n")

    for File in DeletedFiles:
        fp.write(File + "\n")

    fp.close()


# ---------------------------------------------------------
# Display Statistics
# ---------------------------------------------------------

def DisplayStatistics(TotalFiles,
                      DuplicateFound,
                      DeletedFiles):

    print("-------------------------------")
    print("Total Files :", TotalFiles)
    print("Duplicate Files :", DuplicateFound)
    print("Deleted Files :", len(DeletedFiles))
    print("-------------------------------")