#include<iostream>
using namespace std;


int Maximum(int No1, int No2)
{
    if(No1 > No2)
    {
        return No1;
    }
    else
    {
        return No2;
    }
}

int main()
{
    cout << Maximum(21,11) << "\n";

    return 0;
}