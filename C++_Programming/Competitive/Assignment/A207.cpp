#include<iostream>
using namespace std;

template<class T>
int Frequency(T Arr[], int iSize, T Value)
{
    int iCount = 0;
    int i = 0;

    for(i = 0; i < iSize; i++)
    {
        if(Arr[i] == Value)
        {
            iCount++;
        }
    }

    return iCount;
}

int main()
{
    int Arr[] = {10,20,30,10,40,10,50};

    int iRet = Frequency(Arr,7,10);

    cout<<"Frequency is : "<<iRet<<endl;

    return 0;
}