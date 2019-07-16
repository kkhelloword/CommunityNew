package com.example.demo.community.SortTest;


public class QuickSort {

    public static void quickSort(int[] arr,int low,int high) {

        int i,j,temp,t;
        if (low > high){
            return;
        }
        i = low;
        j = high;
//        temp 为基准位
        temp = arr[low];
        while (i<j) {
//            先看右边 从右往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
//            左边从左往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
//            如果满足条件就交换
            if (i < j) {
                t = arr[j];

                arr[j] = arr[i];

                arr[i] = t;
            }
        }
//            基数的数字进行交换
            arr[low] = arr[i];
            arr[i] = temp;
//            递归左边序列
            quickSort(arr,low,j-1);
//            递归右边序列
            quickSort(arr,j+1,high);
        }

    }

