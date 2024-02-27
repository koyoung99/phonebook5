package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
// servlet은 doget()이 모든역할 , class는 기능당 하나의 메소드를 가짐.
public class PhonebookController {

	// 메모리에 올려줘
	@Autowired
	private PhonebookService phonebookService;

	// 삭제
	@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhonebookController>delete()");

		System.out.println(no);

		phonebookService.exeDelete(no);

		return "redirect:/phone/list";
	}

	// 수정폼
	@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {

		System.out.println("PhonebookController>modifyForm()");

		PersonVo personVo = phonebookService.exeModifyForm(no);

		model.addAttribute("personVo", personVo);

		// spring-servlet.xml 기본뷰리졸버 /WEB-INF/phone/.jsp 지우기
		// redirect 는 그대로
		return "modifyForm";
	}

	// 수정
	@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController>modify()");

		System.out.println(personVo);

		// PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeModify(personVo);

		return "redirect:/phone/list";
	}

	// 등록폼 localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value = "/phone/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		System.out.println("PhonebookController>writeForm()");

		return "writeForm";

	}

	// 등록1 localhost:8080/phonebook5/phone/write?name=황일영&no=1
	@RequestMapping(value = "/phone/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam(value = "name") String name, @RequestParam(value = "hp") String hp,
			@RequestParam(value = "company") String company) {

		System.out.println("PhonebookController>write()");

		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);

		// vo로 묶기
		PersonVo personVo = new PersonVo(name, hp, company);

		// PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeWrite(personVo);

		// list로 redirect
		return "redirect:/phone/list";

	}

	// 등록2 localhost:8080/phonebook5/phone/write2?name=황일영&no=1
	@RequestMapping(value = "/phone/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@ModelAttribute PersonVo personVo) {

		System.out.println("PhonebookController>write()");

		System.out.println(personVo.toString());

		// 어플리케이이션 아키텍쳐
		// service를 메모리에 올리고, service의 메소드 사용
		// PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeWrite(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";

	}

	// 리스트
	@RequestMapping(value = "/phone/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("phonebookController.list()");
		
		// 자동연결
		// PhonebookService phonebookService = new PhonebookService();
		List<PersonVo> personList = phonebookService.exeList();

		model.addAttribute("pList", personList);

		return "list";
	}

}
