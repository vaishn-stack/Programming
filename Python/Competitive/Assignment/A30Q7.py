import schedule
import time

def Display():

    print("Coding Kar..!")

def main():

    print("Scheduler Started...")

    schedule.every(30).minutes.do(Display)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()