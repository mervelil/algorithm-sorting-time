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
public class Sorting {
     void bubbleSort(int arr[]) {
      int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
  } 
 void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
     
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    void selectionSort(int arr[]) {
        int size =arr.length;
        for (int i = 0; i < size-1; i++) {
            int min_index=i;
            
            for (int j = i+1; j < size; j++) {
                if(arr[j]<arr[min_index]){
                      min_index=j;
                }
              
            }
            int temp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=temp;
        }
        
    }
    
    //FOR QUİCK SORTTT
    
    static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
 
/* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
static int partition(int[] arr, int low, int high)
{
     
    // pivot
    int pivot = arr[high];
     
    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (low - 1);
 
    for(int j = low; j <= high - 1; j++)
    {
         
        // If current element is smaller
        // than the pivot
        if (arr[j] < pivot)
        {
             
            // Increment index of
            // smaller element
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}
 
/* The main function that implements QuickSort
          arr[] --> Array to be sorted,
          low --> Starting index,
          high --> Ending index
 */
void quicksortlast(int []arr) {
    int left=arr[0];
    int right=arr[arr.length];
    quickSort(arr,left,right);
    
}
void quickSort(int arr[],int left ,int right) {
    int pivotindex=left+(right-left)/2;
    int pivotvalue=arr[pivotindex];
    int i =left ,j=right;
    while(i<=j){
        while(arr[i]<pivotvalue) {
            i++;
        }
        while (arr[j]>pivotvalue) {
            j--;
        }
        if(i<=j) {
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j] =temp;
            i++;
            j--;
            
        }
        if(left<i) {
            quickSort(arr, left, j);
        }
        if(right >i) {
            quickSort(arr, i, right);
        }
    }
}
Void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
      return null;
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void mergesort(int arr[], int n)
    {
        if (n < 2) {
            // Find the middle point
           return; 
                   }
        int mid=n/2;
        int[]left=new int [mid];
        int[]right=new int [n-mid];
        
        for(int i =0;i<mid;i++) {
            left[i]=arr[i];
            
        }
        for (int i=mid;i<n;i++) {
            right[i-mid]=arr[i];
            
        }
        mergesort(left, mid);
         mergesort(right, n-mid);
         merge(arr,left,right,mid,n-mid);
        }
    void merge(int[]a,int []l,int []r,int left,int right) {
        int i =0,j=0,k=0;
        while(i<left&&j<right) {
            if(l[i]<=r[j]) {
                a[k++]=l[i++];
            }
            else{
                a[k++]=r[j++];
                
                
            }
        }
        while (i<left) {
            a[k++]=l[i++];
        }
        while (j<right) {
            a[k++]=r[j++];
        }
    }
    
   
}
