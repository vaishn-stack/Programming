import sys
import os
import hashlib

def CalculateCheckSum(FileName):
    fobj = open(FileName,"rb")
    
    hobj = hashlib.md5()
    
    Buffer = fobj.read(1000)
    
    while(len(Buffer) > 0):
        hobj.update(Buffer)
        Buffer = fobj.read(1000)
        
    fobj.close()
    
    return hobj.hexdigest()

def main():
    Ret = CalculateCheckSum("Demo.txt")
    print("Check sum of file is :",Ret)
    
if __name__ == "__main__":
    main()
    
# rb = read + binary
# md5 - class
# Buffer - file 1000 byte chi read krel
# eg- badli maga jo pryant pani sampat nhi 
# hexdigest() - function for checksum