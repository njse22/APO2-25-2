package structures;

public class DobleNode<T> {

    private T data;
    private int index;
    private DobleNode<T> next;
    private DobleNode<T> previous;

    public DobleNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public DobleNode<T> getNext() {
        return next;
    }

    public void setNext(DobleNode<T> next) {
        this.next = next;
    }

    public DobleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DobleNode<T> previous) {
        this.previous = previous;
    }
}
