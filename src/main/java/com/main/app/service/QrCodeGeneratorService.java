package com.main.app.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.main.app.vo.ApplicantRequest;

@Service
public class QrCodeGeneratorService implements QrCodeGeneratorIService {
	@Override
	public byte[] generateQRCodeImage(ApplicantRequest applicatRequest) {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix;
		byte[] jpgData = null;
		try {
			bitMatrix = qrCodeWriter.encode(applicatRequest.getEmail(), BarcodeFormat.QR_CODE,
					applicatRequest.getWidth(), applicatRequest.getHeight());

			ByteArrayOutputStream jpgOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "jpg", jpgOutputStream);
			jpgData = jpgOutputStream.toByteArray();

		} catch (WriterException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return jpgData;

	}

}
