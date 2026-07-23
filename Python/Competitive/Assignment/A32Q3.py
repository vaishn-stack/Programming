import schedule
import time
import os

def ReadFile(FileName):

    if os.path.exists(FileName):

        with open(FileName,"r") as fobj:

            Data = fobj.read()

        print("\nFile Contents :")
        print(Data)

    else:
        print("File not found.")
        
def main():

    FileName = input("Enter file name : ")

    print("Scheduler Started...")

    schedule.every(1).minutes.do(ReadFile, FileName)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()