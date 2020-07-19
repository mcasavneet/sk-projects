// Java code to check whether two strings
// are Anagram or not using HashMap

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.NumberFormat;
import java.time.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class GFG {

    // Function to check whether two strings
    // are an anagram of each other
    static boolean areAnagram(String str1, String str2)
    {

        HashMap<Character, Integer> hmap1
                = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmap2
                = new HashMap<Character, Integer>();

        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();

        // Mapping first string
        for (int i = 0; i < arr1.length; i++) {

            if (hmap1.get(arr1[i]) == null) {

                hmap1.put(arr1[i], 1);
            }
            else {
                Integer c = (int)hmap1.get(arr1[i]);
                hmap1.put(arr1[i], ++c);
            }
        }

        // Mapping second String
        for (int j = 0; j < arr2.length; j++) {

            if (hmap2.get(arr2[j]) == null)
                hmap2.put(arr2[j], 1);
            else {

                Integer d = (int)hmap2.get(arr2[j]);
                hmap2.put(arr2[j], ++d);
            }
        }

        if (hmap1.equals(hmap2))
            return true;
        else
            return false;
    }

    // Test function
    public static void test(String str1, String str2)
    {

        System.out.println("Strings to be checked are:\n"
                + str1 + "\n" + str2 + "\n");

        // Find the result
        if (areAnagram(str1, str2))
            System.out.println("The two strings are"
                    + "anagram of each other\n");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other\n");
    }

    static void printReverse(String str)
    {
        // Print first word
        int i = 0;
        for (i = 0; i < str.length() && str.charAt(i) != ' '; i++)
            System.out.print(str.charAt(i)) ;

        // Print middle words
        String word = "";


        for (; i < str.length(); i++) {

            if (str.charAt(i) != ' ')
                word += str.charAt(i);

            else {
                System.out.print(new StringBuilder(word).
                        reverse().toString() + " ");
                word = "";
            }
        }

        // Print last word
        System.out.print(word + " ");
    }

    public static void main(String []args)
    {
        String str = "Hi how are you geeks";
        printReverse(str);
    }

// This code is contributed by Ryuga
}
    /*
    // Driver program
    public static void main(String args[]) throws IOException {

        /*Get the Strings
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";

        // Test the Strings
        test(str1, str2);

        // Get the Strings
        str1 = "geeksforgeeks";
        str2 = "geeks";

        // Test the Strings
        test(str1, str2);*//*

       *//* byte a = 127; byte b = 127;

       // b = a + b; // error : cannot convert from int to byte
        int c = a + b;
        b += a; // ok

        System.out.println(b);
        System.out.println(c);*//*

        *//*Integer i1 = 100; Integer i2 = 100;
        if (i1 == i2)
        { System.out.println("i1 and i2 is equal"); } else { System.out.println("i1 and i2 is not equal "); }*//*

//        Pattern pattern = Pattern.compile("^[0-9].$");
//        String s1 = "s728";
//        Matcher matcher = pattern.matcher(s1);
//        System.out.println(matcher.matches());
//
//        LocalDate dateOfBirth = LocalDate.of(2020, 02, 01);
//        System.out.println("Your Date of birth is : " + dateOfBirth);
//        System.out.println(dateOfBirth.isBefore(LocalDate.now(Clock.system(ZoneId.of("Australia/Darwin")))));

        //ZonedDateTime zoneDateTimeEST = ZonedDateTime.of(LocalDateTime.now(),ZoneId.of(ZoneId.SHORT_IDS.get("AET")));
        //System.out.println(zoneDateTimeEST);

        // Date and time with timezone in Java 8
//        ZoneId america = ZoneId.of("America/New_York");
//        LocalDateTime localtDateAndTime = LocalDateTime.now();
//        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america );
//        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
//
//        byte[] arr = {123,122,1,21,123};
//        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr);
//
//        System.out.println(byteBuffer0.array());
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(242);
//        byteBuffer.put(arr);
//        if(byteBuffer.isDirect()){
//            System.out.println("direct");
//        }
//        System.out.println(byteBuffer.getChar(22));
//
//
//
//        RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\Savneet.txt","rw");
//        MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE,0,10);
//        String s = "HELLO";
//        for(char c : s.toCharArray()){
//            mappedByteBuffer.put((byte)c);
//        }
//        Scanner scanner = new Scanner(System.in);
//        String st = scanner.next();
//        System.out.println(st);
//
//        FileInputStream fileInputStream = new FileInputStream("F:\\Savneet.txt");
//        BufferedInputStream bf = new BufferedInputStream(fileInputStream);
//        int b;
//        while((b = bf.read()) !=  -1){
//            System.out.print((char) b);
//        }
//        bf.close();
//        fileInputStream.close();
//
//        RandomAccessFile randomAccessFile1 = new RandomAccessFile("F:\\BigData\\2Feb\\Notes.txt","r");
//        FileChannel fileChannel = randomAccessFile1.getChannel();
//        ByteBuffer byteBuffer1 = ByteBuffer.allocate(128);
//        while(fileChannel.read(byteBuffer1) > 0){
//            String str = new String(byteBuffer1.array());
//            System.out.print(str);
//            byteBuffer1.clear();
//        }
//        fileChannel.close();
//        randomAccessFile1.close();


        Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains 4? "+numbers3.parallel().anyMatch(i -> i==4));
//Stream contains 4? true

        Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains all elements less than 10? "+numbers4.parallel().allMatch(i -> i>10));
//Stream contains all elements less than 10? true

        Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
        System.out.println("Stream doesn't contain 10? "+numbers5.parallel().noneMatch(i -> i==10));
//Stream doesn't contain 10? true


        Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa","Divija");
        long firstNameWithD = names4.filter(i -> i.startsWith("D") && i.length() > 5).count();
        System.out.println(firstNameWithD);

        BigDecimal bigDecimal = new BigDecimal("225522333333");
        System.out.println("Unformatted: " + bigDecimal.toString());
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRENCH);
        double money = bigDecimal.doubleValue();
        String s = n.format(money);
        System.out.println("Formatted: "+s);


        String ssss = "SA42AVITRI";
        System.out.println(ssss.codePointCount(0,5));
    }*/
