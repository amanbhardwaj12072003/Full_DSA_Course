
// Top-Down reheapyfy is generally used to delete the maximum element from the heap...

class MaxPQ{
    private Integer[] heap;    // Array to store values of node of heap in level order format 
    private int n;            // Size of the heap
    
    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];
        n = 0;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int Size(){
        return n;
    }
    public void PrintHeap(){
        for(int i : heap){
            System.out.println(i + " ");
        }
        System.out.println("");
    }

    // Algorithm to insert an element in the heap

    public void Insert(int x){
        if(n == (heap.length-1)){
            Resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        Swim(n);
    }

    public void Swim(int k){
        while(k>1 && (heap[k/2] < heap[k])){
            int demo = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = demo;
            k = k/2; 
        }
    }

    // Algorithm to delete the maximum node 

    public int DeleteMax(){
        int max = heap[1];
        Swap(1,n);
        n--;
        Sink(1);
        heap[n+1] = null;
        
        // To save the space of our program

        if(n>0 && (n==(heap.length-1)/4)){
            Resize(heap.length/2);
        }
        return max;
    }

    public void Swap(int a , int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void Sink(int k){
        while(2*k  <= n){
            int j = 2*k;
            if(j < n && heap[j] < heap[j+1]){
                j++;
            }
            if(heap[k] >= heap[j]){
                break;
            }
            Swap(k,j);
            k = j;
        }
    }

    public void Resize(int capacity){
        Integer[] temp = new Integer[2*capacity];
        for(int j=0;j<heap.length;j++){
            temp[j] = heap[j];
        }
        heap = temp;
    }

}

public class Heap_03_Top_Down_Reheapyfy {
    public static void main(String[] args) {
        
        MaxPQ pq = new MaxPQ(5);
        pq.Insert(7);
        pq.Insert(3);
        pq.Insert(1);
        pq.Insert(6);
        pq.Insert(8);
        pq.Insert(4);
        pq.Insert(2);
        pq.Insert(9);
        pq.Insert(5);
        System.out.println( "The size of the heap : " + pq.Size());
        pq.PrintHeap();
        pq.DeleteMax();
        System.out.println("The size of the heap : " + pq.Size());
        pq.PrintHeap();

    }
}
