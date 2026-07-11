# threaded method

import threading

def Display():
    # child thread
    print("Inside Display : ",threading.get_ident())    
    
def main():
    # parent thread
    print("Inside Main : ",threading.get_ident())
    
    tobj = threading.Thread(target=Display)           # thread cha object create zala
    
    tobj.start()
    
if __name__ == "__main__":
    main()