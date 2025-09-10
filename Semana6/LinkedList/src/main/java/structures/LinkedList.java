package structures;

public class LinkedList {
    private Node first;

    public LinkedList(){

    }


    public void add(String data){
        Node node = new Node(data);
        // Caso base: La lista esta vacia
        if(first == null){
            first = node;
        }
        else {
            if (first.getNext() == null){
                first.setNext(node);
                first.getNext().setIndex(1);
            }
            else {
                Node current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
                current.getNext().setIndex(current.getIndex()+1);
            }
        }
    }


    public String printList(){
       String msj = "";
       Node current = first;
       while (current != null){
           msj += current.getData() + " ,";
           current = current.getNext();
       }
       return msj;
    }
}
