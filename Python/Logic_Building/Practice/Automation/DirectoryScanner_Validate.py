import sys
import os
import time
import schedule

def DirectoryScanner(DirectoryPath = "Marvellous"):
    Border = "-"*50
    
    timestamp = time.ctime()
    LogFileName = "Marvellous%s.log"%(timestamp)
    
    LogFileName = LogFileName.replace(" ","_")
    LogFileName = LogFileName.replace(":","_")  
    
    Ret = False
    
    Ret = os.path.exists(DirectoryPath)
    
    # filter - validator
    if(Ret == False):
        print("Marvellous Automation Error : There is no such directory with name",DirectoryPath)
        return 
    
    Ret = os.path.isdir(DirectoryPath)
    
    # filter - validator
    if(Ret == False):
        print("Marvellous Automation Error : It is not a directory with name",DirectoryPath)
        return 
        
    print("Log File gets created with name : ",LogFileName)
    
    fobj = open(LogFileName,"w")
    
    fobj.write(Border + "\n")
    fobj.write("Marvellous Automation Script \n")
    fobj.write(Border + "\n\n")
    
    fobj.write("Files from the Directory are : \n\n")
    fobj.write(Border + "\n")
    
    for FolderName, SubFolder, FileName in os.walk(DirectoryPath):
        for fname in FileName:
            fobj.write(fname + "\n")
    
    fobj.write(Border + "\n")
    fobj.write("Log File gets create at : "+timestamp)
    fobj.write("\n" + Border + "\n")
    
    fobj.close()
    
def main():
    Border = "-"*50
    
    print(Border)
    print("Marvellous Automation Script")
    print(Border)
    
    if(len(sys.argv) == 2):
        
        if(sys.argv[1] == "--h" or sys.argv[1] == "--H"):
            print("This Automation Script is used to travel the directory")
            print("For better usage please check --u flag")
            
        elif(sys.argv[1] == "--u" or sys.argv[1] == "--U"):
            print("Please excute script as ")
            print("Python FileName.py DirectoryName")
            print("DirectoryName should be absolute path")
            
        else:
            # DirectoryScanner(sys.argv[1])
            # schedule.every(10).seconds.do(DirectoryScanner,sys.argv[1])  
            schedule.every(1).minute.do(DirectoryScanner,sys.argv[1])  
            
            while True:
                schedule.run_pending()
                time.sleep(1)
           
    else:
        print("Invalid number of arguments")
        print("Please use --h or -- u for more information")
        
    print(Border)
    print("Thank you for using Marvellous Automation Script")
    print(Border)
    
if __name__ == "__main__":
    main()
     
# industry oriented
# --h - help pahuje       # called as flag
# --u - usage pahije      # called as flag
# pip - pip install packages
# marvellouslog navach folder banvun tyat directoryscannerlog chya file takaychya ae
# sender la special mail banvaycha and receiver la special mail lavun automation cha code kela ae
# e-perfume project madhe automation cha code lavun mail login kela ka tyachya mail la msg automatically jael
# Whatsapp web api used krun msg send kraycha
# ha code server based log file create using scheduler,exists,isdir,for loop,validation krnyacha ae