#include<iostream>
using namespace std;

#pragma pack(1)     // for padding reduce
class ArrayX
{
    public:
        int *Arr;               // Arr[] --> *Arr
        int iSize;

        ArrayX(int X)
        {
            
        }
};

int main()
{
    ArrayX aobj(5);                  // object are naked          

    cout<<sizeof(aobj)<<endl;       // 12 bytes

    return 0;
}