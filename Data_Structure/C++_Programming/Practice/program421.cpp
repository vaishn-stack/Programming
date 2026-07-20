#include<iostream>
using namespace std;

#pragma pack(1)

struct node
{
    int data;
    struct node *next;
    struct node *prev;          // $
};

typedef struct node NODE;
typedef struct node* PNODE;

class DoublyLL
{
    private:            
        PNODE first;
        int iCount;

        public:
            DoublyLL();         // $

    void Display();

    int Count();

    void InsertFirst(int iNo);

    void InsertLast(int iNo);

    void InsertAtPos(int iNo, int iPos);

    void DeleteFirst();

    void DeleteLast();

    void DeleteAtPos(int iPos);
};


DoublyLL :: DoublyLL()            
{
    this -> first = NULL;
    this -> iCount = 0;
}

void DoublyLL :: Display()
{
   PNODE temp = NULL;

    temp = this -> first;

    while(temp != NULL)
    {
        cout << "| " << temp -> data << " | <=> ";
        temp = temp -> next;
    }

    cout << "NULL" << endl;
}

int DoublyLL :: Count()
{
    return this -> iCount;
}
        
void DoublyLL :: InsertFirst(int iNo)
{
    PNODE newn = NULL;

    newn = new NODE;
 
    newn -> data = iNo;
    newn -> next = NULL;
    newn -> prev = NULL;        // $

    if(this -> first == NULL)
    {
        this -> first = newn;
    }
    else
    {
        newn -> next = this -> first;

        this -> first -> prev = newn;        // $

        this -> first = newn;
    }
    this -> iCount++;
}

void DoublyLL :: InsertLast(int iNo)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = new NODE;
 
    newn -> data = iNo;
    newn -> next = NULL;
    newn -> prev = NULL;        // $

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
        newn -> prev = temp;        // $
    }
    this -> iCount++;
}
void DoublyLL :: InsertAtPos(int iNo, int iPos)
{
    int i = 0;

    PNODE newn = NULL;
    PNODE temp = NULL; 

    newn = new NODE;

    newn -> data = iNo;

    if((iPos < 1) || (iPos > iCount + 1))
    {
        cout << "Invalid Position \n";
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

        newn -> next = NULL;
        newn -> prev = NULL;            // $

        for(int i = 1; i < iPos - 1; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next -> prev = newn;        // $
        temp -> next = newn;
        newn -> prev = temp;                // $

        this -> iCount++;
    }
}

void DoublyLL :: DeleteFirst()
{
    if(this -> first == NULL)
    {
        return;
    }
    else if(this -> first -> next == NULL)
    {
        delete this -> first;
        this -> first = NULL;
    }
    else
    {
        this -> first = this -> first -> next;

        delete this -> first -> prev;           // $
        this -> first -> prev = NULL;           // $

    }
    this -> iCount--;
}

void DoublyLL :: DeleteLast()
{
    PNODE temp = NULL;

    if(this -> first == NULL)
    {
        return;
    }
    else if(this -> first -> next == NULL)
    {
        delete this -> first;
        this -> first = NULL;
    }
    else
    {
        temp = this -> first;

        while(temp -> next -> next != NULL)
        {
            temp = temp -> next;
        }
        delete temp -> next;
        temp -> next = NULL;
    }
    this -> iCount--;
}

void DoublyLL :: DeleteAtPos(int iPos)
{
    PNODE temp = NULL;
    PNODE target = NULL;

    if((iPos < 1) || (iPos > iCount))
    {
        cout << "Invalid Position \n";
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
        target -> next -> prev = temp;    // $
        
        delete target;

        this -> iCount--;
    }
}

int main()
{
    DoublyLL dobj;

    int iChoice = 1;
    int iValue = 0;
    int iPosition = 0;
    int iRet = 0;


    while(iChoice != 9)
    {
        cout << "\n-------------------------------------\n";
        cout << " Doubly Linear Linked List\n";
        cout << "-------------------------------------\n";
        cout << "1. Insert First\n";
        cout << "2. Insert Last\n";
        cout << "3. Insert At Position\n";
        cout << "4. Delete First\n";
        cout << "5. Delete Last\n";
        cout << "6. Delete At Position\n";
        cout << "7. Display\n";
        cout << "8. Count the elements\n";
        cout << "9. Exit\n";
        cout << "-------------------------------------\n";
        cout << "Enter your choice : ";
        cin >> iChoice;

        switch(iChoice)
        {
            case 1:
                cout << "Enter the value: ";
                cin >> iValue;
                dobj.InsertFirst(iValue);
                break;

            case 2:
                cout << "Enter the value: ";
                cin >> iValue;
                dobj.InsertLast(iValue);
                break;

            case 3:
                cout << "Enter the value: ";
                cin >> iValue;
                cout << "Enter position : ";
                cin >> iPosition;
                dobj.InsertAtPos(iValue,iPosition);
                break;

            case 4:
                dobj.DeleteFirst();
                cout << "First node deleted successfully.\n";
                break;

            case 5:
                dobj.DeleteLast();
                cout << "Last node deleted successfully.\n";
                break;

            case 6:
                cout << "Enter position : ";
                cin >>  iPosition;
                dobj.DeleteAtPos( iPosition);
                break;

            case 7:
                cout << "\nLinked List is :\n";
                dobj.Display();
                break;

            case 8:
                cout << "Number of nodes are : "
                     << dobj.Count() << endl;
                break;

            case 9:
                cout << "Thank You for visiting Marvellous Infosystems Application\n";
                break;

            default:
                cout << "Invalid Choice...\n";
                break;
        }
    }

    return 0;
}

/*
    DoublyLL - doubly linear LinkedList in c++
 */