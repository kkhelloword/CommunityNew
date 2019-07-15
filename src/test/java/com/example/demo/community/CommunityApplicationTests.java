package com.example.demo.community;

import com.example.demo.community.SortTest.QuickSort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {


    @Test
    public void contextLoads() {
        int[] arr = {10, 4, 5, 9, 6, 1, 3};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    @Test

    public void chooseSort() {
        int[] arr = {10, 4, 5, 9, 6, 1, 3};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void binaSort() {
        int[] arr = {10, 4, 5, 9, 6, 1, 3};
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < 9) {
                high = mid - 1;
            } else if (arr[mid] > 9) {
                low = mid + 1;
            } else {
                System.out.println(mid);
                return;
            }
        }
    }

    @Test
    public void test2() {

        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        QuickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

}
