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

    public void heapify(int arr[],int n,int i){
        int largest=i;
        int left=2*i;
        int right=2*i+1;
        if(left<=n && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<=n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr,n,largest);
        } 
    }

    public void heapSort(int arr[],int n){
        int size=n;
        while(size>1){
            // step 1: swap
            int temp=arr[size];
            arr[size]=arr[1];
            arr[1]=temp;
            size--;

            // step 2: heapify
            heapify(arr,size,1);
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
        int arr[]={-1,54,53,55,52,50};
        int n=5;
        for(int i=n/2;i>0;i--){
            heap.heapify(arr,n,i);
        }
        System.out.println("Heapified array:");
        for(int i=1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //heapsort
        heap.heapSort(arr,n);
        System.out.println("Sorted array:");
        for(int i=1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //maxheap
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(2);
        System.out.println(pq.peek());
        
        pq.poll();
        System.out.println(pq.peek());
        //minheap
        PriorityQueue<Integer> p=new PriorityQueue<>();
        p.add(3);    
        p.add(4);
        p.add(1);
        p.add(2);
        System.out.println(p.peek());
        p.poll();
        System.out.println(p.peek());
    }
}