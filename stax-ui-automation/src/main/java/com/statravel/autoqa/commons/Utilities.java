package com.statravel.autoqa.commons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class Utilities {

    public static final int TIME_INTERVAL_FOR_FIVE_SECONDS = 5;
    public static final int TIME_INTERVAL_FOR_THREE_SECONDS = 3;
    public static final int MULTIPLY_BY_THOUSAND = 1000;
    public static final int TIME_INTERVAL_FOR_ONE_SECOND = 1;
    public static final int STRING_OF_HUNDRED_AND_ONE_CHRACTOR = 101;
    public static final int STRING_OF_NINTY_SIX_CHRACTOR = 96;
    public static final int TIME_INTERVAL_FOR_TWO_SECOND = 2;

    /**
     * 
     * @return current date in Date format.
     * @throws ParseException
     *             ParseException
     */
    public Date getCurrentDate() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        return dateFormat.parse(date1);

    }

    /**
     * sleep for given second.
     * 
     * @param time
     *            time
     */
    public void timeInterval(final int time) {
        try {
            Thread.sleep(time * MULTIPLY_BY_THOUSAND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * get random special character except -,*.
     * 
     * @return special character
     */
    public char randomChar() {
        char[] spl = { '!', '"', '£', '@', '#', '$', '%', '^', '&', '(', ')' };
        Random r = new Random();
        int low = 0;
        int high = spl.length;
        int result = r.nextInt(high - low) + low;
        return spl[result];
    }

    /**
     * get random alphabet string as length given.
     * 
     * @param lenghtOfNumber
     *            Length Of Number
     * @return generate random alphabet
     * 
     */
    public String getRandomString(final int lenghtOfNumber) {
        return RandomStringUtils.randomAlphabetic(lenghtOfNumber);
    }

    /**
     * get random numeric number as length given.
     * 
     * @param lenghtOfNumber
     *            Length Of Number
     * @return generate random numeric
     * 
     */
    public String getRandomNumericNumber(final int lenghtOfNumber) {
        return RandomStringUtils.randomNumeric(lenghtOfNumber);
    }

}
