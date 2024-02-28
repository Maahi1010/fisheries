package com.fisheries.Controller;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fisheries.Repo.DateWiseDataRepo;
import com.fisheries.Repo.ExcelRepo;
import com.fisheries.Repo.FisherManNameListRepo;
import com.fisheries.Repo.FisheriesRepo;
import com.fisheries.Repo.SaveUserRegularDataRepo;
import com.fisheries.Service.FisheriesService;
import com.fisheries.VO.FisherManDataVO;
import com.fisheries.VO.FisherManList;
import com.fisheries.VO.SocietyDataVO;
import com.fisheries.VO.WeeklyReportVO;

import helper.ExcelHelper;
import helper.WeeklyReportExcel;

@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	FisheriesService fisheriesService;

	@Autowired
	FisheriesRepo fisheriesRepo;

	@Autowired
	FisherManNameListRepo fisherManNameListRepo;

	@Autowired
	SaveUserRegularDataRepo saveUserRegularDataRepo;

	@Autowired
	ExcelRepo excelRepo;

	@Autowired
	DateWiseDataRepo dateWiseDataRepo;

	final static Logger logger = LoggerFactory.getLogger(MainController.class);
	static final String INMTHD = "Inside ";
	static final String OUTMTHD = " Outside ";
	static final String ERROR = " Error in the ";
	static final String CLASS = " of Class MainController";

	@GetMapping
	public String getData(Model model) {
		List<SocietyDataVO> societyList = fisheriesRepo.findAll();
		List<FisherManList> fisherManList = new ArrayList<>();

		for (int i = 0; i < societyList.size(); i++) {
			if (societyList.get(i).getFisherManList() != null)
				fisherManList.addAll(societyList.get(i).getFisherManList());
		}

		model.addAttribute("societylist", societyList);
		// model.addAttribute("fisherManNamelist", fisherManList);
		return "homeFisheries";
	}

	@GetMapping("/alldata/byPostman")
	public ResponseEntity<?> getDataByPostman(@ModelAttribute("society_name") SocietyDataVO request, Model model) {
		List<SocietyDataVO> societyList = fisheriesRepo.findAll();
		model.addAttribute("societylist", societyList);
		return ResponseEntity.ok(societyList);

	}

	@GetMapping("/postman{Id}")
	public ResponseEntity<?> getFisherManListByPostman(@RequestParam Integer Id) {
		String methodName = "getFisherManListByPostman";
		logger.info(INMTHD + methodName + CLASS);

		List<FisherManList> fisherManList = fisherManNameListRepo.findBySocietyId(Id);

		return ResponseEntity.ok(fisherManList);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveSocietyData(@RequestBody FisherManDataVO request) {

		FisherManDataVO fishermanVO;
		// Check if data is already saved
		fishermanVO = saveUserRegularDataRepo.findByfisherManIdanddateOfWork(request.getFisherManId(),
				request.getDateOfWork());

		if (fishermanVO != null)
			request.setDataPkId(fishermanVO.getDataPkId());

		fishermanVO = saveUserRegularDataRepo.save(request);

		return ResponseEntity.ok(fishermanVO);
	}

	@PostMapping("/addNewFisherMan")
	public ResponseEntity<?> addNewFisherManList(@RequestBody FisherManList request) {

		FisherManList fishermanVO;
		fishermanVO = fisherManNameListRepo.save(request);

		return ResponseEntity.ok(fishermanVO);
	}

	@PostMapping("/download")
	public ResponseEntity<?> getFile(@RequestBody FisherManDataVO request) {
		String methodName = "getFile";
		logger.info(INMTHD + methodName + CLASS);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String filename = "dailyReport_" + sdf.format(date) + ".xlsx";
		String dateOfWork = request.getDateOfWork();
		Integer societyID = request.getSocietyId();
		logger.info("dateOfWork : " + dateOfWork);
		logger.info("societyID : " + societyID);

		List<FisherManDataVO> tutorials = excelRepo.findByDateOfWorkAndSocietyId(dateOfWork, societyID);
		ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
		InputStreamResource file = new InputStreamResource(in);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}
	
	@GetMapping("/download/weekly")
	public ResponseEntity<?> getWeeklyFile() throws ParseException {
		String methodName = "getWeeklyFile";
		logger.info(INMTHD + methodName + CLASS);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date currentDate = new Date();

		Calendar cal = Calendar.getInstance();
		// get starting date
		cal.add(Calendar.DAY_OF_YEAR, -6);
		String fromDate= sdf.format(cal.getTime());
		
		String toDate =  sdf.format(currentDate);

		List<WeeklyReportVO> tutorials = excelRepo.findByWeek(fromDate,toDate);
	
		ByteArrayInputStream in = WeeklyReportExcel.tutorialsToExcel(tutorials);
		InputStreamResource file = new InputStreamResource(in);
		String filename = "Weekly_Report" + ".xlsx";
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}
	
	
	@GetMapping("/download/monthly")
	public ResponseEntity<?> getMonthlyFile() throws ParseException {
		String methodName = "getWeeklyFile";
		logger.info(INMTHD + methodName + CLASS);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date currentDate = new Date();

		Calendar cal = Calendar.getInstance();
		// get starting date
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String fromDate= sdf.format(cal.getTime());
		
		String toDate =  sdf.format(currentDate);

		List<WeeklyReportVO> tutorials = excelRepo.findByWeek(fromDate,toDate);
		
		ByteArrayInputStream in = WeeklyReportExcel.tutorialsToExcel(tutorials);
		InputStreamResource file = new InputStreamResource(in);
		String filename = "Weekly_Report" + ".xlsx";
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

}