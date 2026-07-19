import schedule
import time
import datetime

def Display():
    print("Jay Ganesh...",datetime.datetime.now())
    
def main():
    print("Automation Script started")
    
    schedule.every(1).minute.do(Display)        
    
    # Issue - file alive thevynasathi khi tari pahije

if __name__ == "__main__":
    main()
    
# datetime.datetime.now()
# module  .class   .method 
# import time   -   in built module
# import datetime -   in built module