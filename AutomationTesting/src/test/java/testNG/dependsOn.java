package testNG;

import org.testng.annotations.Test;

public class dependsOn {
@Test
	public void signup() {
		System.out.println("signup");
	}

@Test(dependsOnMethods = "signup")
public void login() {
	System.out.println("login");
}
@Test(dependsOnMethods = "login")
public void searchproduct() {
	System.out.println("search product");
}
@Test(dependsOnMethods = "searchproduct")
public void addtocard() {
	System.out.println("add to card");
	//throw new RuntimeException();
}
@Test(dependsOnMethods = "addtocard")
public void signout() {
	System.out.println("sign out");
}
}
