/*
package com.rating;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MoviesControllerbak {

	@Autowired
	private MoviesRepo moviesRepo;

	@GetMapping("/movie")
	public String createMovie(Model model) {
		
		model.addAttribute("movie",new Movies());
		return"movieform";
	}
	
	@PostMapping("/movie")
	public String createMoviePost(@ModelAttribute Movies movie,RedirectAttributes redirectAttributes) {
		
		Movies tempmovie = moviesRepo.findByName(movie.getName());
		if(tempmovie==null) {
		 ArrayList<Integer> ratingNumbers = new ArrayList<Integer>();
			for(int i=0;i<5;i++) {
				ratingNumbers.add(0);
			
			}
			movie.setRatingNumbers(ratingNumbers);
			moviesRepo.saveMovie(movie);
			redirectAttributes.addFlashAttribute("message", "Successfully Saved Movie");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			return "redirect:/movie";
		}
		redirectAttributes.addFlashAttribute("message", "Movie with same name already exists");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return"redirect:/movie";
	}

	@GetMapping("/getMovie")
	public String createReview() {
		
		
		return"getMovie";
	}
	
	@PostMapping("/getMovie")
	public String getMovie(@RequestParam String name,Model model) {
		
		model.addAttribute("movie",moviesRepo.findByName(name));
		return"showMovie";
	}
	
	@PostMapping("/addReview")
	public String addReview(@RequestParam String email,@RequestParam String review,
			                @RequestParam int ratingValue,@RequestParam String name,Model model) {
		
		Movies movie = moviesRepo.findByName(name);
		//updating reviews
		ArrayList<Reviews> tempreview = movie.getReviews();
		Reviews reviews = new Reviews();
		reviews.setEmail(email);
		reviews.setReview(review);
		reviews.setRatingValue(ratingValue);
		tempreview.add(reviews);
		
		movie.setReviews(tempreview);
		
	/*
		//updating rating values
		ArrayList<Integer> ratingNumbers= movie.getRatingNumbers();
		for(int i=0;i<5;i++) {
			if(ratingValue==(i+1)) {
				ratingNumbers.set(i, ratingNumbers.get(i)+1);
				System.out.println("Rating Number: "+ ratingNumbers.get(i));
			}
		}
		
		movie.setRatingNumbers(ratingNumbers);
		
		//calculating actual rating values
		String rating= moviesRepo.findRatingvalue(ratingNumbers);
		movie.setRating(rating);
		
		
		moviesRepo.saveMovie(movie);
		 model.addAttribute("movie",movie);
		return"showMovie";
	}
	
}                                            */



