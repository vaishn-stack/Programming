# include<iostream>
using namespace std;

#pragma pack(1)

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;

class SinglyLL
{
    private:            // Abstraction
        PNODE first;
        int iCount;

        public:
            SinglyLL();     // declaration

    void Display();

    int Count();

    void InsertFirst(int iNo);

    void InsertLast(int iNo);

    void InsertAtPos(int iNo, int iPos);

    void DeleteFirst();

    void DeleteLast();

    void DeleteAtPos(int iPos);
};


SinglyLL :: SinglyLL()            // definition  
{
    this -> first = NULL;
    this -> iCount = 0;
}

void SinglyLL :: Display()
{
    PNODE temp = NULL;
    temp = this -> first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " | ->" ;
        temp = temp -> next;
    }
    cout << "NULL" << endl; 
}

int SinglyLL :: Count()
{
    return this -> iCount;
}
        
void SinglyLL :: InsertFirst(int iNo)
{
    PNODE newn = NULL;

    newn = new NODE;

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

void SinglyLL :: InsertLast(int iNo)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = new NODE;

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

void SinglyLL :: InsertAtPos(int iNo, int iPos)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = new NODE;

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

        for(int i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn;

        this -> iCount++;
    }
}

// Delete First
void SinglyLL::DeleteFirst()
{
    PNODE temp = NULL;

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

// Delete Last
void SinglyLL::DeleteLast()
{
    PNODE temp = first;

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

// Delete At Position
void SinglyLL::DeleteAtPos(int iPos)
{
    PNODE temp = NULL;
    PNODE target = NULL;

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

        for(int i = 1; i < iPos - 1; i++)
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
    SinglyLL sobj;
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
    cout<<"Count : "<<iRet<<endl;

    sobj.DeleteLast();

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Count : "<<iRet<<endl;

    sobj.InsertAtPos(105,4);

    sobj.Display();

    iRet = sobj.Count();
    cout<<"Count : "<<iRet<<endl;

    sobj.DeleteAtPos(4);
    sobj.Display();

    iRet = sobj.Count();
    cout<<"Count : "<<iRet<<endl;


    return 0;
}