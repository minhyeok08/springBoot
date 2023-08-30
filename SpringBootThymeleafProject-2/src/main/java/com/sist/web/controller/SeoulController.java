package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.entity.*;
import com.sist.web.dao.*;
@Controller
public class SeoulController {
	@Autowired
	private LocationDAO dao;
	
	@RequestMapping("food/seoul_location")
	public String Location_find(String page,Model model)
	{
		
		if(page==null)
			page="1";
		
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage*rowSize)-(rowSize); 
		
		List<SeoulLocationEntity> list=dao.SeoulFindData(start);
		int totalpage = dao.SeoulTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		
		return "food/seoul_location";	
	}
}
