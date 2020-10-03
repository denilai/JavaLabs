package com.company;

public class Human {
// FIELDS
    Leg leg;
    Hand hand;
    Head head;
    String name;
// INTERNAL CLASSES
    class Leg{
        private int sizeOfFoot;

        Leg(int sizeOfFoot){

            this.sizeOfFoot = sizeOfFoot;
        }

        public void setSizeOfFoot(int sizeOfFoot) {
            this.sizeOfFoot = sizeOfFoot;
        }

        public int getSizeOfFoot() {
            return sizeOfFoot;
        }

    @Override
    public String toString() {
        return "\n\tLeg{" +
                "sizeOfFoot=" + sizeOfFoot +
                '}';
    }
}
    class Head{
        private int size;
        private String hair;
        Head(int size, String hair){

            this.size = size;
            this.hair = hair;
        }

        public void setHair(String hair) {
            this.hair = hair;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public String getHair() {
            return hair;
        }

        @Override
        public String toString() {
            return "\n\tHead{" +
                    "size=" + size +
                    ", hair='" + hair + '\'' +
                    '}';
        }
    }
    class Hand{

        private int size;

        Hand(int size){
            this.size = size;
        }

        public void setSize(int length) {
            this.size = length;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "\n\tHand{" +
                    "size=" + size +
                    '}';
        }
    }
// METHODS
    public Human(String name, int sizeOfFoot, int sizeOfHead, String hair, int sizeOfHand){
        leg = new Leg(sizeOfFoot);
        head = new Head(sizeOfHead,hair);
        hand = new Hand(sizeOfHand);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "\n\tname=" + name + head.toString()+
                    hand.toString()+
                    leg.toString()+
                "\n}";
    }

    public Hand getHand() {
        return hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public Head getHead() {
        return head;
    }


}
