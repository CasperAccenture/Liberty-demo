package io.liberty.event.ui.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

@Named
@ApplicationScoped
public class TimeMapUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Map<String, Object> days;
    private static Map<String, Object> months;
    private static Map<String, Object> years;
    private static Map<String, Object> hours;

    public TimeMapUtil() {
    }

    /**
     * WebAppJSF - generate the hour and date maps
     */
    static {
        hours = new LinkedHashMap<String, Object>();
        for (int i = 0; i <= 23; i++) {
            DateFormat inputDateFormat = new SimpleDateFormat("H");
            try {
                Date date = inputDateFormat.parse(String.valueOf(i));
                DateFormat outputDateFormat = new SimpleDateFormat("hh:mm a");
                String output = outputDateFormat.format(date);
                hours.put(output, output);
            } catch (ParseException e) {
            }
        }
        days = new LinkedHashMap<String, Object>();
        for (int i = 1; i <= 31; i++) {
            days.put(String.valueOf(i), String.valueOf(i));
        }
        months = new LinkedHashMap<String, Object>();
        for (int i = 1; i <= 12; i++) {
            String monthLabel = new DateFormatSymbols().getMonths()[i - 1];
            months.put(monthLabel, monthLabel);
        }
        years = new LinkedHashMap<String, Object>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 5; i++) {
            years.put(String.valueOf(i), String.valueOf(i));
        }
    }

    public static Map<String, Object> getHours() {
        return hours;
    }

    public static Map<String, Object> getDays() {
        return days;
    }

    public static Map<String, Object> getMonths() {
        return months;
    }

    public static Map<String, Object> getYears() {
        return years;
    }

    /**
     * Mapped the stored time string into a user readable Date object.
     */
    public static String getMappedDate(String storedTime) {
        DateFormat inputDateFormat = new SimpleDateFormat("M d yyyy H");
        try {
            Date date = inputDateFormat.parse(storedTime);
            DateFormat outputDateFormat = new SimpleDateFormat("MMMM d, yyyy, hh:mm a");
            String output = outputDateFormat.format(date);
            return output;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}