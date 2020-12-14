package r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest3 {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 10;
		try {
			rconn = new RConnection("192.168.0.103");
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/R/day04/stchart.R',encoding='UTF-8')");
			rconn.eval("func1()");

			
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Complete !");
		
		rconn.close();
	}

}
