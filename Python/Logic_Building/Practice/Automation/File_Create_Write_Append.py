def main():
    try:
        fobj = open("Demo.txt","a")         # A -> append
        
        # open("Demo.txt","r")   file banvavi lagte
        # open("Demo.txt","w")   file automatic create hote
        
        print("File gets opened")

        fobj.write(" Pune Maharashtra")
        
        fobj.close()             
        
    except FileNotFoundError as fobj:
        print("File is not present in current directory")
        
        
if __name__ == "__main__":
    main()