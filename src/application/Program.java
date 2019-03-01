package application;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Program {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/Temp/Pasta1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		Locale.setDefault(new Locale("en", "US"));
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Date d = Date.from(Instant.parse("2019-02-28T09:01:01Z"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.SECOND, 1);
		d = cal.getTime();
		Integer interval = 1;
		Double value = 9.0;
		DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
		for (int i = 0; i < 1500000; i++) {
			interval++;
			if (interval == 15)
			{
				cal.add(Calendar.SECOND, 1);
				d = cal.getTime();
				interval = 1;
			}
			double numero = (Math.round(Math.random() * 4)-2.0)/100.0;
			value += numero;
			bw.write("PETR4:"+sdf.format(d)+":"+new Double(df2.format(value)).doubleValue());
			bw.newLine();
		}
		bw.close();
		System.out.println("Finalizado!");
	}

}
