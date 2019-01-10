package com.me.boot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.me.boot.controller.api.CoffeeMachineResource;
import com.me.boot.dto.DrinkDto;
import com.me.boot.model.Drink;
import com.me.boot.model.Inventory;
import com.me.boot.repository.DrinkRepository;
import com.me.boot.service.Iinventory;
import com.me.boot.serviceImpl.CoffeeService;
import com.me.boot.util.FileStorage;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/coffee")
@Slf4j
public class CoffeeMachineController {

	private Logger log=LoggerFactory.getLogger(CoffeeMachineResource.class);
	private CoffeeService coffeeService;
	private DrinkRepository drinkRepo; 
	private Iinventory inventoryService;
	private FileStorage fileStorage;
	
	public CoffeeMachineController(CoffeeService coffeeService, DrinkRepository drinkRepo, Iinventory inventoryUtil, FileStorage fileStorage) {
		super();
		this.coffeeService = coffeeService;
		this.drinkRepo = drinkRepo;
		this.inventoryService = inventoryUtil;
		this.fileStorage = fileStorage;
	}


	@GetMapping("/drink/{drinkId}")
	public String makeDrink( Model model, @PathVariable("drinkId") Long drinkId) {
		
		 DrinkDto drink = coffeeService.makeDrink(drinkId);
			
		 model.addAttribute("drink", drink);
		
		return "drink";
	}
	
	@GetMapping(value= {"/", ""})
	public String getMenu( Model model) {
		
		 List<DrinkDto> menu = coffeeService.getMenu();
		
		 model.addAttribute("menu", menu);
		
//		Map<String, Integer> ingredients = inventoryService.getIngredients();
//		Set<String> keySet = ingredients.keySet();
		
		Drink drink = new Drink();
		
		 inventoryService.getAllItems().stream()
		 				 .forEach( i -> drink
		 				 .getIngredients().put(i, 0));
		
		model.addAttribute("drink", drink);
		
		return "menu";
	}
		
	
	@PostMapping("/drink/add")
	public String orderDetail(@ModelAttribute("drink") Drink drink, @RequestParam("file") MultipartFile file,
			Model model, HttpSession session, RedirectAttributes attributes ) throws IOException {
		
		fileStorage.init(session);
		String savedFilePath = fileStorage.store(file);
		drink.setFilePath(savedFilePath);
		
		attributes.addFlashAttribute("msg", "Drink Added to our list!");
		
		drinkRepo.save(drink);
		return "redirect:/coffee";
		
	}
	
	@GetMapping("/drink/multipart/{drinkId:.+}")
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@PathVariable("drinkId") String filePath) {
		
		log.info("File Path to download is: " +filePath);
		Resource file = fileStorage.loadFile(filePath);
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			headers.setContentLength(file.contentLength());
			headers.add("Content-Disposition", "inline;filename="+file.getFilename());
			return new ResponseEntity<Resource>(file, headers, HttpStatus.OK);
			
		} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("FAIL => message: "+e.getMessage());
		}
		
	}

	
	
	
	
	
	
	/*
	 * Retrieve Files' Information
	 */
	/*@GetMapping("/files")
	public String getListFiles(Model model) {
		List<FileInfo> fileInfos = fileStorage.loadFiles().map(
					path ->	{
						String filename = path.getFileName().toString();
						String url = MvcUriComponentsBuilder.fromMethodName(DownloadFileController.class,
		                        "downloadFile", path.getFileName().toString()).build().toString();
						return new FileInfo(filename, url); 
					} 
				)
				.collect(Collectors.toList());
		
		model.addAttribute("files", fileInfos);
		return "multipartfile/listfiles";
	}
*/ 
    /*
     * Download Files
     */
/*	@GetMapping("/files/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
		Resource file = fileStorage.loadFile(filename);
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
					.body(file);	
	}
*/	
	
	
	
	
	
}
