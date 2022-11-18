package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private boolean isLeapYear;
   private int firstDayOfYear;
   private int numberOfLeapYears;
   private int dayOfYear;
   private int dayOfWeek;

   // zero argument constructor
   public Year() {} 

   /* year getter/setters */
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }	


   /* firstDayOfYear getter/setters */
   public int getFirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }
   public void setFirstDayOfYear(int year) {  // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }

   public String firstDayOfYearToString(){
      return ( "{ \"firstDayOfYear\": "  + this.firstDayOfYear + " }" );
   }	

   /* numberOfLeapYears getter/setters */
   public int getNumberOfLeapYears(int year1, int year2) {
      return APCalendar.numberOfLeapYears(year1, year2);
   }
   public void setNumberOfLeapYears(int year1, int year2) {  // this is private to avoid tampering
      this.numberOfLeapYears = APCalendar.numberOfLeapYears(year1, year2);
   }

   public String numberOfLeapYearsToString(){
      return ( "{ \"numberOfLeapYears\": "  + this.numberOfLeapYears + " }" );
   }	

   /* dayOfYear getter/setters */
   public int dayOfYear(int month, int day, int year) {
      return APCalendar.dayOfYear(month, day, year);
   }
   public void setDayOfYear(int month, int day, int year) {  // this is private to avoid tampering
      this.dayOfYear = APCalendar.dayOfYear(month, day, year);
   }

   public String dayOfYearToString(){
      return ( "{ \"dayOfYear\": "  + this.dayOfYear + " }" );
   }	

   /* dayOfWeek getter/setters */
   public int dayOfWeek(int month, int day, int year) {
      return APCalendar.dayOfWeek(month, day, year);
   }
   public void setDayOfWeek(int month, int day, int year) {  // this is private to avoid tampering
      this.dayOfWeek = APCalendar.dayOfWeek(month, day, year);
   }

   public String dayOfWeekToString(){
      return ( "{ \"dayOfWeek\": "  + this.dayOfWeek + " }" );
   }	
   
   /* standard toString placeholder until class is extended */
   public String toString() { 
      return isLeapYearToString(); 
   }

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2022);
      System.out.println(year);
   }
}