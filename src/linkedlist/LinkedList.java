package linkedlist;

public class LinkedList<E> {
        private DblListnode<E> head;
        private DblListnode<E> last;
        private int numNodes;

        public LinkedList(DblListnode head) {
            this.head = head;
            this.last = head;
            numNodes = 1;
        }

        public int getNumNodes() {
            return numNodes;
        }

        public void addNodeToEnd(DblListnode toAdd) {
            DblListnode n = head;
            while(n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(toAdd);
            toAdd.setPrevious(n);
            this.last = toAdd;
            numNodes++;
        }

        public void addNodeToEnd(E data) {
            DblListnode toAdd = new DblListnode(data, null);
            addNodeToEnd(toAdd);
        }

        public void addNodeToFront(DblListnode node) {
            head.setPrevious(node);
            node.setNext(head);
            this.head = node;
            numNodes++;
        }

        public void addNodeToFront(E data) {
            DblListnode toAdd = new DblListnode(data, null);
            addNodeToFront(toAdd);
        }

        public boolean addNodeAfterData(DblListnode toAdd, E data) {
            DblListnode n = head;
            while(n.getNext() != null) {
                if(n.getData() == data) {
                    toAdd.setPrevious(n);
                    toAdd.setNext(n.getNext());
                    n.setNext(toAdd);
                    numNodes++;
                    return true;
                }
                n = n.getNext();
            }
            return false;
        }

        public boolean addNodeAfterData(E data, E dataSearch) {
            DblListnode toAdd = new DblListnode(data, null);
            return addNodeAfterData(toAdd, dataSearch);
        }

        public boolean addNodeAtIndex(int index, DblListnode toAdd) {
            if(((index - numNodes) > 1) || index < 0) {
                return false;
            }
            if(index == 0) {
                addNodeToFront(toAdd);
                return true;
            }
            int counter = 0;
            DblListnode n = head;
            while(n.getNext() != null) {
                n = n.getNext();
                counter++;
                if(counter == index) {
                    toAdd.setPrevious(n.getPrevious());
                    toAdd.setNext(n);
                    n.getPrevious().setNext(toAdd);
                    numNodes++;
                    return true;
                }
            }
            return false;
        }

        public boolean addNodeAtIndex(E data, int index) {
            DblListnode toAdd = new DblListnode(data, null);
            return addNodeAtIndex(index, toAdd);
        }

        public void printList() {
            DblListnode n = head;
            System.out.println("");
            while(n.getNext() != null) {
                System.out.print(n.getData());
                System.out.print(", ");
                n = n.getNext();
            }
            System.out.print(n.getData());
        }

        public boolean removeByData(E data) {
            DblListnode n = head;
            if(head.getData() == data) {
                this.head = head.getNext();
                this.head.setPrevious(null);
                numNodes--;
                return true;
            }
            while(n.getNext() != null) {
                if(n.getData() == data) {
                    n.getPrevious().setNext(n.getNext());
                    n.getNext().setPrevious(n.getPrevious());
                    numNodes--;
                    return true;
                }
                n = n.getNext();
            }
            return false;
        }

        public boolean removeByIndex(int index) {
            if(index < 0 || index > numNodes) {
                return false;
            }
            if(index == 0) {
                if(this.head.getNext() != null) {
                    this.head = head.getNext();
                    this.head.setPrevious(null);
                    numNodes--;
                    return true;
                } else {
                    return false;
                }
            }
            int counter = 0;
            DblListnode n = head;
            while(n.getNext() != null) {
                if(counter == index) {
                    n.getPrevious().setNext(n.getNext());
                    n.getNext().setPrevious(n.getPrevious());
                    numNodes--;
                    return true;
                }
                counter++;
                n = n.getNext();
            }
            return false;
        }

    }
