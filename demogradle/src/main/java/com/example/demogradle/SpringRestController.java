package com.example.demogradle;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestController 
{
	@RequestMapping(method=RequestMethod.GET,value="/getName")
	   public String readName() {		
		return "getName   method";
	}
		
	@RequestMapping(method=RequestMethod.GET,value="/getNameXml/{clientId}/{clientName}",produces="text/xml")
	   public String readNameXml(@PathVariable("clientId") String clientId ,@PathVariable("clientName") String clientName) {		
		return "<clients>\n<clientid>"+ clientId+"</clientid>\n<clientname>"+ clientName+"</clientname>\n</clients>";
		
	}
	@RequestMapping(method=RequestMethod.GET,value="/getNamejson",produces="application/json")
	   public DemoRest readNameJson() {
		DemoRest dm = new DemoRest();
		dm.setEmpNo(11);
		dm.setEmpName("mahesh");
		dm.setEmpSal(5000);
		return dm;
	}
	
}
