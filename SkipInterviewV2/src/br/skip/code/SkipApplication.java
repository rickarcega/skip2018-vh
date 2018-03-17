package br.skip.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import br.skip.code.model.ProductBO;

public class SkipApplication {

	private static final Logger log = LoggerFactory.getLogger(SkipApplication.class);

	@Controller
	@EnableAutoConfiguration
	public static class SampleController {

		public static void main(String[] args) throws Exception {
			
			//Turn s TOMCAT UP and application as well.
			SpringApplication.run(SampleController.class, args);
		
		}
		
		 
		//Query Product
		@RequestMapping("/product/")
		@ResponseBody
		public static String getProduct() {

			ProductBO productBean = new ProductBO();

			String htmlView = "<h1>Display only one product </h1><br>";
					
			
			try {
			
				RestTemplate restTemplate = new RestTemplate();
				productBean = restTemplate.getForObject("http://api-vanhack-event-sp.azurewebsites.net/api/v1/Product/1", ProductBO.class);
			
				htmlView+= "<p>" + productBean.getName() + "</p>";
				
				log.info(productBean.getName());
				
				return htmlView ;

			} catch (Exception e) {
				e.printStackTrace();
				return "Something went wrong";
			}
			

		}

		//Query Product
		@RequestMapping("/productList/")
		@ResponseBody
		public static String getAllProduct() {
	
			RestTemplate restTemplate = new RestTemplate();
			try {
				//TO many GENERICS... Change it to explicitly use a Object Reference
				List<LinkedHashMap<String, Object>> producstMap = restTemplate.getForObject("http://api-vanhack-event-sp.azurewebsites.net/api/v1/Product/", List.class);
		        
				String htmlView = "<h1>Display a list of available products </h1><br><br><ul>";
				
		        if(producstMap!=null){
		        	
		        		for(LinkedHashMap<String, Object> map : producstMap){
		        			
		        			//I'll create a object reference to map appropriate to use as a Object not only as a String into a Hashmap
		        			htmlView += "<li> Product Nanme: " + map.get("name") + "</li>";
		            }
		            
		        }
		        htmlView += "</ul>";
		        return htmlView;
				
			}catch (Exception e) {				
				e.printStackTrace();
				return "Something went wrong";
			}
			
		}
		
	
		
		
		
	}
}
