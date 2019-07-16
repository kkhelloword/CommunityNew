package com.example.demo.community.Interview;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewTest {


    @Test
    public void test(){
        int[] arr = {1,2,3,6,5,2,5,4,1,6,9,7,4,8,9,9,7,4,8,5,2,1,1,1,2};
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> receive = new HashMap<>();
        for (int i : arr) {
            if (i%2 == 1){
                if (!map.containsKey(i)){
                    map.put(i,1);
                }else{
                    map.put(i,map.get(i)+1);
                }
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)%2==0){
                receive.put(integer,map.get(integer));
            }
        }
        System.out.println(receive);
    }
}
