package lu.lllc.boottest.controller;

import lu.lllc.boottest.ftp.CamelExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String hello(){

		CamelExecutor executor = new CamelExecutor();

		try {
			executor.init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "hello";
	}
}
