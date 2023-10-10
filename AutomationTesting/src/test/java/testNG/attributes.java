package testNG;

import org.testng.annotations.Test;

public class attributes {
@Test(priority = 1)
	public void signup() {
		System.out.println("sign up");
	}
@Test(priority = 2)
    public void login() {
	System.out.println("login");
}
@Test(priority = 3)
    public void searchproduct() {
    	System.out.println("search product");
    }
@Test(priority = 4)
    public void addtocard() {
    	System.out.println("add to card");
    }
@Test(priority = 5)
    public void signout() {
    	System.out.println("sign out");
    }
}
