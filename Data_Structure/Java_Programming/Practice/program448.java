class node
{
    public int data;
    public node next;
}

public class program448
{
    public static void main(String[] args) 
    {
        node head = null;

        node obj1 = null;
        node obj2 = null;
        node obj3 = null;

        obj1 = new node();
        obj2 = new node();
        obj3 = new node();

        obj1.data = 11;
        obj2.data = 21;
        obj3.data = 51;
        
        obj1.next = obj2;
        obj2.next = obj3;
        obj3.next = null;

        head = obj1;

        node temp = head;

        System.out.println(temp.data);

        temp = temp.next;
        System.out.println(temp.data);

        temp = temp.next;
        System.out.println(temp.data);

        temp = temp.next;

    }
}