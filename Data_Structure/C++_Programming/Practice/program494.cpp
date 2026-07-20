# include<iostream>
using namespace std;

#pragma pack(1)

template <class T>

struct node
{
    T data;
    struct node<T> *next;
};

template <class T>

class SinglyLL
{
    private:            // Abstraction
        node<T> *first;
        int iCount;

        public:
            SinglyLL();     // declaration

    void Display();

    int Count();

    void InsertFirst(T iNo);

    void InsertLast(T iNo);

    void InsertAtPos(T iNo, int iPos);

    void DeleteFirst();

    void DeleteLast();

    void DeleteAtPos(int iPos);
};

template <class T>
SinglyLL<T> :: SinglyLL()            // definition  
{
    this -> first = NULL;
    this -> iCount = 0;
}

template <class T>
void SinglyLL<T> :: Display()
{
    node<T> *temp = NULL;
    temp = this -> first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " | ->" ;
        temp = temp -> next;
    }
    cout << "NULL" << endl; 
}

template <class T>
int SinglyLL<T> :: Count()
{
    return this -> iCount;
}
   
template <class T>
void SinglyLL<T> :: InsertFirst(T iNo)
{
    node<T> *newn = NULL;

    newn = new node<T>;

    newn -> data = iNo;
    newn -> next = NULL;

    if(this -> first == NULL)
    {
        this -> first = newn;
    }
    else
    {
        newn -> next = this -> first;
        this -> first = newn;
    }

    this -> iCount++;       // Important
}

template <class T>
void SinglyLL<T> :: InsertLast(T iNo)
{
    node<T> *newn = NULL;
    node<T> *temp = NULL;

    newn = new node<T>;

    newn -> data = iNo;
    newn -> next = NULL;

    if(this -> first == NULL)
    {
        this -> first = newn;
    }
    else
    {
        temp = this -> first;

        while(temp -> next != NULL)
        {
            temp = temp -> next;
        }
        temp -> next = newn;
    }
    this -> iCount++;
}

template <class T>
void SinglyLL<T> :: InsertAtPos(T iNo, int iPos)
{
    int i = 0;

    node<T> *newn = NULL;
    node<T> *temp = NULL;

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
    }
    else if(iPos == this -> iCount + 1)
    {
        this -> InsertLast(iNo);
    }
    else
    {
        temp = this -> first;

        for(i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn;

        this -> iCount++;
    }
}

template <class T>
void SinglyLL<T>::DeleteFirst()
{
    node<T> *temp = NULL;

    if(first == NULL)
    {
        return;
    }
    else if(first->next == NULL)
    {
        delete first;
        first = NULL;
    }
    else
    {
        temp = first;
        first = first->next;
        delete temp;
    }

    iCount--;
}

template <class T>
void SinglyLL<T>::DeleteLast()
{
    node<T> *temp = first;

    if(first == NULL)
    {
        return;
    }
    else if(first->next == NULL)
    {
        delete first;
        first = NULL;
    }
    else
    {
        while(temp->next->next != NULL)
        {
            temp = temp->next;
        }

        delete temp->next;
        temp->next = NULL;
    }

    iCount--;
}

template <class T>
void SinglyLL<T>::DeleteAtPos(int iPos)
{
    node<T> *temp = NULL;
    node<T> *target = NULL;

    if((iPos < 1) || (iPos > this -> iCount))
    {
        cout<<"Invalid Position"<<endl;
        return;
    }

    if(iPos == 1)
    {
        this -> DeleteFirst();
    }
    else if(iPos == this -> iCount)
    {
        this -> DeleteLast();
    }
    else
    {
        temp = this -> first;

        int i = 0;

        for( i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        target = temp -> next;
        temp -> next = target -> next;

        delete target;

        this -> iCount--;
    }
}



// Main
int main()
{
    SinglyLL<int> sobj;
    int iRet = 0;

    sobj.InsertFirst(51);
    sobj.InsertFirst(21);
    sobj.InsertFirst(11);

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Count : "<<iRet<<endl;

    sobj.InsertLast(101);
    sobj.InsertLast(111);
    sobj.InsertLast(121);

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Count : "<<iRet<<endl;

    sobj.DeleteFirst();

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Number of nodes : "<<iRet<<endl;

    sobj.DeleteLast();

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Number of nodes : "<<iRet<<endl;

    sobj.InsertAtPos(105,4);

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Number of nodes : "<<iRet<<endl;

    sobj.DeleteAtPos(4);
    sobj.Display();

    iRet = sobj.Count();
    cout<<"Number of nodes : "<<iRet<<endl;


    return 0;
}