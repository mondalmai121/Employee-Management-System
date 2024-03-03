package org.jsp.empmvcapp.controller;

import org.jsp.empmvcapp.dao.EmployeeDao;
import org.jsp.empmvcapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeApp {

	@Autowired
	private EmployeeDao dao;
	
	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView view) {
		view.setViewName("register");
		view.addObject("e", new Employee());
		return view;
	}
	
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute Employee e, ModelAndView view) {
		e=dao.saveEmp(e);
		view.setViewName("print");
		view.addObject("message", "Employee saved successfully....");
		return view;
	}
	
	@RequestMapping("/open-update")
	public ModelAndView openUpdate(ModelAndView view) {
		view.setViewName("update");
		view.addObject("e", new Employee());
		return view;
	}
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute Employee e, ModelAndView view) {
		e=dao.updateEmp(e);
		if(e!=null) {
			view.setViewName("print");
			view.addObject("message", "Employee updated successfully.....");
			return view;
		}
		view.setViewName("print");
		view.addObject("message","Cannot update as ID id invalid");
		return view;
	}
	
	@GetMapping("/find-by-id")
	public ModelAndView findById(@ModelAttribute int id, ModelAndView view) {
		Employee e=dao.findById(id);
		if(e!=null) {
			view.setViewName("display");
			view.addObject("e", e);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Employeee not found as ID in invalid.....");
		return view;
	}
	
	@RequestMapping("/open-view")
	public String openView(String view) {
		return view;
	}
}
