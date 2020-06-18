package com.main.app.utility;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.main.app.vo.ApplicantRequest;
import com.main.app.vo.ApplicantResponse;
@Component
public class QrGeneratorUtility {
	public ApplicantRequest prepareRequest(String name, String email) {
		ApplicantRequest applicationVo = new ApplicantRequest();
		applicationVo.setName(name);
		applicationVo.setEmail(email);
		applicationVo.setHeight(350);
		applicationVo.setWidth(350);
		return applicationVo;

	}
	public ApplicantResponse prepareResponse(byte[] bytes,String name,String email)
	{
		byte[] encodeBase64Data = Base64.getEncoder().encode(bytes);
		String base64Encoded="";
		try {
			base64Encoded = new String(encodeBase64Data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ApplicantResponse applicantResponse=new ApplicantResponse();
		applicantResponse.setName(name);
		applicantResponse.setConfirmation(name +" Congratulation for your interest");
		applicantResponse.setEmail(email);
		applicantResponse.setQrImage(base64Encoded);
		return applicantResponse;
	}

}
