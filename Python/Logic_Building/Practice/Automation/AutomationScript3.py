# python Automation.py --h
# python Automation.py --u
# python Automation.py Marvellous

# python Automation.py --d             --> invalid
# python Automation.py Marvellous Demo --> invalid

import sys

def main():
    
    if(len(sys.argv) == 2):
        if(sys.argv[1] == "--h" or sys.argv[1] == "--H"):
            print("Help")
        elif(sys.argv[1] == "--u" or sys.argv[1] == "--U"):
            print("Usage")
        else:
            DirectoryName = sys.argv[1]
            print("Directory name is :",DirectoryName)
        
    else:
        print("Invalid number of arguments")
        print("Please use --h or -- u for more information")
    
if __name__ == "__main__":
    main()
     
# industry oriented
# --h - help pahuje       # called as flag
# --u - usage pahije      # called as flag