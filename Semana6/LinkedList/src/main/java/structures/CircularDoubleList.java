package structures;

public class CircularDoubleList <T> {

    private DobleNode<T> first;

    public void add(T data){
        DobleNode<T> node = new DobleNode<>(data);
        // Caso base: La lista esta vacia
        if(first == null){
            first = node;
            first.setNext(node);
            first.setPrevious(node);
        }
        else {
            if (first.getNext() == first){
                first.setNext(node);
                first.getNext().setIndex(1);
                node.setNext(first);
                node.setPrevious(first);
                first.setPrevious(node);
            }
            else {
                DobleNode<T> current = first.getNext();
                while (current.getNext() != first){
                    current = current.getNext();
                }
                current.setNext(node);
                current.getNext().setIndex(current.getIndex()+1);
                node.setNext(first);

                node.setPrevious(current);
                first.setPrevious(node);
            }
        }
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
