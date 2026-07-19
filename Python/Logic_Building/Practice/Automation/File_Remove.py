import os

def main():
    try:
        # fobj.remove() -> not applicable 
        # remove navachi method permanently file delete krte recycle bin madhe stored hot nhi
        
        os.remove("Demo.txt")
        
    except FileNotFoundError as fobj:
        print("File is not present in current directory")
        
        
if __name__ == "__main__":
    main()