package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captal.account.Model.CapitalAccountClass;
import com.captal.account.Model.Customer;
import com.example.demo.dao.VendingMachineDao;
import com.example.demo.model.Product;



@RestController 
public class ProductController {

@Autowired 
VendingMachineDao repo;

	
//Create new product by suppliers 
@GetMapping("/product/new")
public String addProduct(Model model)	
{
	model.addAttribute("product",new Product());
	return "create_form.html";
}
	
//save the Product got added 
@PostMapping("/product/save")

public String saveProduct(Product product)
{
	
	repo.save(product);
	
	   	
	return "product_form.html";
	

}

//Manipulating coins

@GetMapping("manipulateCoin/{coin}")
public String manipulateCoin(@PathVariable (value ="cost" ) int coin ,Model model )	
{
	
	Product ca=repo.findByCost(coin);
	
	double tot_cost [];
	for(int i=0;i<tot_cost.length;i++)
	{
    if(ca.getCost()==1 || ca.getCost() ==2 || ca.getCost()==5 || ca.getCost() ==10)  
      {
    	tot_cost=tot_cost[i]+ca.getCost();
    
          if(tot_cost >500 )
        	  
          {
        	System.out.println("System can not accept more then 500 rs ");
          }
      
      
      }
    else 
    {
      System,out.println("Enter valid coins");	
    }
	   
	
	
	

	return "redirect:/product/save";
}	

	//Cancel product by the user 
	@GetMapping("/CancelProduct")
	public String cancelProduct(Model model)
	{

	Product ca = new Product();

	model.addAttribute("cancel",ca);



	return "cancel.html";


	}
	//getting an id and cost  from page and based on that cancle the product  
	@GetMapping("/cancelByIdnCost")
	public String cancelByIdnCost(Model model,int id,double cost )

	{
	    int return_amt;
	        if(id !=0)
	        {
	        	 Product pcost =repo.findByCost(cost);
	        	 Product pid = repo.findById(id);
	        	 
	        	 
	        	 
	        	 
	          return_amt =pcost.getCost();
	          System.out.println("Amount should be given to the user "+return_amt);
		         if(count(pid)>120)
		         {
		        	 System.out.println("Product should not exceed 120 ");
		         }
		        	 
		         }
	          
	  	    List<Product> cart=repo.findById(id);
	  	    cart.remove(pid);   
	        }
	        	
	       
			return "redirect:/product/save";
	   
			
		
	}



@RequestMapping("/suppliers")
public String suppliersPage(Model model)	
{
	
	List<Product> listproduct= repo.findAll();
  model.addAttribute("listproduct", listproduct);
	return "suppliers.html";
}

//suppliers adding cash 
	
	@PostMapping("/SaveCoin")

public String getCash(Product product)
{
	
	repo.save(product);
                  

	return "";
}

//Taking cash from machine
	

@GetMapping("/TakeOutCoin/{coin}")

public String postCash(@PathVariable (value ="coin" ) int coin ,Model model)
{
	
	List<Product>listproduct =repo.findByCost(coin);
	
	repo.save(listproduct);
	
	return "redirect:/product/save";
}
	
}
