package r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest4 {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 20;
		try {
			rconn = new RConnection("192.168.0.103");
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/R/day04/stavg.R',encoding='UTF-8')");
			REXP rexp = rconn.eval("func1()");
			RList rlist = rexp.asList(); //데이터 프레임으로 받는다
			String name [] = rlist.at("NAME").asStrings();
			double sum [] = rlist.at("SUM").asDoubles();
			double avg [] = rlist.at("AVG").asDoubles();
			
			for(int i=0; i<name.length; i++) {
				System.out.println(name[i]+" "+sum[i]+" "+avg[i]);
			}
			
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Complete !");
		
		rconn.close();
	}

}
