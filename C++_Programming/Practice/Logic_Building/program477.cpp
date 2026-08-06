#include<iostream>
using namespace std;

float Maximum(float No1, float No2)
{
    float Ans;

    (No1 > No2) ? Ans = No1 : Ans = No2;            // ? ternary operator ((? -> if) & (: -> else))

    return Ans;
}

int main()
{
    cout << Maximum(21.5f,11.2f) << "\n";

    return 0;
}