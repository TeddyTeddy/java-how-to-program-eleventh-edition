// Fig. 8.6: Time3Test.java
// Overloaded constructors used to initialize Time3 objects.

public class Time3Test {
   public static void main(String[] args) {
      Time3 t1 = new Time3(22, 59, 59); // 22:59:59 (b)       
      Time3 t2 = new Time3(21, 40, 59); // 21:40:59 (a)       
      Time3 t3 = new Time3(21, 59, 40); // 21:59:40    
      Time3 t4 = new Time3(23, 59, 59); // 23:59:59 (c)
      Time3 t5 = new Time3(t4); // 23:59:59
      
      t1.tick();
      displayTime("t1 after tick()", t1);  // 23:00:00
      
      t2.tick();
      displayTime("t2 after tick()", t2);  // 21:41:00
  
      t3.tick();
      displayTime("t3 after tick()", t3);  // 21:59:41
      
      // (c)
      t4.tick();
      displayTime("t4 after tick()", t4);  // 00:00:00
      
      // (a)
      t5.incrementMinute(); // upon 23:59:59
      displayTime("t5 after incrementMinute():", t5); // 00:00:59
      
      t2.incrementMinute(); // upon 21:41:00
      displayTime("t2 after incrementMinute():", t2); // 21:42:00
      
      t3.incrementMinute(); // upon 21:59:41
      displayTime("t3 after incrementMinute():", t3); // 22:00:41
      
      // (b)
      t1.incrementHour(); // upon 23:00:00
      displayTime("t1 after incrementHour():", t1); // 00:00:00
      
      t1.incrementHour(); // upon 00:00:00
      displayTime("t1 after incrementHour():", t1); // 01:00:00    
   } 

   // displays a Time3 object in 24-hour and 12-hour formats
   private static void displayTime(String header, Time3 t) {
      System.out.printf("%s%n   %s%n   %s%n",
         header, t.toUniversalString(), t.toString());
   } 
}

