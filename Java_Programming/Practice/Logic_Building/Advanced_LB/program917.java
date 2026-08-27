class node
{
    public int data;
    public node next;

    public node(int no)
    {
        this.data = no;
        this.next = null;
    }
}


class SinglyLL
{
    public  node first;
    public  int iCount;

    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int iNo)
    {
        node newn = new node(iNo);
       
        newn.next = first;
        first = newn;
        
        iCount++;
    }

    public int Count()
    {
        return iCount;
    }

    public void Display()
    {
        node temp = null;

        temp = first;

        while(temp != null)
        {
            System.out.print("| " + temp.data + " | ->");
            temp = temp.next;
        }
        System.out.println(" null");
    }

    public void InsertLast(int iNo)
    {
        node newn = new node(iNo);
        node temp = first;

        if(first == null)
        {
            first = newn;
        }
        else
        {
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        iCount++;
    }

    public void ReverseLinkedList()
    {
        node Previous = null;
        node Current = null;
        node Next = null;

        if(first == null)
        {
            return;
        }

        Current = first;

        while(Current != null)
        {
            Next = Current.next;
            Current.next = Previous;
            Previous = Current;
            Current = Next;
        }

        first = Previous;
    }


}

public class program917
{
    public static void main(String A[])
    {
       // int iRet = 0;

        SinglyLL sobj = new SinglyLL();

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);

        sobj.InsertLast(101);
        sobj.InsertLast(111);
        
        sobj.Display();
        sobj.ReverseLinkedList();
        sobj.Display();
    }
}


// rabbit tortoise algorithm
//  last element chya next la new node add kraycha ae using temp