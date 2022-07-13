package com.traxcrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traxcrm.entities.Billing;
import com.traxcrm.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {

	
	@Autowired
	BillingRepository billingRepo;
	
	
	@Override
	public void saveData(Billing billing) {
	billingRepo.save(billing);
    }

}
