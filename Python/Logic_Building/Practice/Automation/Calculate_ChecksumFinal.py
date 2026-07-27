import sys
import os
import hashlib

def CalculateCheckSum(FileName):
    fobj = open(FileName,"rb")
    
    hobj = hashlib.md5()
    
    Buffer = fobj.read(1024)
    
    while(len(Buffer) > 0):
        hobj.update(Buffer)
        Buffer = fobj.read(1024)
        
    fobj.close()
    
    return hobj.hexdigest()

def main():
    Ret = CalculateCheckSum("DemoX.txt")
    print("Check sum of file is :",Ret)
    
if __name__ == "__main__":
    main()

# 1024 - 1 kB
# 4096 buffer ae
# 1000 as 4 vela jael
# mg 24 ekda buffer while madhe jael 