package org.ecomm.tests;

import org.ecomm.Baseclass.BaseClass;
import org.ecomm.pages.Homepage;
import org.ecomm.pages.ProductListPage;
import org.ecomm.pages.Productdetailpage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsearchTest extends BaseClass{
	
	public Homepage homepage;
	public ProductListPage plpage;
	public Productdetailpage pdpage;
	public String Res_text;
	
	@Test
	public void SearchaProduct() {
		
		homepage = new Homepage(driver);
		homepage.ClickSearchicon();
		plpage = homepage.Enterproductname(GetProperty("Productname")); 
		Assert.assertTrue(plpage.Validatesearchresult()); 
		Res_text = plpage.Getsearchresulttext();
		  
		  if (Res_text.contains("Showing")){
			  System.out.println("Pass"); 
			  } else if (Res_text.contains("No")) {
		  System.out.println("Wrong Product name passed to the search"); 
			  }
		  }
	
	@Test
	public void clickSeconditem() {
		Assert.assertTrue(plpage.seconditemexist());
		pdpage = plpage.Selectseconditem();
		Assert.assertTrue(pdpage.productnameheaderexist());
	}
	

}
