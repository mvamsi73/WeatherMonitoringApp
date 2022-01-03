package EpochToDateConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class EpochToDateConverter 
{
	public static void getDate(long epoch)
	{
		Date date = new Date(epoch);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);
        System.out.println(formatted);
        format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        formatted = format.format(date);
        System.out.println(formatted);
	}
	public static void main(String[] args) {
		EpochToDateConverter.getDate(System.currentTimeMillis()/1000);
	}

}
