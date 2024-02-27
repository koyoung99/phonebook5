package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;

	// controller > service > dao

	// 등록
	// write2() >exeWrite() > personInserts
	// write2
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		// dao를 메모리에 올리기
		// PhonebookDao phonebookDao = new PhonebookDao();

		// dao.personInsert(vo) 저장하기
		// phonebookDao.personInsert(personVo);

		// 비지니스로직 필요
		// phonebook5 비지니스로직 필요X
		// PhonebookDao phonebookDao = new PhonebookDao();

		int count = phonebookDao.personInsert(personVo);

		return count;
	}

	
	// 삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete");

	// 	PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personDelete(no);

		return count;

	}
	
	// 수정폼
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		// PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(no);
		
		return personVo;
	}

	//수정
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		// PhonebookDao phonebookDao = new PhonebookDao();
		int count=phonebookDao.personUpdate(personVo);

		return count;
	}
	
	
	// 리스트
	public List<PersonVo> exeList() {
		
		System.out.println("PhonebookService.exeList()");
		
		// PhonebookDao phonebookDao = new PhonebookDao();
		List<PersonVo> personList = phonebookDao.personSelect();

		return personList;
	}
}
