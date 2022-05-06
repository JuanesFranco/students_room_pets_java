package co.edu.umanizales.students_room_java.model;

import lombok.Data;

@Data
public class ListDECircle {
    private NodeDE head;
    private int count;



    public void addToStart(Pet pet) {
        if (head == null) {
            head = new NodeDE(pet);
            head.setNext(head);
            head.setPrevious(head);

        } else {
            NodeDE temp = head.getPrevious();
            NodeDE newNodeDE = new NodeDE(pet);
            temp.setNext(newNodeDE);
            newNodeDE.setPrevious(temp);
            newNodeDE.setNext(head);
            head.setPrevious(newNodeDE);
            head = head.getPrevious();

        }
        count++;
    }

    public void add(Pet pet) {
        if (this.head == null) {
            this.head = new NodeDE(pet);
            head.setNext(head);
            head.setPrevious(head);
        } else {
            NodeDE temp = this.head.getPrevious();

        }
        count++;
    }

    public void addToPosition(int position, Pet pet) throws Exception {
        if (position > 0 && position <= this.count + 1) {
            if (position == 1) {
                this.addToStart(pet);
            } else {
                NodeDE temp = head;
                int count = 1;
                while (temp != null) {
                    if (count == position - 1) {
                        NodeDE newNodeDE = new NodeDE(pet);
                        newNodeDE.setNext(temp.getNext());
                        temp.setNext(newNodeDE);
                        temp.getNext().setPrevious(temp);
                        this.count++;
                        break;
                    }
                    temp = temp.getNext();
                    count++;
                }
            }
        } else {
            throw new Exception("la posicion no es valida");
        }
    }
}