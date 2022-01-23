package linkedlist;

public class DblListnode<E> {
    //*** fields ***
    private DblListnode<E> previous;
    private E data;
    private DblListnode<E> next;

    //*** constructors ***
    public DblListnode(E d, DblListnode<E> previous) {
        this.data = d;
        this.next = null;
        this.previous = previous;
    }

    //*** methods ***
    // access to fields
    public E getData() {
        return data;
    }

    public DblListnode<E> getNext() {
        return next;
    }

    public DblListnode<E> getPrevious() {
        return previous;
    }

    // modify fields
    public void setData(E d) {
        data = d;
    }

    public void setNext(DblListnode<E> n) {
        next = n;
    }

    public void setPrevious(DblListnode<E> p) {
        previous = p;
    }


}