import schedule
import time
from datetime import datetime

def CreateLog():

    FileName = "Log_" + datetime.now().strftime("%d_%m_%Y_%H_%M_%S") + ".txt"

    with open(FileName, "w") as fobj:
        fobj.write("Log File Created Successfully\n")
        fobj.write("Time : " + str(datetime.now()))

    print(FileName, "created.")

def main():

    schedule.every(10).minutes.do(CreateLog)

    print("Scheduler Started...")

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()