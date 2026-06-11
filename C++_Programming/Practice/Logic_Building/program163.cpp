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
    cout << aobj1 -> iSize << "\n";

    aobj1 -> iSize = 0; // risk factors loop madhe array chi size 0 hote
    aobj1 -> Arr = NULL; // loop madhe array chi size null ae - ISSUE

    delete aobj1;

    return 0;
}