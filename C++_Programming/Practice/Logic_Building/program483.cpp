#include<iostream>
using namespace std;

void Display(double Arr[], int Size)
{
    int i = 0;

    for(i = 0; i < Size; i++)
    {
        cout << Arr[i] << "\n";
    }
}

double Summation(double Arr[], int Size)
{
    double sum = 0.0;
    int i = 0;

    for(i = 0; i < Size; i++)
    {
        sum = sum + Arr[i];
    }

    return sum;
}

int main()
{
    double Brr[] = {10.2,20.2,30.2,40.2,50.2};

    Display(Brr,5);

    cout << Summation(Brr,5) << "\n";

    return 0;
}