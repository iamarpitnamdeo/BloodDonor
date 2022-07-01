package com.blooddonor.bloodDonation.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blooddonor.bloodDonation.entity.BloodDonor;
import com.blooddonor.bloodDonation.repository.BloodDonorRepository;

@Service
public class BloodDonorService {
	@Autowired
	private BloodDonorRepository bloodDonorRepository;
	
	@PostConstruct
	public void initDb() {
		List<BloodDonor> users = new ArrayList<>();
		users.add(new BloodDonor("Ram", "Narayan", "ram@gmail.com","1234567890","NA","B+","India", "Madhya Pradesh", "Jabalpur"));
		users.add(new BloodDonor("Ghanshyam", "Ram", "shyam@gmail.com","1234567891","NA","B+","India", "Madhya Pradesh", "City"));
		users.add(new BloodDonor("Natasha", "Romenoff", "rmnof@shield.com","1234567894","NA","B+","Country", "State", "City"));
		bloodDonorRepository.saveAll(users);
	}
	public BloodDonor addUser(BloodDonor bloodDonor) {
		
		return bloodDonorRepository.save(bloodDonor);
	}
	
	public Iterable<BloodDonor> getUsers(){
		return bloodDonorRepository.findAll();
	}
	
	public List<BloodDonor> getUserByEmail(String email){
		return bloodDonorRepository.findByEmail(email);
	}
	
	public List<BloodDonor> getUserBYBgNdState(String bloodGroup,String state)
	{
		return bloodDonorRepository.findByBloodGroupAndState(bloodGroup, state);
		
	}
	
	public List<BloodDonor> getUserByBg(String bloodGroup){
		return bloodDonorRepository.findByBloodGroup(bloodGroup);
	}
}
