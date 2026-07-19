import sys

def main():
    Border = "-"*50
    print(Border)
    print("Marvellous Automation Script")
    print(Border)
    
    if(len(sys.argv) == 2):
        
        if(sys.argv[1] == "--h" or sys.argv[1] == "--H"):
            print("This Automation Script is used to travel the directory")
            print("For better usage please check --u flag")
            
        elif(sys.argv[1] == "--u" or sys.argv[1] == "--U"):
            print("Please excute script as ")
            print("Python FileName.py DirectoryName")
            print("DirectoryName should be absolute path")
            
        else:
            DirectoryName = sys.argv[1]
            print("Directory name is :",DirectoryName)
        
    else:
        print("Invalid number of arguments")
        print("Please use --h or -- u for more information")
        
    print(Border)
    print("Thank you for using Marvellous Automation Script")
    print(Border)
    
if __name__ == "__main__":
    main()
     
# industry oriented
# --h - help pahuje       # called as flag
# --u - usage pahije      # called as flag