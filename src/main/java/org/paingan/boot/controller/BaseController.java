package org.paingan.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	// inject via application.properties
	@Value("${header.title:Speed Monitoring Tools}")
	protected String title;
}
