package com.thiru.JobApp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
	{
		return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
	}
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review)
	{
		boolean isReviewSaved=reviewService.addReview(companyId, review);
		if(isReviewSaved)
		return new ResponseEntity<>("Review added successfully",HttpStatus.OK);
		return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId)
	{
		return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
	}
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review)
	{
		boolean isReview=reviewService.updateReview(companyId, reviewId, review);
		if(isReview)
		{
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public  ResponseEntity<String> deleteReveiw(@PathVariable Long companyId,@PathVariable Long reviewId)
	{
		boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
		
		if(isReviewDeleted)
		{
			return new ResponseEntity<>("Deleted..!",HttpStatus.OK);
		}
		return new ResponseEntity<>("Not deleted",HttpStatus.NOT_FOUND);
			
	}

}
