package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
// servlet은 doget()이 모든역할 , class는 기능당 하나의 메소드를 가짐.
public class PhonebookController {

	// 등록폼 localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value="/phone/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public void writeForm() {
		
		System.out.println("PhonebookController>writeForm()");
	
	}
	// 등록 localhost:8080/phonebook5/phone/write?name=황일영&no=1
	public void write() {
		
	}
}
