#include<iostream>
using namespace std;

template <class X>

X Maximum(X No1, X No2, X No3)
{
    X Ans;
    
    if(No1 > No2 && No1 > No3)
    {
       return No1;
    }
    else if(No2 > No1 && No2 > No3)
    {
        return No2;
    }
    else
    {
        return No3;
    }

}

int main()
{
    cout << Maximum(21.5f,11.2f,51.5f) << "\n";
    cout << Maximum(21,11,51) << "\n";
    cout << Maximum(21.5,11.2,10.5) << "\n";

    return 0;
}