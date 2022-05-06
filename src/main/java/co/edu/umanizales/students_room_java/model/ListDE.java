package co.edu.umanizales.students_room_java.model;

import lombok.Data;
import java.util.ArrayList;

@Data
public class ListDE {
    private NodeDE head;
    private int count;


    public void addToStart(Pet pet) {
        if (head == null) {
            head = new NodeDE(pet);

        } else {
            NodeDE newNodeDE = new NodeDE(pet);
            newNodeDE.setNext(head);
            head.setPrevious(newNodeDE);
            head = newNodeDE;
        }
        count++;
    }

    public void add(Pet pet) {
        if (this.head == null) {
            this.head = new NodeDE(pet);
        } else {
            NodeDE temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            //parado en el ultimo
            temp.setNext(new NodeDE(pet));
            temp.getNext().setPrevious(temp);

        }
        count++;
    }
    public void addToPosition(int position, Pet pet) throws Exception
    {
        if(position>0 && position <= this.count+1)
        {
            if (position ==1) {
                this.addToStart(pet);
            }
            else
            {
                NodeDE temp = head;
                int count =1;
                while(temp != null)
                {
                    if(count==position -1)
                    {
                        NodeDE newNodeDE = new NodeDE(pet);
                        newNodeDE.setNext(temp.getNext());
                        temp.setNext(newNodeDE);
                        temp.getNext().setPrevious(temp);
                        this.count++;
                        break;
                    }
                    temp=temp.getNext();
                    count++;
                }
            }
        }
        else
        {
            throw new Exception("la posicion no es valida");
        }
    }
    public void deleteToPosition(int position) throws Exception
    {
        if(position>0 && position <= this.count)
        {
            if (position==1)
            {
                this.head = this.head.getNext();
                this.count--;
            }
            else
            {
                NodeDE temp = head;
                int count =1;
                while(temp != null)
                {
                    if(count == position -1)
                    {
                        temp.setNext(temp.getNext().getNext());
                        temp.getNext().setPrevious(temp);
                        this.count--;
                        break;
                    }
                    temp = temp.getNext();
                    count++;
                }
            }
        }
        else
        {
            throw new Exception("La posición no es válida");
        }
    }
    public void invert() {
        if (this.head!=null )
        {

            ListDE listCp = new ListDE();
            NodeDE temp=this.head;
            while (temp!= null)
            {
                listCp.addToStart(temp.getData());
                temp=temp.getNext();
                temp.setNext(temp.getNext().getNext());
                temp.getNext().setPrevious(temp);

            }
            this.head=listCp.head;
        }
    }
}