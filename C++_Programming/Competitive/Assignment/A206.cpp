#include<iostream>
using namespace std;

template<class T>
void Display(T Value, int iCount)
{
    int i = 0;
    
    for(i = 1; i <= iCount; i++)
    {
        cout<<Value<<"\t";
    }
    cout<<endl;
}

int main()
{
    Display('M',7);
    Display(11,5);
    Display(3.14,4);

    return 0;
}