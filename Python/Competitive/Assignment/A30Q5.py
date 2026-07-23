import schedule
import time

def LunchTime():
    print("Lunch Time!")

def WrapUp():
    print("Wrap up work")

def main():

    print("Scheduler Started...")

    schedule.every().day.at("1:00").do(LunchTime)
    schedule.every().day.at("6:00").do(WrapUp)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()