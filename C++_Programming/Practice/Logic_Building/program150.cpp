#include<iostream>
using namespace std;

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

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0, iRet = 0;

    cout << "Enter the Number of Elements : \n";
    cin >> iLength;

    // C :    Brr = (int *) malloc (sizeof(int) * iLength);
    // java : Brr = new int[iLength];
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

    iRet = Summation(Brr,iLength);

    cout << "Summation is : " << iRet << endl;

    delete []Brr;

    return 0;
}