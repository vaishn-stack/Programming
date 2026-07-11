# multithreaded method
# refer DataTypeX.py

import threading

def Display(No1, No2, No3):                
    
    print(f"Inside Display {No1, No2, No3} : ",threading.get_ident())    
    
def main():

    print("Inside Main : ",threading.get_ident())
    
    tobj = threading.Thread(target=Display, args=(11,21,51,))           
    
    tobj.start()
    
if __name__ == "__main__":
    main()