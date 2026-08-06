#include<iostream>
using namespace std;

template <class X>

X Maximum(X No1, X No2)
{
    X Ans;
    
    if(No1 > No2)
    {
        Ans = No1;
    }
    else
    {
        Ans = No2;
    }

    return Ans;
}

int main()
{
    cout << Maximum(21.5f,11.2f) << "\n";
    cout << Maximum(21,11) << "\n";
    cout << Maximum(21.5,11.2) << "\n";

    return 0;
}