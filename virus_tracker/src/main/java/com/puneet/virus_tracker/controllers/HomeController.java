package com.puneet.virus_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.puneet.virus_tracker.model.LocationStats;
import com.puneet.virus_tracker.services.CoronaVirusDataService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusDataService dataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = dataService.getAllStats();
		int allCasesCount = allStats.stream().mapToInt(statt-> statt.getLatestCount()).sum();
		int totalNewCases = allStats.stream().mapToInt(statt-> statt.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalCasesCount",allCasesCount);
		model.addAttribute("newCasesCount", totalNewCases);
		return "home";
	}

}
