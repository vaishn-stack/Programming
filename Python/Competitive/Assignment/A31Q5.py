import schedule
import time
import os

def CountFiles(DirectoryName):

    if os.path.exists(DirectoryName):

        Count = 0

        for File in os.listdir(DirectoryName):

            Path = os.path.join(DirectoryName, File)

            if os.path.isfile(Path):
                Count = Count + 1

        print("Total Files :", Count)

    else:
        print("Directory not found.")

def main():

    DirectoryName = input("Enter directory name : ")
    schedule.every(5).minutes.do(CountFiles, DirectoryName)

    print("Scheduler Started...")
    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()