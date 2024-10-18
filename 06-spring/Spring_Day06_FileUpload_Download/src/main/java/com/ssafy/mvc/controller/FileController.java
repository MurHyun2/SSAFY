package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	// 스프링에서 파일이나 클래스 등등 리소스를 로드할때는 ResourceLoader 인터페이스를 이용해서 가져온다.
	private final ResourceLoader resourceLoader;

	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@GetMapping("singleFileForm")
	public String singleFileForm() {
		return "singleFileForm";
	}

	@PostMapping("singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
			throws IllegalStateException, IOException {
		// File이 있는지 검사
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename().length());
		
		//file이 없으면 getOriginalFilename().length()가 0이 된다.
		if (file != null && file.getOriginalFilename().length() > 0) {
			String fileName = file.getOriginalFilename();
			// 코드로 img 폴더를 가지고 와야겠다
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			file.transferTo(new File(resource.getFile(), fileName));

			model.addAttribute("fileName", fileName);
		}

		return "result";
	}

	@GetMapping("download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);

		return "fileDownloadView";
	}

	@GetMapping("multiFileForm")
	public String multiFileForm() {
		return "multiFileForm";
	}
	
	@PostMapping("multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files, Model model)
			throws IllegalStateException, IOException {

		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		return "result";
	}
}
