import schedule
import time
from datetime import datetime

def DisplayDateTime():
    CurrentTime = datetime.now()
    print("Current Date and Time : ", CurrentTime.strftime("%d-%m-%Y %T:%M:%S %p"))
    
def main():
    print("Scheduler started...")
    print("Current date and time will be displayed every minute.")
    
    schedule.every(1).minutes.do(DisplayDateTime)
    
    while True:
        schedule.run_pending()
        time.sleep(1)
        

if __name__ == "__main__":
    main()