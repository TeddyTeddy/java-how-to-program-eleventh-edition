// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.  

public class Time2 {

   private static final int SECONDS_IN_AN_HOUR = 3600;
   private static final int SECONDS_IN_A_MIN = 60;
   
   private int secondsSinceMidnight; // the number of seconds since midnight

   // Time2 no-argument constructor: 
   // initializes each instance variable to zero  
   public Time2() {                                             
      this(0, 0, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2(int hour) {                                               
      this(hour, 0, 0); // invoke constructor with three arguments 
   } 

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2(int hour, int minute) {
      this(hour, minute, 0); // invoke constructor with three arguments 
   } 

   // Time2 constructor: hour, minute and second supplied   
   public Time2(int hour, int minute, int second) {	  
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      } 

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      } 

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      } 
 
      secondsSinceMidnight = (hour * SECONDS_IN_AN_HOUR) + (minute * SECONDS_IN_A_MIN) + second; 
   } 

   // Time2 constructor: another Time2 object supplied           
   public Time2(Time2 time) {
      this.secondsSinceMidnight = time.secondsSinceMidnight;
   } 

   // Set Methods
   // set a new time value using universal time;  
   // validate the data
   public void setTime(int hour, int minute, int second) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      } 

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      } 

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      } 

      secondsSinceMidnight = (hour * SECONDS_IN_AN_HOUR) + (minute * SECONDS_IN_A_MIN) + second;
   } 

   // validate and set hour 
   public void setHour(int hour) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      }

      secondsSinceMidnight %= SECONDS_IN_AN_HOUR; // remove OLD hours value
      secondsSinceMidnight += (hour * SECONDS_IN_AN_HOUR); // add the NEW hour value
   } 

   // validate and set minute 
   public void setMinute(int minute) {
      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      }

      int hour = getHour();
      int second = getSecond();
      secondsSinceMidnight = (hour * SECONDS_IN_AN_HOUR) + (minute * SECONDS_IN_A_MIN) + second;
   } 

   // validate and set second 
   public void setSecond(int second) {
      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }

      int hour = getHour();
      int minute = getMinute();
      secondsSinceMidnight = (hour * SECONDS_IN_AN_HOUR) + (minute * SECONDS_IN_A_MIN) + second;   
   } 

   // Get Methods         
   // get hour value      
   public int getHour() {return secondsSinceMidnight / SECONDS_IN_AN_HOUR; }

   // get minute value      
   public int getMinute() {
	   int hoursRemoved = secondsSinceMidnight % SECONDS_IN_AN_HOUR;
	   int minute = hoursRemoved / SECONDS_IN_A_MIN;
	   return minute;
   } 

   // get second value      
   public int getSecond() {
	   return secondsSinceMidnight % SECONDS_IN_A_MIN;
   }   

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString() {
      return String.format(
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   } 

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s", 
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   } 
} 

