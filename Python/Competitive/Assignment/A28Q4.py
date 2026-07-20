def CopyFile(Source,Destination): 
    try:
        fsrc = open(Source,"r")
        fdest = open(Destination,"w")

        for line in fsrc:
            fdest.write(line)

        print("Contents copied successfully")

        fsrc.close()
        fdest.close()
        
    except FileNotFoundError:
        print("File not Found")
        
def main():
    Source = input("Enter source file : ")
    Destination = input("Enter destination file : ")
    
    CopyFile(Source,Destination)
    
if __name__ == "__main__":
    main()