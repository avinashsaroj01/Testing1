public class DLL{
      private int size;
      private Node head;
      private Node tail;


      private class Node{
          private int value;
          private Node prev;
          private Node next;

          public Node(int value){
            this.value = value;

          }
      }

      // insert from the beginning.
      public void insertFirst(int value){
        Node node = new Node(value);
        if(head==null){
           head= node;
           tail= node;
           }
            else{
            node.next = head;
            head.prev= node;
            head = node;
            }
          
          size++;

           
      }

            // insert from the END
            public void insertEnd(int value){

                if (head==null) {
                  insertFirst(value);
                }
                 else{
                   Node node = new Node(value);
                   tail.next = node;
                   node.prev = tail;
                   tail = node;

                 }
                 size++;
            }
            // insert at paticular index.
            public void insertAt(int value ,int index){
                
                 if (head== null || index ==0) {
                  insertFirst(value);
                 }
                     
                 else if (index==size) {
                   insertEnd(value);
                 }
                 else{

                    Node node= new Node(value);
                    Node temp = head;
                    int i=1;
                    while (i<index) {
                       temp= temp.next;
                       i++;
                    }
                    Node temp1= temp.next;
                    temp.next = node;
                    node.prev = temp;
                    node.next = temp1;
                    temp1.prev = node;
                 }
                 size++;
            }
            
            //Delete from the begining.
            public void delteFirst(){
                if (head==null) {
                  return;
                }

                head= head.next;
                head.prev= null;
                size--;
            }
            // Delete from the end
            public void deleteEnd(){
              if (head==null) {
                return;
              }
              else{
                  tail = tail.prev;
                  tail.next = null;
                }
                size--;
            }
            // delete at particular index
          public void deleteAt(int index) {
    if (index < 0 || index >= size) {
        System.out.println("Invalid index");
        return;
    }

    if (index == 0) {
        delteFirst(); // Delete the first node
    } else if (index == size - 1) {
        deleteEnd(); // Delete the last node
    } else {
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        Node delete = temp.next; 
        Node after = delete.next; 

        temp.next = after; 
        if (after != null) { // Ensure after is not null before accessing its prev field
            after.prev = temp; 
        }
        size--;
    }
}
           
            // Reverse a doubly linkedList.
            


           //Display
            public void display(){
        if(head==null){
          System.out.println("List is empty....");
          return;
        }
        
        Node temp = head;
        while(temp!=null){
                 
                 System.out.print(temp.value+"<->");
                 temp= temp.next;
            }
            System.out.println("END");
            return;
      }

      public static void main(String[] args){

        DLL list = new  DLL();
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        // list.insertAt(100, 2);
        
        list.display();
        // list.delteFirst();
        // list.deleteEnd();
        list.deleteAt(4);
        list.display();
      }
}