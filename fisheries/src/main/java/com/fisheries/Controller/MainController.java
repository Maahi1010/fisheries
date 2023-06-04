package com.fisheries.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisheries.Repo.FisherManNameListRepo;
import com.fisheries.Repo.FisheriesRepo;
import com.fisheries.Service.FisheriesService;
import com.fisheries.VO.FisherManDataVO;
import com.fisheries.VO.SocietyDataVO;

@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	FisheriesService fisheriesService;

	@Autowired
	FisheriesRepo fisheriesRepo;

	@Autowired
	FisherManNameListRepo fisherManNameListRepo;
	
	@GetMapping
	public String getData(@ModelAttribute("society_name") SocietyDataVO request, Model model) {
		List<SocietyDataVO> societyList = fisheriesRepo.findAll();
	    model.addAttribute("societylist",societyList);
		return "homefisheries";
	}
	

	@GetMapping(path = "/nameByCategory")
	public String getFisherManNameList(@ModelAttribute("society_id") SocietyDataVO request, Model model) {
		//int id = request.getSocietyId();
		int id = 1;
		List<FisherManDataVO> fisherManNamelist = fisherManNameListRepo.findBySocietyId(id);
	    model.addAttribute("fisherManNamelist",fisherManNamelist);
		return "homefisheries";
	}

	@RequestMapping("/save")
	public String saveSocietyData(@ModelAttribute("User") SocietyDataVO request, Model model) {
		return "";
	}

}
