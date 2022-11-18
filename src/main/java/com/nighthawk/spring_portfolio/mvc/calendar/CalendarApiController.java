package com.nighthawk.spring_portfolio.mvc.calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Calendar API
 * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns: {"year":2020,"isLeapYear":false}
 */
@RestController
@RequestMapping("/api/calendar")
public class CalendarApiController {

    /** GET isLeapYear endpoint
     * ObjectMapper throws exceptions on bad JSON
     *  @throws JsonProcessingException
     *  @throws JsonMappingException
     */
    @GetMapping("/isLeapYear/{year}")
    public ResponseEntity<JsonNode> getIsLeapYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj = new Year();
      year_obj.setYear(year);  // evaluates Leap Year

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(year_obj.isLeapYearToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

    @GetMapping("/firstDayOfYear/{year}")
    public ResponseEntity<JsonNode> getFirstDayOfYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj2 = new Year();
      year_obj2.setFirstDayOfYear(year);

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(year_obj2.firstDayOfYearToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

    @GetMapping("/numberOfLeapYears/{year1}/{year2}")
    public ResponseEntity<JsonNode> getNumberOfLeapYears(@PathVariable("year1") int year1, @PathVariable("year2") int year2) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj3 = new Year();
      year_obj3.setNumberOfLeapYears(year1, year2);

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(year_obj3.numberOfLeapYearsToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

    @GetMapping("/dayOfYear/{month}/{day}/{year}")
    public ResponseEntity<JsonNode> getDayOfYear(@PathVariable("month") int month, @PathVariable("day") int day,  @PathVariable("year") int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj4 = new Year();
      year_obj4.setDayOfYear(month, day, year);

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(year_obj4.dayOfYearToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }
    
    @GetMapping("/dayOfWeek/{month}/{day}/{year}")
    public ResponseEntity<JsonNode> getDayOfWeek(@PathVariable("month") int month, @PathVariable("day") int day,  @PathVariable("year") int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj5 = new Year();
      year_obj5.setDayOfWeek(month, day, year);

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(year_obj5.dayOfWeekToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }
}