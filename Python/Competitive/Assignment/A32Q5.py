import schedule
import time
import os

def DeleteEmptyFiles(Directory):

    if os.path.exists(Directory):

        for File in os.listdir(Directory):

            Path = os.path.join(Directory, File)

            if os.path.isfile(Path):

                if os.path.getsize(Path) == 0:

                    os.remove(Path)
                    print(File, "deleted.")

    else:
        print("Directory not found.")
        
def main():

    Directory = input("Enter directory path : ")

    print("Scheduler Started...")

    schedule.every(5).minutes.do(DeleteEmptyFiles, Directory)

    while True:
        schedule.run_pending()
        time.sleep(1)
        
if __name__ == "__main__":
    main()