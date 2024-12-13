package de.szut.mylists;

public class MyArrayList {

    private int[] array;

    public MyArrayList() {
        this.array = new int[0];
    }

    public int size(){
        return this.array.length;
    }

    public void add(int value){
        int[] temp = this.array;
        this.array = new int[this.array.length + 1];
        for(int i = 0; i < temp.length; i++){
            this.array[i] = temp[i];
        }
        array[array.length - 1] = value;
    }

    public int get(int index){
        return this.array[index];
    }

    public void remove(int index){
        if(index < 0 || index >= this.array.length){
            throw  new RuntimeException("Dieser Index existiert nicht!");
        }
        int[] temp = this.array;
        this.array = new int[this.array.length - 1];
        int j = 0;
        for(int i = 0; i < temp.length; i++){
            if(i == index){
                continue;
            }
            this.array[j] = temp[i];
            j++;
        }
    }

    public boolean contains(int value){
        for(int i = 0; i < this.array.length; i++){
            if(this.array[i] == value){
                return true;
            }
        }
        return false;
    }

}
