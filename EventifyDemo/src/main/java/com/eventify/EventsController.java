package com.eventify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventsController {

	@Autowired
	private EventRepository repo;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	public List<EventsDemo> dateCompare( List<EventsDemo> tempEvents ) throws ParseException{
		System.out.println("Printing the objects after passing to method");
		System.out.println(tempEvents);
		
		List<EventsDemo> events = new ArrayList<EventsDemo>();
		for (EventsDemo event : tempEvents) {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		       // Date date1 = sdf.parse("2009-12-31");
		         
		        Date date1 = sdf.parse(event.getDate());
		        Date currentDate = new Date();
		        String tempdate = sdf.format(currentDate);
		       Date date2 = sdf.parse(tempdate);
		       if (date1.compareTo(date2) >= 0) {
		    	   events.add(event);
		       }
		}
		
		return events;
	}
	
	@GetMapping("/events")
    public String eventForm(EventsDemo eventsDemo,Map<String, Object> model) {
		try {
			Map<String, String> sampleDropdownMap = new HashMap<String, String>();
			sampleDropdownMap.put("EDUCATIONAL & LEARNING", "educational_learning");
			sampleDropdownMap.put("TECH", "tech");
			sampleDropdownMap.put("SPORTS & FITNESS", "sports_fitness");
			sampleDropdownMap.put("TRAVEL & ADVENTURE", "travel_adventure");
			sampleDropdownMap.put("BIZ & NETWORKING", "biz_networking");
			sampleDropdownMap.put("OTHERS", "others");
			sampleDropdownMap.put("ENTERTAINMENT", "entertainment");
			model.put("dropDownItems", sampleDropdownMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "eventreg";
    }
	
	@PostMapping("/events")
	public String eventFormSubmission(@ModelAttribute EventsDemo eventsDemo) {
		String tempCity = eventsDemo.getCity();
        eventsDemo.setCity(tempCity.toLowerCase());
		repo.save(eventsDemo);
		
		return "result";
		
	}
	
	//Search by city.........
	
	@GetMapping("/citysearch")
	public String getCitySearch(MyFormObject myFormObject) {
		
		return "citysearch";
	}
	
	@PostMapping("/selectcity")
	public String cityFormSubmission(@ModelAttribute("myFormObject") MyFormObject myFormObject,
		    BindingResult result,Model model) throws ParseException {
		
		String city = myFormObject.getCity().toLowerCase();
List<EventsDemo> tempEvents = repo.findByCity(city,new Sort(Direction.ASC,"date"));
		
		System.out.println("Printing the objects before passing to method");
		System.out.println(tempEvents);
		
		
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
		
	}
	
	//search by query.........
	@GetMapping("/query")
	public String getHomepageByQuery(@RequestParam(value = "query", required = false) String query, HttpServletRequest request, HttpServletResponse response ,Model model) throws ParseException {
		
	//	model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		
		List<EventsDemo> tempEvents = repo.findByTag(query,new Sort(Direction.ASC,"date"));
		
		System.out.println("Printing the objects before passing to method");
		System.out.println(tempEvents);
		
		model.addAttribute("events",dateCompare(tempEvents));
		
		return "queryresult";
	}
	
	
	@GetMapping("/getevents")
	public String getEventsList (Model model) throws ParseException {
		
	//	model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		
		List<EventsDemo> tempEvents = repo.findAll(new Sort(Direction.ASC,"date"));
		
		System.out.println("Printing the objects before passing to method");
		System.out.println(tempEvents);
		
		model.addAttribute("events",dateCompare(tempEvents));
		
		return "getevents";
		
	}
	
	//findByid...............finding events by viewdetails
	
	@GetMapping("/events/{id}")
	public String viewDetails(@PathVariable("id") String id, Model model) {
		
	//	model.addAttribute("room", romService.findOne(id).orElse(null));
		//model.addAttribute("event",repo.findOne(id).orElse(null));
		model.addAttribute("event", repo.findByObjectId(id));
		return "event";
		
	}
	
	
	@GetMapping("/eventify")
	public String getEventify() {
		
		return "eventify";
	}
	
	// Searching by Type query
	@GetMapping("/{city}")
	public String getHomePage(@PathVariable("city") String city,Model model) throws ParseException {
		
	//	model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		
		List<EventsDemo> tempEvents = repo.findByCity(city,new Sort(Direction.ASC,"date"));
		
		System.out.println("Printing the objects before passing to method");
		System.out.println(tempEvents);
		
		model.addAttribute("city",city);
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("events",dateCompare(tempEvents));
		
		return "home";
	}
	
	@GetMapping("/{city}/educnlrng")
	public String getEventsByEduLearn(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"educational_learning",  sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}
	 
	@GetMapping("/{city}/sportsnfitness")
	public String getEventsBySportsFitness(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"sports_fitness", sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}
	
	@GetMapping("/{city}/tech")
	public String getEventsByTech(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"tech", sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}

	@GetMapping("/{city}/trvladv")
	public String getEventsByTrvlAdv(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"travel_adventure", sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}
	
	@GetMapping("/{city}/biznntwk")
	public String getEventsByBizNtwk(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"biz_networking", sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}
	
	@GetMapping("/{city}/others")
	public String getEventsByOthers(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"others", sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}
	
	@GetMapping("/{city}/entertainment")
	public String getEventsByEntertainment(@PathVariable("city") String city, Model model) throws ParseException  {
		
		//model.addAttribute("events",repo.findAll(new Sort(Direction.ASC,"date")));
		Sort sort = new Sort(Sort.Direction.ASC, "date");
		List<EventsDemo> tempEvents = repo.findByType(city,"entertainment",  sort);
		model.addAttribute("events",dateCompare(tempEvents));
		model.addAttribute("cityUpper",StringUtils.capitalize(city));
		model.addAttribute("city",city);
		return "home";
	}
}
