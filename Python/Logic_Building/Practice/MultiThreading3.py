# threaded method

import threading

def Display(No):                # def Display(*No) - variable no of argument
    
    print(f"Inside Display {No} : ",threading.get_ident())    
    
def main():

    print("Inside Main : ",threading.get_ident())
    
    tobj = threading.Thread(target=Display, args=(11,))           
    
    tobj.start()
    
if __name__ == "__main__":
    main()