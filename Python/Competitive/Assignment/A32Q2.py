import schedule
import time
import os

def FileSize(FileName):

    if os.path.exists(FileName):

        Size = os.path.getsize(FileName)

        print("Current File Size :", Size, "Bytes")

    else:
        print("File not found.")
        
def main():

    FileName = input("Enter file name : ")

    print("Scheduler Started...")

    schedule.every(30).seconds.do(FileSize, FileName)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()