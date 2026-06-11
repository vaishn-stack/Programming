#include<iostream>
using namespace std;

class ArrayX
{
    public:
        int *Arr;               // Arr[] --> *Arr
        int iSize;
};

int main()
{
    ArrayX aobj;

    cout<<sizeof(aobj)<<endl;       // 16 bytes

    return 0;
}