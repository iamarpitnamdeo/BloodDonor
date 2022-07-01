package com.blooddonor.bloodDonation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blooddonor.bloodDonation.entity.BloodDonor;

public interface BloodDonorRepository extends JpaRepository<BloodDonor,Integer>{
	public List<BloodDonor> findByEmail(String email);
	public List<BloodDonor> findByBloodGroup(String bloodGroup);
	public List<BloodDonor> findByBloodGroupAndState(String bloodGroup,String state);
}
