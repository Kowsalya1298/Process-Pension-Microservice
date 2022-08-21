package com.cognizant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.model.ProcessPensionResponse;
import com.cognizant.repository.PensionDetailRepository;


/**
 * @author 889068
 *
 */
@Service
public class ProcessPensionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionService.class);
    @Autowired
    private PensionDetailRepository pensionDetailRepository;

    /**
     * @param pensionerDetail
     * @param pensionerInput
     * @return pension details (pension amount and bank service charge)
     */
   
    public PensionDetail getPensionDetail(PensionerDetail pensionerDetail, PensionerInput pensionerInput) {
	LOGGER.info("STARTED - getPensionDetail");
	double pensionAmount = 0;
	double bankServiceCharge = 0;

	ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();

	if (pensionerDetail.getPensionType().equalsIgnoreCase("self")) {
	    pensionAmount = (0.8 * pensionerDetail.getSalary() + pensionerDetail.getAllowance());
	} else if (pensionerDetail.getPensionType().equalsIgnoreCase("family")) {
	    pensionAmount = (0.5 * pensionerDetail.getSalary() + pensionerDetail.getAllowance());
	}

	if (pensionerDetail.getBankDetail().getBankType().equalsIgnoreCase("private")) {
	    pensionAmount = pensionAmount - 550;
	    bankServiceCharge = 550;
	    processPensionResponse.setProcessPensionStatusCode(10);

	} else if (pensionerDetail.getBankDetail().getBankType().equalsIgnoreCase("public")) {
	    pensionAmount = pensionAmount - 500;
	    bankServiceCharge = 500;
	    processPensionResponse.setProcessPensionStatusCode(10);

	}

	PensionDetail pensionDetail = new PensionDetail(pensionerDetail.getName(), pensionAmount, bankServiceCharge);

	LOGGER.info("END - getPensionDetail");
	return pensionDetail;

    }

    /**
     * @param pensionDetail
     * @return saved pension details
     */
    public PensionDetail savePensionDetail(PensionDetail pensionDetail) {
	LOGGER.info("STARTED - savePensionDetail");
	LOGGER.info("END - savePensionDetail");
	return pensionDetailRepository.save(pensionDetail);

    }

}
