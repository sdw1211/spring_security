package kr.otawang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.otawang.error.NotFoundException;



@Controller
public class CustomErrorController extends AbstractErrorController {

	@Autowired
	public CustomErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	@ExceptionHandler(NotFoundException.class)
	public String notFound() {
		return "404";
	}
	
	@RequestMapping("/error")
	public ResponseEntity<?> handerErrors(HttpServletRequest request) {
		HttpStatus status = getStatus(request);
		
		if (status.equals(HttpStatus.NOT_FOUND)) {
			throw new NotFoundException();
		} 
		
		return ResponseEntity.status(status).body(getErrorAttributes(request, false));
	}
	
}
