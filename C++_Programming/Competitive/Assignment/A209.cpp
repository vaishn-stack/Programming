#include<iostream>
using namespace std;

template<class T>
int LastOcc(T Arr[], int iSize, T Value)
{
    int iPos = -1;
    int i = 0;

    for(i = 0; i < iSize; i++)
    {
        if(Arr[i] == Value)
        {
            iPos = i;
        }
    }

    return iPos;
}

int main()
{
    int Arr[] = {10,20,30,40,20,50};

    int iRet = LastOcc(Arr,6,20);

    if(iRet == -1)
    {
        cout<<"Element not found"<<endl;
    }
    else
    {
        cout<<"Last occurrence is : "<<iRet<<endl;
    }

    return 0;
}