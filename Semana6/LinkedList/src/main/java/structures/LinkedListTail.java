package structures;

public class LinkedListTail<T> {

    private DobleNode<T> first;
    private DobleNode<T> tail;

    public void add(T data){
        DobleNode<T> node = new DobleNode<>(data);
        // Caso base: La lista esta vacia
        if(first == null){
            first = node;
            tail = node;
        }
        else {
            if (first.getNext() == null){
                first.setNext(node);
                first.getNext().setIndex(1);
                node.setPrevious(first);
                tail = node;
            }
            else {
                tail.setNext(node);
                node.setPrevious(tail);
                tail = node;
            }
        }
    }

    public boolean delete(int idx){
        boolean isDeleted = false;

        DobleNode<T> current = first;
        while (current.getNext() != first){
            if (current.getIndex() == idx){
               current.getPrevious().setNext(current.getNext());
               current.getNext().setPrevious(current.getPrevious());
               current.setPrevious(null);
               current.setNext(null);
               current  = null;
            }
            current = current.getNext();
        }
        return isDeleted;
    }

    public String printList(){
        String msj = "";
        DobleNode<T> current = first;
        while (current.getNext() != first){
            msj += current.getData() + " ,";
            current = current.getNext();
        }
        msj += current.getData();
        return msj;
    }
}
