package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index_Controller {
	@Autowired
	Emi_CalcDAO emiDAO;
	
	@RequestMapping("CalculateEmi")
	public ModelAndView addDetails(Emi_Calc emi)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("emiDetails", emi);
		mv.setViewName("added.jsp");
		emiDAO.save(emi);
		return mv;
	}
	
	@RequestMapping("showEmi")
	public ModelAndView showDetails(Emi_Calc emi)
	{
		ModelAndView mv = new ModelAndView();
		Optional<Emi_Calc> em = emiDAO.findById(emi.getName());
		Emi_Calc e1 = em.get();
		double principal = e1.getLoan_amt();
		double rate = e1.getInt_rate()/(12*100);
		double time = e1.getTenure()*12;
		double result = (principal*rate*Math.pow(1+rate,time))/(Math.pow(1+rate,time)-1);//Formula for calculating EMI
		mv.addObject("emiData",result);
		mv.setViewName("display.jsp");
		return mv; 
	}
	
	@RequestMapping("index")
	public ModelAndView home()
		{
			ModelAndView mv = new ModelAndView(); 
			mv.setViewName("Index.jsp");
			return mv; 	
		}

}
