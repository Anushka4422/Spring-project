package com.zensar.springboot.coupon.endpoint;

import org.springframework.boot.actuate.info.Info.Builder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class SampleInfoContributorImpl implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String, Object> couponDetails = new HashMap<String, Object>();
		couponDetails.put("CreatedBy", "Anushka");
		couponDetails.put("ModifiedOn", "21June22");
		builder.withDetail("Coupon", couponDetails);

	}

}