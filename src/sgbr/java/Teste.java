/**
 * 
 */
package sgbr.java;

import java.util.Calendar;

import sgbr.util.Util;

/**
 * @author Reinaldo
 *
 */
public class Teste {
	
	public static void main(String[] args) throws Exception {
		
		int nuDia = 0;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(Util.getDataHoje());
		nuDia = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(nuDia);
	}

}
