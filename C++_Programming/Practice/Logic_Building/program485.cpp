#include <iostream>
using namespace std;

class ArrayX
{
    public:
        int *Arr;
        int Size;

        ArrayX(int No)
        {
            Size = No;
            Arr = new int[Size];
        }

        ~ArrayX()
        {
            delete []Arr;
        }
};

int main()
{
    ArrayX aobj(5);

    return 0;
}