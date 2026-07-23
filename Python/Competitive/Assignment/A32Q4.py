import schedule
import time
import os
import shutil

def CopyFiles(Source, Destination):

    if os.path.exists(Source) and os.path.exists(Destination):

        for File in os.listdir(Source):

            if File.endswith(".txt"):

                SourcePath = os.path.join(Source, File)
                DestinationPath = os.path.join(Destination, File)

                shutil.copy2(SourcePath, DestinationPath)

        print("All .txt files copied successfully.")

    else:
        print("Invalid directory.")
        
def main():

    Source = input("Enter source directory : ")
    Destination = input("Enter destination directory : ")

    print("Scheduler Started...")

    schedule.every(5).minutes.do(CopyFiles, Source, Destination)

    while True:
        schedule.run_pending()
        time.sleep(1)
        

if __name__ == "__main__":
    main()