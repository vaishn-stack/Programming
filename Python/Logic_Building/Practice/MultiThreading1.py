# Laptop chi purn mahiti kadnar function lihaych ae actual time initialiser
# threaded method

import threading

def Display():
    print("Inside Display : ",threading.get_ident())    # get_ident() --> identify current thread id
    
def main():
    print("Inside Main : ",threading.get_ident())
    Display()
    
if __name__ == "__main__":
    main()