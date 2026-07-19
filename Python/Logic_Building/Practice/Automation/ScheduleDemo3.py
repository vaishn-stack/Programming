import schedule
import time
import datetime

def Display():
    print("Jay Ganesh...",datetime.datetime.now())
    
def main():
    print("Automation Script started")
    
    schedule.every(1).minute.do(Display)   
    
    # schedule.every(1).second.do(Display)   
    # schedule.every(1).hour.do(Display)     
    
    while True:
        schedule.run_pending()
        time.sleep(1) 

    print("End of automation script")
    
if __name__ == "__main__":
    main()
    
# datetime.datetime.now()
# module  .class   .method 
# import time   -   in built module
# import datetime -   in built module