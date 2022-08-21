package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ProcessPensionException;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.restClient.PensionerDetailClient;
import com.cognizant.service.ProcessPensionService;

/**
 * @author 889068
 *
 */
@RestController
public class ProcessPensionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionController.class);
    @Autowired
    private PensionerDetailClient pensionerDetailClient;
    @Autowired
    private ProcessPensionService processPensionService;

    /**
     * @return all details from pensioner details micro service
     */
    @GetMapping("/details")
    public List<PensionerDetail> allDetail() {
	LOGGER.info("STARTED - allDetail");
	List<PensionerDetail> pensionerDetail = pensionerDetailClient.getAllDetail();
	LOGGER.info("END - allDetail");
	return pensionerDetail;
    }

    /**
     * @param pensionerInput aadhar number to process pension details
     * @return calculated pension amount and bank service charge
     */
    @PostMapping("/processPension")
    public PensionDetail getPensionDetail(@RequestBody PensionerInput pensionerInput) {
	LOGGER.info("STARTED - allDetail");
	PensionDetail pensionDetail = null;
	try {

	    pensionDetail = processPensionService.getPensionDetail(
		    pensionerDetailClient.findByAadhaarNumber(pensionerInput.getAadhaarNumber()), pensionerInput);

	} catch (Exception e) {
	    LOGGER.error("EXCEPTION - allDetail");
	    throw new ProcessPensionException("Pensioner Detail not correct");
	}
	LOGGER.info("END - allDetail");
	return processPensionService.savePensionDetail(pensionDetail);

    }

    /**
     * @param pensionerInput aadhar number to get details
     * @return
     */
    @PostMapping("/pensionerDetail")
    public PensionerDetail getPensionerDetail(@RequestBody PensionerInput pensionerInput) {
	LOGGER.info("STARTED - allDetail");
	PensionerDetail pensionerDetail = null;
	try {

	    pensionerDetail = pensionerDetailClient.findByAadhaarNumber(pensionerInput.getAadhaarNumber());

	} catch (Exception e) {
	    LOGGER.error("EXCEPTION - allDetail");
	    System.out.println(pensionerDetailClient.findByAadhaarNumber(pensionerInput.getAadhaarNumber()));
	    throw new ProcessPensionException("Pensioner Detail not correct");
	}
	LOGGER.info("END - allDetail");
	return pensionerDetail;

    }

}
