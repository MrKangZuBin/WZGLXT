package com.kang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kang.pojo.ProvinceCity;
import com.kang.service.AreasService;

@Controller
@RequestMapping("area")
public class AreaController {
	
	@Autowired 
    private AreasService areasService;  
	@RequestMapping("getNationality")
	@ResponseBody
	 public List<ProvinceCity> getNationality(){  
        List<ProvinceCity> areas=areasService.queryAreas(0);  
        return areas;  
    }
	@RequestMapping("getProvince")
	@ResponseBody
	 public List<ProvinceCity> getProvince(Integer id){  
        List<ProvinceCity> areas=areasService.queryAreas(id);  
        return areas;  
    }
	@RequestMapping("getCity")
	@ResponseBody
	 public List<ProvinceCity> getCity(Integer id){  
        List<ProvinceCity> areas=areasService.queryAreas(id);  
        return areas;  
    }
}
