package com.blooddonor.bloodDonation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blooddonor.bloodDonation.entity.BloodDonor;
import com.blooddonor.bloodDonation.repository.BloodDonorRepository;
import com.blooddonor.bloodDonation.service.BloodDonorService;

@Controller
public class controller {
	@Autowired
	public BloodDonorService bloodDonorService;
	
	@GetMapping("/donateBlood")
	public String showRegistrationForm() {
		return "Registration";
		}
	@SuppressWarnings("unused")
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String addPerson(@ModelAttribute("fName")String fName,
			@ModelAttribute("lName")String lName,
			@ModelAttribute("email")String email,
			@ModelAttribute("contact")String contact,
			@ModelAttribute("acontact")String acontact,
			@ModelAttribute("bloodGroup")String bloodGroup,
			@ModelAttribute("country")String country,
			@ModelAttribute("state") String state,
			@ModelAttribute("city") String city){
		BloodDonor bd = new BloodDonor(fName,lName,email,contact,acontact,bloodGroup,country, state, city);
		System.out.println(bd);
		bloodDonorService.addUser(bd);
		if(bd!=null)
		{
			return "redirect:/getUsers";
		}
		else{
			return "fail";
		}
		
		
	}
	@GetMapping("/getUsers")
	public String getAllUsers(Model model){
		model.addAttribute("bloodBank",bloodDonorService.getUsers());  
		 return "BloodBank";
	}
	
	@GetMapping("/getUserByEmail/{email}")
	@ResponseBody
	public List<BloodDonor> getUserByEmail(@PathVariable String email){
		return bloodDonorService.getUserByEmail(email);
	}
	@GetMapping("/getUserByBgNdState/{bloodGroup}/{state}")
	@ResponseBody
	public List<BloodDonor> getUserByBgNdState(@PathVariable String bloodGroup,@PathVariable String state){
		return bloodDonorService.getUserBYBgNdState(bloodGroup, state);
	}
	@GetMapping("/getUserByBg/{bloodGroup}")
	@ResponseBody
	public List<BloodDonor> getUserByBg(@PathVariable String bloodGroup){
		
	return bloodDonorService.getUserByBg(bloodGroup);
	}
	/*public List<BloodDonor> getUserByBg(@RequestParam("bloodGroup")String bloodGroup ){
		return bloodDonorService.getUserByBg(bloodGroup);
	}*/
}
