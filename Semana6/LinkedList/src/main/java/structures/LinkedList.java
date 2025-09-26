package structures;

public class LinkedList {
    private Node first;

    public LinkedList(){

    }

    public boolean delete(String goal){
        boolean deleted = false;
        // Caso Base eliminar de una lista vacia
        if(first == null){
            deleted = false;
        }
        // Caso Base eliminar el primero de la lista
        else if(first.getData().equals(goal)){
            first = first.getNext();
            deleted = true;
        }
        // Caso Recursivo eliminar cualquier otro elemento
        else {
            deleted = delete(first, first.getNext(), goal);
        }
        return deleted;
    }

    private boolean delete(Node previous, Node current, String goal){
        boolean deleted = false;
        if(current != null && current.getData().equals(goal)){
            previous.setNext(current.getNext());
            current.setNext(null);
            deleted = true;
        }
        else if(current != null) {
            deleted =delete(current, current.getNext(), goal);
        }
        return deleted;
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


    public Node search(String goal){
        String msj = "";
        Node current = first;
        Node found = null;
        while (current != null && found == null){
            if (current.getData().equals(goal)){
                found = current;
            }
            msj += current.getData() + " ,";
            current = current.getNext();
        }
        return found;
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
