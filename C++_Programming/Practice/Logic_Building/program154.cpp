#include<iostream>
using namespace std;

#pragma pack(1)     // for padding reduce
class ArrayX
{
    public:
        int *Arr;               // Arr[] --> *Arr
        int iSize;
};

int main()
{
    ArrayX aobj;

    cout<<sizeof(aobj)<<endl;       // 12 bytes

    return 0;
}