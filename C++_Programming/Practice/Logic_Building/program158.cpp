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

            delete []Arr;               // Resource Deallocation
        }
};

int main()
{
    ArrayX aobj1(5);                  // Default - auto storage class     
    
    cout<<sizeof(aobj1)<<endl;       

    return 0;
}