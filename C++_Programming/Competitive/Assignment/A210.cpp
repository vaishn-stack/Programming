#include<iostream>
using namespace std;

template<class T>
void Reverse(T Arr[], int iSize)
{
    int iStart = 0;
    int iEnd = iSize - 1;

    while(iStart < iEnd)
    {
        T Temp;

        Temp = Arr[iStart];
        Arr[iStart] = Arr[iEnd];
        Arr[iEnd] = Temp;

        iStart++;
        iEnd--;
    }
}

int main()
{
    int Arr[] = {10,20,30,40,50};

    Reverse(Arr,5);

    cout<<"Array after reverse : "<<endl;

    int i = 0;

    for(i = 0; i < 5; i++)
    {
        cout<<Arr[i]<<"\t";
    }

    cout<<endl;

    return 0;
}