// Singly Circular LL in c++

#include <iostream>
using namespace std;

# pragma pack(1)
template<class T>
struct node
{
    T data;
    struct node<T> *next;
};

template<class T>
class SinglyCL
{
    private:
        node<T> *first;
        node<T> *last;
        int iCount;

        public:
            SinglyCL();

    void Display();
    int Count();

    void InsertFirst(T iNo);
    void InsertLast(T iNo);
    void InsertAtPos(T iNo, int iPos);

    void DeleteFirst();
    void DeleteLast();
    void DeleteAtPos(int iPos);
};

template<class T>
SinglyCL<T> :: SinglyCL()
{
    cout << "Inside Constructor";
    this -> first = NULL;
    this -> last = NULL;
    this -> iCount = 0;
}

template<class T>
void SinglyCL<T> :: Display()
{
    node<T> *temp = NULL;
    temp = first;

    if(first == NULL && last == NULL)
    {
        return;
    }

    do
    {
        cout << "| " << temp -> data << " | ->" ;
        temp = temp -> next;

    }  while(temp != last->next);

    cout << "\n";
}

template<class T>
int SinglyCL<T> :: Count()
{
    return iCount;
}

template<class T>
void SinglyCL<T> :: InsertFirst(T iNo)
{
    node<T> *newn = NULL;
    newn = new node<T>;

    newn -> data = iNo;
    newn -> next = NULL;

    if(first == NULL && last == NULL)
    {
        first = newn;
        last = newn;
    }
    else
    {
        newn -> next = first;
        first = newn;
    }

    last -> next = first;
    iCount++;   
}

template<class T>
void SinglyCL<T> :: InsertLast(T iNo)
{
    node<T> *newn = NULL;
    newn = new node<T>;

    newn -> data = iNo;
    newn -> next = NULL;

    if(first == NULL && last == NULL)
    {
        first = newn;
        last = newn;
    }
    else
    {
        last -> next = newn;
        last = newn;
    }

    last -> next = first;
    iCount++;   
}

template<class T>
void SinglyCL<T> :: InsertAtPos(T iNo, int iPos)
{
    node<T> *newn = NULL; 
    node<T> *temp = NULL;

    int i = 0;

    newn = new node<T>;

    newn -> data = iNo;
    newn -> next = NULL;

    if((iPos < 1) || (iPos > this -> iCount + 1))
    {
        cout<<"Invalid Position"<<endl;
        return;
    }

    if(iPos == 1)
    {
        this -> InsertFirst(iNo);
        return;
    }
    else if(iPos == this -> iCount + 1)
    {
        this -> InsertLast(iNo);
        return;
    }
    else
    {
        temp = first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn;

        last -> next = first;
    }
    iCount++;
}

template<class T>
void SinglyCL<T> :: DeleteFirst()
{
    node<T> *temp = first;

    if(first == NULL && last == NULL)
    {
        return;
    }
    else if(first == last)
    {
        delete first;
        first = NULL;
        last = NULL;
    }
    else
    {
        first = first -> next;
        delete temp;
    }
    last -> next = first;
    iCount--;
}

template<class T>
void SinglyCL<T> :: DeleteLast()
{
    node<T> *temp = NULL;

    if(first == NULL && last == NULL)
    {
        return;
    }
    else if(first == last)
    {
        delete first;
        first = NULL;
        last = NULL;
    }
    else
    {
        temp = first;
        while(temp -> next != last)
        {
            temp = temp -> next;
        }
        delete last;
        last = temp;
    }
    last -> next = first;
    iCount--;
}

template<class T>
void SinglyCL<T> :: DeleteAtPos(int iPos)
{
    int i = 0;
    node<T> *temp = NULL;
    node<T> *target = NULL;

    if((iPos < 1) || (iPos > iCount))
    {
        cout<<"Invalid Position"<<endl;
        return;
    }

    if(iPos == 1)
    {
        this -> DeleteFirst();
        return;
    }
    else if(iPos == iCount)
    {
        this -> DeleteLast();
        return;
    }
    else
    {
        temp = first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }
        target = temp -> next;
        temp -> next = target -> next;

        delete target;
        last -> next = first;
    }
    iCount--;
}

int main()
{
    SinglyCL<int> sobj;

    int iRet = 0;

    sobj.InsertFirst(51);
    sobj.InsertFirst(21);
    sobj.InsertFirst(11);

    sobj.InsertLast(101);
    sobj.InsertLast(111);
    sobj.InsertLast(121);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.InsertAtPos(105,4);

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.DeleteFirst();

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.DeleteLast();

    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    sobj.DeleteAtPos(4);
    sobj.Display();
    iRet = sobj.Count();
    cout<<"Number of nodes are : "<< iRet <<endl;

    return 0;
}

// while and for loop entry checking loop
// do while() - exit checking loop