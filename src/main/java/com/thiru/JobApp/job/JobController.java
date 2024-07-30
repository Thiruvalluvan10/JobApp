package com.thiru.JobApp.job;

import java.util.ArrayList;
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

import com.thiru.JobApp.company.Company;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private JobService jobService;
	
	public JobController(JobService jobService) {
		
		this.jobService = jobService;
	}

	
	
	@GetMapping()
	public ResponseEntity<List<Job>> findAll()
	{
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<String> createJob(@RequestBody Job job)
	{
		jobService.createJob(job);
		//Company c=job.getCompany();
		return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobbyId(@PathVariable Long id)
	{
		
		Job job=jobService.getJobById(id);
		if(job!=null)
		{
		return new ResponseEntity<>(job,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id)
	{
		boolean deleted=jobService.deleteJobById(id);
		if(deleted)
			return new ResponseEntity<>("Job deleted",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob)
	{
		boolean updated = jobService.updateJob(id,updatedJob);
		if(updated)
			return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
