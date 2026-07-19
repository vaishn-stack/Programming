def main():
    try:
        fobj = open("Demo.txt","w")
        
        # open("Demo.txt","r")   file banvavi lagte
        # open("Demo.txt","w")   file automatic create hote
        # open("Demo.txt","w")
        
        print("File gets opened")
        
        fobj.close() # file ch kam zalyavr tila close kraych using close()
        
    except FileNotFoundError as fobj:
        print("File is not present in current directory")
        
        
if __name__ == "__main__":
    main()