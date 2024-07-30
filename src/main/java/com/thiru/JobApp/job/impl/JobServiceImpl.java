package com.thiru.JobApp.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.thiru.JobApp.job.Job;
import com.thiru.JobApp.job.JobRepository;
import com.thiru.JobApp.job.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	private Long nextId=1L;
	
	//private List<Job> jobs=new ArrayList<>();
	JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository)
	{
		this.jobRepository=jobRepository;
	}
	
	@Override
	public List<Job> findAll() {
		
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
		jobRepository.deleteById(id);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		
		Optional <Job> jobOptional=jobRepository.findById(id);
			if(jobOptional.isPresent())
			{
				Job job=jobOptional.get();
				job.setTitle(updatedJob.getTitle());
				job.setDescription(updatedJob.getDescription());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setLocation(updatedJob.getLocation());
				jobRepository.save(job);
				return true;
			}
		return false;
	}
	
	

}
