package com.thiru.JobApp.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thiru.JobApp.company.Company;
import com.thiru.JobApp.company.CompanyService;
import com.thiru.JobApp.review.Review;
import com.thiru.JobApp.review.ReviewRepository;
import com.thiru.JobApp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	
	private ReviewRepository reviewRepository;
	private CompanyService companyService;
	
	
	public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {

		this.reviewRepository = reviewRepository;
		this.companyService=companyService;
	}



	@Override
	public List<Review> getAllReviews(Long companyId) {
		List <Review> reviews=reviewRepository.findByCompanyId(companyId);
		return reviews;
	}



	@Override
	public boolean addReview(Long companyId, Review review) {
		
		Company company = companyService.getCompanyById(companyId);
		if(company!=null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		return false;
	}



	@Override
	public Review getReview(Long companyId, Long reviewId) {
	
		List <Review> reviews=reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review->review.getId().equals(reviewId)).findFirst().orElse(null);
	}



	@Override
	public boolean updateReview(Long companyId, Long reviewid, Review updatedReview) {
		
		if(companyService.getCompanyById(companyId)!=null)
		{
		
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewid);
			reviewRepository.save(updatedReview);
			return true;
		}
		else
		{
			return false;
		}
		
	}



	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if((companyService.getCompanyById(companyId)!=null) && reviewRepository.existsById(reviewId))
		{
			Review review=reviewRepository.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviwes().remove(review);
			companyService.updateCompany(company, companyId);
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
		
	}
	

	
	
}
