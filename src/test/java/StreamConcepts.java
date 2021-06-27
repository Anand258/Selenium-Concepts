import com.google.common.collect.Streams;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Developed by Anand Singh on 17/Jun/2021, 1:18 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class StreamConcepts {
    List<String> names = Arrays.asList("Anand", "Anu", "Rama", "Anshu", "Shubham");

    @Test
    public void regularMethod(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Anand");
        names.add("Anu");
        names.add("Ram");
        names.add("Anshu");
        names.add("Shubham");
        int count = 0;
        for(int i =0; i<names.size(); i++){
            String name = names.get(i);
            if(name.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }


    @Test
    public void streamMethod1(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Anand");
        names.add("Anu");
        names.add("Rama");
        names.add("Anshu");
        names.add("Shubham");

        // program to get the count of names starting with 'A'
        long count = names.stream()
                .filter(s->s.startsWith("A"))
                .count();
        System.out.println(count);

        long counts = Stream.of("Anand", "Anu", "Ram", "Anshu", "Shubham")
                .filter(s->s.startsWith("A"))
                .count();
        System.out.println(counts);
    }

    @Test
    public void streamMethod2(){
        // program to get the names which have length > 4
        names.stream()
                .filter(s->s.length()>4)
                .forEach(s->System.out.println(s));
    }

    @Test
    public void streamMethod3(){
        // program to get only one names which have length > 4
        names.stream()
                .filter(s->s.length()>4)
                .limit(1)
                .forEach(s->System.out.println(s));
    }

    @Test
    public void streamMethod4(){
        // program to get names in uppercase which are ending with 'A'
        names.stream()
                .filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    }

    @Test
    public void streamMethod5(){
        // program to get the names in uppercase which are starting with 'A' in sorted order
        names.stream()
                .filter(s->s.startsWith("A"))
                .sorted()
                .map(s->s.toUpperCase())
                .forEach(s->System.out.println(s));
    }

    @Test
    public void streamMethod6(){
        // program to merge two list
        ArrayList<String> names2 = new ArrayList<>();
        names2.add("Don");
        names2.add("Man");
        names2.add("Ro");

        Stream newStream = Streams.concat(names.stream(), names2.stream());
        boolean flag = newStream.anyMatch(s -> s.equals("Don"));
        Assert.assertTrue(flag);
    }

    @Test
    public void steamMethod7(){
        // program to get list of names in uppercase which are ending with "a"
        List<String> newList = names.stream()
                .filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(newList.get(0));
    }

    @Test
    public void steamMethod8(){
        List<Integer> values = Arrays.asList(1,2,5,2,7,4,9,8,6,6,6);

        // program to get unique values
        //values.stream().distinct().forEach(s->System.out.println(s));

        // get 3rd sorted value
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }

}
