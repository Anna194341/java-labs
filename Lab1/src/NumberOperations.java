import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;

public class NumberOperations {

  public static void main(String[] args) {
    
    ArrayList<Number> numbers = new ArrayList<Number>(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));

    numbers.add((short)10);
    numbers.add((double)-62.5);
    numbers.add(12L);
    numbers.add(40.7f);
    numbers.add(50.00000001);
    numbers.add((float)60.3);
    numbers.add((byte)70);
    numbers.add(-80.1f);
    numbers.add((short)90);
    numbers.add(100.9);
    numbers.add(Math.PI);
    
    System.out.println("The numbers: ");
    for(Number el : numbers) 
      System.out.printf("%s ", el);
        
        System.out.println("\nInteger format: ");
        for (Number el : numbers) 
            System.out.printf("%d ", el.intValue());
        
        System.out.println("\nTwo decimal places format: ");
        for (Number el : numbers) {
            System.out.printf("%.2f ", el.floatValue());
        }
        
        ArrayList<Byte> bytes = new ArrayList<>();
        ArrayList<Short> shorts = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Float> floats = new ArrayList<>();
        ArrayList<Long> longs = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();

        for (Number el : numbers) {
            if (el instanceof Byte) {
                bytes.add((Byte) el);
            } else if (el instanceof Short) {
                shorts.add((Short) el);
            } else if (el instanceof Integer) {
                integers.add((Integer) el);
            } else if (el instanceof Float) {
                floats.add((Float) el);
            } else if (el instanceof Long) {
                longs.add((Long) el);
            } else if (el instanceof Double) {
                doubles.add((Double) el);
            }
        }

        System.out.println("\nBytes: " + bytes);
        System.out.println("Shorts: " + shorts);
        System.out.println("Integers: " + integers);
        System.out.println("Floats: " + floats);
        System.out.println("Longs: " + longs);
        System.out.println("Doubles: " + doubles);
        
        BigDecimal sum = new BigDecimal("0");
        BigDecimal fifty = new BigDecimal("50");
        
        for (Number el : numbers) {
          BigDecimal EL = new BigDecimal(el.toString());
            if(EL.compareTo(fifty) > 0)  {
              sum = sum.add(EL);
            }
        }
        
        System.out.println("The sum of all numbers greater than 50: (variant 18) " + sum);
  }

}