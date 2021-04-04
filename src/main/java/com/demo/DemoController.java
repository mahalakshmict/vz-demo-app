package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class DemoController {
	public static String artifactory() {
		return "https://192.168.130.23";
	}
	public static String pgadmin() {
		return "https://192.168.130.21/pgadmin4";
	}
	public static String adminer() {
		return "https://192.168.130.21/adminer";
	}
}
