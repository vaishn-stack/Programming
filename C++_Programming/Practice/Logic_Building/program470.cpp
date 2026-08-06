#include<iostream>
using namespace std;

float Addition(float No1, float No2)
{
    float Ans;
    Ans = No1 + No2;
    return Ans;
}

int main()
{
    float value1 = 10.5f, value2 = 11.2f, Ret = 0.0f;

    Ret = Addition(value1,value2);
    cout << "Addition is : " << Ret << "\n";

    return 0;
}