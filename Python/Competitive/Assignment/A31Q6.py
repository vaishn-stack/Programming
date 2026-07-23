import schedule
import time

def WeeklyTask():
    print("Weekly Task Executed")

def main():

    schedule.every().monday.at("10:00").do(WeeklyTask)
    schedule.every().wednesday.at("10:00").do(WeeklyTask)
    schedule.every().friday.at("10:00").do(WeeklyTask)

    print("Scheduler Started...")
    print("Task will execute on Monday, Wednesday and Friday at 10:00 AM.")
    print("Press Ctrl + C to stop.\n")

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()