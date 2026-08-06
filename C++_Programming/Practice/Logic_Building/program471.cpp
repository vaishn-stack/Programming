#include<iostream>
using namespace std;

double Addition(double No1, double No2)
{
    double Ans;
    Ans = No1 + No2;
    return Ans;
}

int main()
{
    double value1 = 10.5, value2 = 11.2, Ret = 0.0;

    Ret = Addition(value1,value2);
    cout << "Addition is : " << Ret << "\n";

    return 0;
}