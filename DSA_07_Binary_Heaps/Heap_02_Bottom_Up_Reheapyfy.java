// Bottom-Up reheapyfy is generally used to insert the element into the heap...

class MaxPQ{
    private Integer[] heap;
    private int n;

    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];
        n = 0;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }
    private void resize(int capacity){
        // Creating a new array of double the size of previous arra heap...
        Integer[] temp = new Integer[capacity];
        // Copying all elements of heap into new array temp of double the size of heap...
        for(int i=0;i<heap.length;i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }
    
    public void insert(int x){
        if(n == heap.length-1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int k){
        while(k > 1 && heap[k/2] < heap[k]){
            int demo = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = demo;
            k = k/2;  // Returning to parent node and again analysing the heap....
        }
    }

    public void PrintHeap(){
        for(int i : heap){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}

public class Heap_02_Bottom_Up_Reheapyfy {
    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        System.out.println(pq.size());
    }
}
