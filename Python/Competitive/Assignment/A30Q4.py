import schedule
import time
from datetime import datetime

def WriteData():

    CurrentTime = datetime.now()

    with open("Marvellous.txt","a") as fobj:
        fobj.write("Task executed at : ")
        fobj.write(CurrentTime.strftime("%d-%m-%Y %I:%M:%S %p"))
        fobj.write("\n")

    print("Entry added successfully.")

def main():

    print("Scheduler Started...")
    print("Writing into Marvellous.txt every 5 minutes.")

    schedule.every(5).minutes.do(WriteData)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()