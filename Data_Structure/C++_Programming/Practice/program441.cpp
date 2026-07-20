#include <iostream>
using namespace std;

#pragma pack(1)
struct node
{
    int data;
    struct node* next;
    struct node* prev;
};

typedef struct node NODE;
typedef struct node* PNODE;

#pragma pack(1)
class DoublyCL
{
    private:
        PNODE first;
        PNODE last;
        int iCount;

    public:
        DoublyCL();

};

int main()
{
    DoublyCL dobj;

    cout << sizeof(dobj) << "\n";
    return 0;
}