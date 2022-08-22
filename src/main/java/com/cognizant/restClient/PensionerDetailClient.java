package com.cognizant.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PensionerDetail;

/**
 * @author 889068
 *
 */
@FeignClient(name = "PensionerDetailService", url = "http://13.232.73.221:9081")
public interface PensionerDetailClient {
	
	@GetMapping("/pensionerDetail/{aadhaarNumber}")
	public PensionerDetail findByAadhaarNumber(@PathVariable String aadhaarNumber);

	@GetMapping("/allDetails")
	public List<PensionerDetail> getAllDetail();
	
}
