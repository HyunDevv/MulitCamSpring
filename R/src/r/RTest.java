package r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 10;
		try {
			rconn = new RConnection("192.168.0.103");
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/R/day04/f2.R',encoding='UTF-8')");
			REXP rexp = rconn.eval("func1("+arg+")");
			int result[] = rexp.asIntegers(); // 백터형태로 받는다
			
			for(int i : result) {
				System.out.println(i);
			}
			
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Complete !");
		
		rconn.close();
	}

}
