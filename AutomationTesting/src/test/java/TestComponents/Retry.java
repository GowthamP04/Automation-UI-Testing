package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{ //--this concept we should implement only for failed cases.therefore we might be failed cases in particular failed class-->retryAnalyzer

	int count = 0; //--initial count
	int maxTry = 1; //--how many times we should retry the testcase
	
	@Override
	public boolean retry(ITestResult result) {  
		
		if(count<maxTry) {
			count++;
			return true;
		}
		return false;
	}

	
}
