package co.edu.umanizales.students_room_java.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ListSE {
    private Node head;

    public void add(Pet pet) {
     if(this.head==null)
     {
         this.head=new Node(pet);
     }
     else
     {
         Node temp=this.head;
         while(temp.getNext()!=null);
         {
             temp=temp.getNext();
         }
         //parado en el ultimo
         temp.setNext(new Node(pet));
     }

    }

    public void addToStart(Pet pet) {
     if(this.head==null)
     {
         this.head=new Node(pet);
     }
     else
     {
         Node temp= new Node(pet);
         temp.setNext(this.head);
         this.head=temp;
     }

    }

        public void invert() {
         if (this.head!=null )
         {

             ListSE listCp = new ListSE();
             Node temp=this.head;
             while (temp!=null);
             {
                 listCp.addToStart(temp.getData());
                 temp=temp.getNext();
             }
             this.head=listCp.head;
         }
    }
}
