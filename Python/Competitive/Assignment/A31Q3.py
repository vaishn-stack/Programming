import schedule
import time
import os

def DirectoryScanner(DirectoryName):

    if os.path.exists(DirectoryName):

        print("\nFiles in Directory :")

        for File in os.listdir(DirectoryName):
            print(File)

    else:
        print("Directory not found.")


def main():

    DirectoryName = input("Enter directory name : ")

    schedule.every(1).minutes.do(DirectoryScanner, DirectoryName)

    print("Scheduler Started...")

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()