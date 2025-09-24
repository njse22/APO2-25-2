package structures;

public class CircularList {

    private Node first;

    public void add(String data){
        Node node = new Node(data);
        // Caso base: La lista esta vacia
        if(first == null){
            first = node;
            first.setNext(node);
        }
        else {
            if (first.getNext() == first){
                first.setNext(node);
                first.getNext().setIndex(1);
                node.setNext(first);
            }
            else {
                Node current = first.getNext();
                while (current.getNext() != first){
                    current = current.getNext();
                }
                current.setNext(node);
                current.getNext().setIndex(current.getIndex()+1);
                node.setNext(first);
            }
        }
    }


    public String printList(){
        String msj = "";
        Node current = first;
        while (current.getNext() != first){
            msj += current.getData() + " ,";
            current = current.getNext();
        }
        msj += current.getData();
        return msj;
    }
}
