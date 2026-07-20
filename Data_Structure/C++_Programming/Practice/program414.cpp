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

    int i = 0;

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

        for(i = 1; i < iPos - 1; i++)
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

int main()
{
    SinglyLL sobj;

    int iChoice = 0;
    int iValue = 0;
    int iRet = 0;
    int iPosition = 0;

    while(iChoice != 9)
    {
        cout << "---------------------------------------------------\n";
        cout << "Enter your choice \n";
        cout << "---------------------------------------------------\n";
        cout << "1. Insert node at First Position\n";
        cout << "2. Insert node at Last Position\n";
        cout << "3. Insert node at Given Position\n";
        cout << "4. Delete node at First Position\n";
        cout << "5. Delete node at Last Position\n";
        cout << "6. Delete node at Given Position\n";
        cout << "7. Display the elements\n";
        cout << "8. Count the number of elements\n";
        cout << "9. Terminate the Application\n";
        cout << "---------------------------------------------------\n";

        cin >> iChoice;

        switch(iChoice)
        {
            case 1:
                cout << "Enter the value : ";
                cin >> iValue;
                sobj.InsertFirst(iValue);
                sobj.Display();
                break;

            case 2:
                cout << "Enter the value : ";
                cin >> iValue;
                sobj.InsertLast(iValue);
                sobj.Display();
                break;

            case 3:
                cout << "Enter the value : ";
                cin >> iValue;

                cout << "Enter the Position : ";
                cin >> iPosition;

                sobj.InsertAtPos(iValue, iPosition);
                sobj.Display();
                break;

            case 4:
                sobj.DeleteFirst();
                sobj.Display();
                break;

            case 5:
                sobj.DeleteLast();
                sobj.Display();
                break;

            case 6:
                cout << "Enter the Position : ";
                cin >> iPosition;

                sobj.DeleteAtPos(iPosition);
                sobj.Display();
                break;

            case 7:
                cout << "Elements of Linked List are :\n";
                sobj.Display();
                break;

            case 8:
                iRet = sobj.Count();
                cout << "Number of Elements are : " << iRet << endl;
                break;

            case 9:
                cout << "Thank you for using Marvellous Infosystems Application.\n";
                break;

            default:
                cout << "Invalid Choice\n";
                break;
        }
    }

    return 0;
}