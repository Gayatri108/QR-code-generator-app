package com.main.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;
import com.main.app.service.QrCodeGeneratorService;
import com.main.app.utility.QrGeneratorUtility;
import com.main.app.vo.ApplicantResponse;
import com.main.app.vo.ApplicantRequest;

@Controller
public class QrCodeGeneratorController {
	@Autowired
	QrCodeGeneratorService qrCodeGeneratorService;
	@Autowired
	QrGeneratorUtility qrGeneratorUtility;

	@GetMapping("/newApplication")
	public String newApplication() {
		return "applicant";
	}

	@PostMapping("/submitApplication")
	public ModelAndView generateQRCode(@RequestParam("name") String name, @RequestParam("email") String email,
			ModelAndView model) throws WriterException, IOException {
		ApplicantRequest applicationVO = qrGeneratorUtility.prepareRequest(email, name);
		byte[] bytes = qrCodeGeneratorService.generateQRCodeImage(applicationVO);
		ApplicantResponse applicantResponse = qrGeneratorUtility.prepareResponse(bytes, name, email);
		model.addObject("applicantResponse", applicantResponse);
		model.setViewName("applicantResult");

		return model;
	}

}
