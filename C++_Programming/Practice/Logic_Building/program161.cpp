#include<iostream>
using namespace std;

#pragma pack(1)     
class ArrayX
{
    public:
        int *Arr;              
        int iSize;

        ArrayX(int X)
        {
            iSize = X;                  
            Arr = new int(iSize);       
        }

        ~ArrayX()
        {
            delete []Arr;              
        }
};

int main()
{
    // Dyanmic memory Allocation for object
   
    ArrayX *aobj1 = new ArrayX(5); 

    // Logic (Function Call)

    delete aobj1;

    return 0;
}