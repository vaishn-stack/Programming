import schedule
import time

def Display(Message):
    print(Message)

def main():

    Message = input("Enter the message : ")
    Interval = int(input("Enter interval (in seconds) : "))

    print("Scheduler Started...")

    schedule.every(Interval).seconds.do(Display, Message)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()