package testNG;

import org.testng.annotations.Test;

public class groups {

		
			@Test(groups = {"smoke"})
				public void signup() {
					System.out.println("sign up");
				}
			@Test(groups = {"reg"} )
			    public void login() {
				System.out.println("login");
			}
			@Test(groups = {"sanity"})
			    public void searchproduct() {
			    	System.out.println("search product");
			    }
			@Test(groups = {"smoke"})
			    public void addtocard() {
			    	System.out.println("add to card");
			    }
			@Test(groups = {"reg"})
			    public void signout() {
			    	System.out.println("sign out");
			    }
	


	}

