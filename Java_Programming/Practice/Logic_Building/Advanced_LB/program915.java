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
            System.out.print("|" + temp.data + "| ->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public boolean CheckLoop()
    {
        boolean bFlag = false;

        node fast = null;
        node slow = null;

        fast = first;
        slow = first;

        while((fast != null) && (fast.next != null)) 
        { 
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
            {
                bFlag = true;
                break;
            }
        }

        return bFlag;
    }

    public boolean CheckLoopX()
    {
        int iCnt = 0;
        node temp = first;
        boolean bFlag = false;

        // 100 --> 200 --> 300 --> 400
        // iCount = 4

        iCnt = 0;

        while(temp != null)
        {
            iCnt++;

            if(iCnt > iCount)
            {
                bFlag = true;
                break;
            }
            temp = temp.next;
        }

        return bFlag;
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


}

public class program915
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
        sobj.InsertLast(121);
        sobj.InsertLast(151);

        node temp1 = null;
        node temp2 = null;

        temp1 = sobj.first;
        temp2 = sobj.first;

        temp1 = temp1.next.next;
       
        while(temp2.next != null)
        {
            temp2 = temp2.next;
        }

        // loop generation
       // temp2.next = temp1;
    
        if(sobj.CheckLoopX() == true)
        {
            System.out.println("Loop detected");
        }
        else
        {
            System.out.println("There is no loop");
        }
    }
}


// rabbit tortoise algorithm
//  last element chya next la new node add kraycha ae using temp