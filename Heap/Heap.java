import java.util.*;
public class Heap{
    public int []arr=new int[100];
    int size=0;

    void insert(int val){
        size=size+1;
        arr[size]=val;
        int index=size;
        while(index>1){
            int parent=index/2;
            if(arr[parent]<arr[index]){
                int temp=arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                index=parent;
            }
            else{
                return;
            }
        }
    }
    void delete(int val){
        if(size==0){
            System.out.println("Heap is empty");
            return;
        }
        arr[1]=arr[size];
        size--;

        // take the root node to its correct position
        int index=1;
        while(index<size){
            int left=2*index;
            int right=2*index+1;
            if(left<size && arr[left]>arr[index]){
                int temp=arr[left];
                arr[left]=arr[index];
                arr[index]=temp;
                index=left;
            }
            else if(right<size && arr[right]>arr[index]){
                int temp=arr[right];
                arr[right]=arr[index];
                arr[index]=temp;
                index=right;
            }
            else{
                return;
            }
        }
    }
    
    public void print(){
        for(int i=1;i<=size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.print();
        heap.delete(20);
        heap.print();
    }
}