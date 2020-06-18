package com.main.app.service;

import com.main.app.vo.ApplicantRequest;

public interface QrCodeGeneratorIService {
	public byte[] generateQRCodeImage(ApplicantRequest applicatRequest);

}
