class node
{
    public int data;
    public node next;

    node(int no)
    {
        this.data = no;
        this.next = null;
    }
}

class SinglyLL
{
    private node first;
    private int iCount;

    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void Display()
    {
        node temp = first;

        while(temp != null)
        {
            System.out.print("| " +  temp.data + " | -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int ino)
    {
        node newn = new node(ino);

        newn.data = ino;
        newn.next = null;

        if(first == null)
        {
            this.first = newn;
        }
        else
        {
            newn.next = this.first;
            this.first = newn;
        }
        iCount++;
    }

    public void InsertLast(int ino)
    {
        node newn = new node(ino);

        newn.data = ino;
        newn.next = null;

        if(first == null)
        {
            this.first = newn;
        }
        else
        {
            node temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        iCount++;
    }
   
    public void InsertAtPos(int ino, int iPos)
    {
        node newn = new node(ino);
        node temp = null;

        int i = 0;

        newn.data = ino;
        newn.next = null;

        if((iPos < 1) || (iPos > iCount + 1))
        {
            System.out.println("Invalid Position\n");
            return;
        }

        if(iPos == 1)
        {
            InsertFirst(ino);
        }
        else if(iPos == iCount + 1)
        {
            InsertLast(ino);
        }
        else
        {
            temp = first;

            for(i = 1; i < iPos - 1; i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;
        }
        iCount++;
    }

    public void DeleteFirst()
    {
        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            first = first.next;
        }
        iCount--;
    }

    public void DeleteLast()
    {

        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            node temp = first;
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        node temp = first;

        int i = 0;

        if((iPos < 1) || (iPos > iCount))
        {
            System.out.println("Invalid Position\n");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            for(i = 1; i < iPos - 1; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;

        }
        iCount--;
    }

}

public class program457
{
    public static void main(String[] args) 
    {
        SinglyLL sobj = new SinglyLL();

        int iRet = 0;

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);

        sobj.InsertLast(101);
        sobj.InsertLast(111);
        sobj.InsertLast(121);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Number of nodes are :" + iRet);

        sobj.DeleteFirst();

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Number of nodes are :" + iRet);

        sobj.DeleteLast();

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Number of nodes are :" + iRet);

        sobj.InsertAtPos(105,4);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Number of nodes are :" + iRet);

        sobj.DeleteAtPos(4);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Number of nodes are :" + iRet);
    }
}

/*-
    ---------------------------------------------------------------------------------------------------------------------------------------------
                            SinglyLL             SinglyCL               DoublyLL                DoublyCL            Stack           Queue
    ---------------------------------------------------------------------------------------------------------------------------------------------
    C                         Done                 Done                   Done                    Done                 --            --
    C++                       Done                 Done                   Done                    Done                 --            --
    Java                      Done                 Done                   Done                    Done                 --            --
    C++ generic                --                   --                     --                      --                  --            --


*/