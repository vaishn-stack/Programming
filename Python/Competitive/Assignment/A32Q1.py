import schedule
import time
from datetime import datetime

def CreateFile():

    FileName = "Marvellous_" + datetime.now().strftime("%d_%m_%Y_%H_%M_%S") + ".txt"

    with open(FileName,"w") as fobj:
        fobj.write("This file is created automatically.\n")
        fobj.write("Created at : ")
        fobj.write(str(datetime.now()))

    print(FileName,"created successfully.")
    
def main():

    print("Scheduler Started...")

    schedule.every(1).minutes.do(CreateFile)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()