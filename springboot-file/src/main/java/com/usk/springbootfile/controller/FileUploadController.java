package com.usk.springbootfile.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usk.springbootfile.constants.FileConstants;
import com.usk.springbootfile.dto.RequestDto;

@RestController
@RequestMapping("/file")
public class FileUploadController {

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "Please select the file.";
		}
		saveFile(file);
		return "File is uploaded successfully";
	}

	@PostMapping(value = "/uploads", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFiles(@RequestBody RequestDto requestDto,  @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2) {
		if (file1.isEmpty()) {
			return "Please select the file.";
		}
		System.out.println("=====>> "+requestDto.getName());
		System.out.println("=====>> "+requestDto.getDesc());
		saveFile(file1);
		saveFile(file2);
		return "File is uploaded successfully";
	}

	private void saveFile(MultipartFile file1) {
		File newFile = new File(FileConstants.UPLOADED_FOLDER + file1.getOriginalFilename());
		System.out.println("newFile ==========>> " + newFile);
		try {
			newFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(newFile);
			fout.write(file1.getBytes());
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
