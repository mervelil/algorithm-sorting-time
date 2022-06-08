/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sortingtime;

/**
 *
 * @author merve çelik
 */
public class MinHeap2  <T extends Comparable<T>> {
    T heap[];
    int size;

    public MinHeap2() {
    }
 
    public MinHeap2(int N) {
        heap=(T[]) new Comparable[N];
        size=0;
    }
    int parent(int index){
        return (index-1)/2;
    }
    void swap(int i,int j){
        T temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    void insert(T data){
        if(size<heap.length){
            heap[size]=data;
            
            int current=size++;
            int parent=parent(current);
            
            while(heap[parent].compareTo(heap[current])>0){
                swap(parent, current);
                current=parent;
                parent=parent(current);
            }
        }
        else{
            System.out.println("Heap is full!");
        }
    }
    void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    void heapify(){
        int lastindex=size-1;
        int parent=parent(lastindex);
        for (int i = parent; i >=0; i--) {
            minHeap(i);
        }
    }
    void minHeap(int i){
        int left=2*i+1;
        int right=2*i+2;
        
        int min=i;
        if(left<size && heap[left].compareTo(heap[min])<0){
            min=left;
        }
        if(right<size && heap[right].compareTo(heap[min])<0){
            min=right;
        }
        if(min!=i){
            swap(min, i);
            minHeap(min);
        }
            
                
    }
    T mindelete(){
       T deleted=heap[0];
       heap[0]=heap[size-1];
       size--;
       heapify();
       return deleted;
    }
      void heapSort(int arr[]) {
          heapify(); //grlen arrayi düzenliyoruz
          int lastindex=size-1;//eson index elemanın arada bos olabileceği için böyle tanımladık
          int counter=size; 
          for (int i = lastindex; i >0; i--) {
              swap(0,i);
              size--;
              counter++;
              
              minHeap(0); //en kucuk elemeanla karsılastırdıgımız icin minnheP 0 diyoruz
              
          }
          size =counter;
          
    } 
}
