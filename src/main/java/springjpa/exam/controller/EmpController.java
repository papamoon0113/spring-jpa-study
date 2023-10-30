package springjpa.exam.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> 04bb78d (study spring data jpa and spring boot test)
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import springjpa.exam.entity.Emp;
import springjpa.exam.repository.EmpRepository;

@Controller
@RequiredArgsConstructor
public class EmpController {
	
	private final EmpRepository dao;
	
<<<<<<< HEAD
	@GetMapping("/countnum") // 수정
	public ModelAndView count() {
		ModelAndView mav = new ModelAndView();
		long num = dao.count();
		mav.addObject("num", num);
		mav.setViewName("empResult");
		return mav;
=======
	@GetMapping("/countnum")
	@ResponseBody
	public long count() {
		return dao.count();
>>>>>>> 04bb78d (study spring data jpa and spring boot test)
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Emp> list = dao.findAll();
		list.parallelStream().forEach(System.out::println);
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}
	
	@GetMapping("/part")
	public ModelAndView part(int page, int size) {  // page : 0~
		ModelAndView mav = new ModelAndView();
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Emp> pageObj = dao.findAll(pageRequest);
		List<Emp> list = pageObj.toList();
		mav.setViewName("empResult");
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/partsal")
	public ModelAndView partsal(int page, int size) {
		ModelAndView mav = new ModelAndView();
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("sal").descending());
		Page<Emp> pageObj = dao.findAll(pageRequest);
		List<Emp> list = pageObj.toList();
		mav.setViewName("empResult");
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/parthiredate")
	public ModelAndView parthiredate(int page, int size) {
		ModelAndView mav = new ModelAndView();
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("hiredate"));
		Page<Emp> pageObj = dao.findAll(pageRequest);
		List<Emp> list = pageObj.toList();
		mav.setViewName("empResult");
		mav.addObject("list", list);
		return mav;
	}

}
