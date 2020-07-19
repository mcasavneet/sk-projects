import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by savneet on 16-04-2019.
 */
public class NumberToWord{
    public static void main(String[] args) {
       /* final People people = new AsianPeople();
        people.setName("Ram");
        System.out.println(people);
        people.setName("Ram3");
        System.out.println(people);
        people.display();

        // not allowed -- people = new People();
        long longWithL = 1000*60*60*24*365L;
        long longWithoutL = 1000*60*60*24*365;
        System.out.println(longWithL);
        System.out.println(longWithoutL);

        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(12);
        integerArrayList.add(13);
        integerArrayList.add(14);
        integerArrayList.add(42);
        integerArrayList.add(212);
        Iterator iter = integerArrayList.iterator();
        integerArrayList.remove(212);
        while (iter.hasNext()){
            System.out.println(iter.next());
        }*/
       /* ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

// ArrayList add
        long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration);

// LinkedList add
        startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration);

// ArrayList get
        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration);

// LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration);


// ArrayList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >=0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration);

// LinkedList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >=0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration);*/

        /*System.out.println(System.getProperty("os.arch"));
        String[] srStr = {"hddt","fghfgh","ghf"};
        System.out.println(srStr);
        System.out.println(Arrays.toString(srStr));*/

        /*String text = "5322";
        if (text.matches("[0-9]+")){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }

        String text2 = "ABCa";
        if (text2.matches("[a-zA-Z]+")){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }*/
       /* CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        copyOnWriteArrayList.add("A");
        copyOnWriteArrayList.add("B");
        copyOnWriteArrayList.add("C");
        copyOnWriteArrayList.add("D");
        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        copyOnWriteArrayList.add("E");
        copyOnWriteArrayList.remove("D");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator = copyOnWriteArrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/


        /*ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
        concurrentHashMap.put("A",12);
        Iterator<String> iterator1;
        iterator1 = concurrentHashMap.keySet().iterator();*/
        String s = "ABC";
        System.out.println(String.copyValueOf(s.toCharArray(),1,2));
        int r = (int)(Math.floor(Math.random()*8))+2;
        System.out.println(r);

        StringBuffer buffer = new StringBuffer("polls tests");
        buffer.insert(6,"Good ");
        System.out.println(buffer);

        Object strt = new String[]{"one"};
        for(String ss : (String[])strt){

        }
    }

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer,Integer> socks = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < n ; i++){
            if(socks.containsKey(ar[i])){
                int count = socks.get(ar[i]);
                socks.put(ar[i],++count);
            } else {
                socks.put(ar[i],1);
            }
        }
        Set<Integer> keys = socks.keySet();
        int countOfPairs= 0;
        for(Integer i : keys){
            countOfPairs+= socks.get(i)/2;
        }
        return countOfPairs;



    }
}
class People{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    protected  void display(){
        System.out.println("People");
    }

    @Override
    public String toString() {
        return "Name " + name;
    }
}
class AsianPeople extends People{

    public void display(){
        System.out.println("Asian People");
    }
}

