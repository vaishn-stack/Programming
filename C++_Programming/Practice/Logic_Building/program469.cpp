#include<iostream>
using namespace std;

int Addition(int No1, int No2)
{
    int Ans;
    Ans = No1 + No2;
    return Ans;
}

int main()
{
    int value1 = 10, value2 = 11, Ret = 0;

    Ret = Addition(value1,value2);
    cout << "Addition is : " << Ret << "\n";

    return 0;
}