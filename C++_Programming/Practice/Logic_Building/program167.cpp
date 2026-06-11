#include<iostream>
using namespace std;

#pragma pack(1)     
class ArrayX
{
    private:
        int *Arr;              
        int iSize;

    public:
       // Parameterised Constructor with default argument
       ArrayX(int X = 5)
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
    ArrayX *aobj1 = new ArrayX();      // Parameterised Constructor
    ArrayX *aobj2 = new ArrayX(15);     // Parameterised Constructor

    // Logic (Function Call)

    delete aobj1;       
    delete aobj2;       
     
    return 0;
}