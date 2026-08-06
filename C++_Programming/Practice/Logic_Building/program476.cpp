#include<iostream>
using namespace std;

float Maximum(float No1, float No2)
{
    //(No1 > No2) ? No1 : No2;
    float Ans;
    
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

    return 0;
}