#include<iostream>
using namespace std;

#pragma pack(1)     // for padding reduce
class ArrayX
{
    public:
        int *Arr;               // Arr[] --> *Arr
        int iSize;

        // Parameterised Constructor
        ArrayX(int X)
        {
            cout<<"Inside Constructor\n";

            iSize = X;                  // Characteristics initialisation
            Arr = new int(iSize);       // Resource Allocation
        }

        // Destructor
        ~ArrayX()
        {
            cout<<"Inside Destructor\n";

            delete []Arr;               // Resource Deallocation - pointer is pointed to array
        }
};

int main()
{
    // Dyanmic memory Allocation for object
    //ArrayX aobj1(5);                  // Default        
    
    ArrayX *aobj1 = new ArrayX(5); // * vaprla karan new chi return value as pointer       

    delete aobj1;

    cout<<"End of Main\n";

    return 0;
}