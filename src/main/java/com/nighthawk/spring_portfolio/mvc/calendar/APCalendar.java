package com.nighthawk.spring_portfolio.mvc.calendar;


// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
          } else if (year % 400 == 0) {
            return true;
          } else if (year % 100 == 0) {
            return false;
          } else {
            return true;
          }
        }
        
    private static int daysOfMonth(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 2:
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;

        }

    }
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    public static int firstDayOfYear(int year) {
        // Count years between
        // years Y and B
        /*int totalDays = 0;
        for (int i = 0; i < Y; i++) {
            if (isLeapYear(Y)) {
                totalDays = totalDays + 2;
            } else {
                totalDays = totalDays + 1;
                }
            }
        int day = totalDays % 7;
        return day;
        */
        int C = (year / 100);
        int Y = (year - C * 100) - 1;
        double day = (1 + Math.floor(2.6 * 11 - 0.2) - 2*C + Y + Math.floor(Y / 4) + Math.floor(C / 4)) % 7;
        return (int) Math.round(day);

        }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    public static int dayOfYear(int month, int day, int year) {
        // implementation not shown
        int monthDays = 0;
        for (int i = 1; i < month; i++) {
            monthDays = monthDays + daysOfMonth(i, year);
            }
        return day + monthDays;
        }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        int leapYears = 0;
        int n = year2 - year1;
        for (int i = 0; i < n; ++i) {
            if (isLeapYear(year1 + i)) {
                ++leapYears;
            }
        }
        return leapYears;
        }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        int weekday = firstDayOfYear(year);
        int additionalDays = dayOfYear(month, day, year) - 1;
    
        for(int d = 1; d <= additionalDays; d++)
        {
        weekday++;
    
        if(weekday == 7)
            weekday = 0;
        }
            
        return weekday;
    }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2019));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}