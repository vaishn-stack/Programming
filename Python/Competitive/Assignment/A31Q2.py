import schedule
import time

def DisplayMessage(Message):
    print(Message)

def main():

    schedule.every(3).seconds.do(DisplayMessage, "Jay Ganesh...")

    print("Scheduler Started...")

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()