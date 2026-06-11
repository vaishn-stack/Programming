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
        
        }

        // Default Constructor
        ArrayX()
        {
          
        }
};

int main()
{
    ArrayX aobj1;                  // Default        
    ArrayX aobj2(5);               // Parameterised

    cout<<sizeof(aobj)<<endl;       // 12 bytes

    return 0;
}