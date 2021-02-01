package com.usk.springbootfile.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usk.springbootfile.constants.FileConstants;

@RestController
@RequestMapping("/file")
public class FileUploadController {

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "Please select the file.";
		}
		File newFile = new File(FileConstants.UPLOADED_FOLDER + file.getOriginalFilename());
		System.out.println("newFile ==========>> " + newFile);
		try {
			newFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(newFile);
			fout.write(file.getBytes());
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
			return "Check your file and try again";
		}
		return "File is uploaded successfully";
	}
}
