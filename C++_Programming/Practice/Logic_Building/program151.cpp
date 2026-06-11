#include<iostream>
using namespace std;

class ArrayX
{
    // Access Specifier of Summation is Private --> error 
    int Summation(int Arr[], int iSize)
    {
        int iSum = 0;
        int iCnt = 0;

        for(iCnt = 0; iCnt < iSize; iCnt++)
        {
            iSum = iSum + Arr[iCnt];
        }

        return iSum;
    }
};

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0, iRet = 0;
    ArrayX aobj;    // object creation is Static

    cout << "Enter the Number of Elements : \n";
    cin >> iLength;

    Brr = new int[iLength];

    cout << "Enter the Elements : \n";

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        cin >> Brr[iCnt];
    }

    cout << "Elements of the Array are : \n";

    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        cout << Brr[iCnt] << endl;
    }

    iRet = aobj.Summation(Brr,iLength);

    cout << "Summation is : " << iRet << endl;

    delete []Brr;

    return 0;
}