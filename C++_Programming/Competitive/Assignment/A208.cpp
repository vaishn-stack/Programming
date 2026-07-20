#include<iostream>
using namespace std;

template<class T>
int FirstOcc(T Arr[], int iSize, T Value)
{
    int i = 0;
    
    for(i = 0; i < iSize; i++)
    {
        if(Arr[i] == Value)
        {
            return i;
        }
    }

    return -1;
}

int main()
{
    int Arr[] = {10,20,30,40,20,50};

    int iRet = FirstOcc(Arr,6,20);

    if(iRet == -1)
    {
        cout<<"Element not found"<<endl;
    }
    else
    {
        cout<<"First occurrence is : "<<iRet<<endl;
    }

    return 0;
}