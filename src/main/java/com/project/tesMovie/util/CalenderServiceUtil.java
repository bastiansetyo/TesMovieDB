package com.project.tesMovie.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderServiceUtil {

    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String setMonth(int bulan) {
        if (bulan == Calendar.JANUARY) {
            return "Januari";
        } else if (bulan == Calendar.FEBRUARY) {
            return "Februari";
        } else if (bulan == Calendar.MARCH) {
            return "Maret";
        } else if (bulan == Calendar.APRIL) {
            return "April";
        } else if (bulan == Calendar.MAY) {
            return "Mei";
        } else if (bulan == Calendar.JULY) {
            return "Juni";
        } else if (bulan == Calendar.JUNE) {
            return "Juli";
        } else if (bulan == Calendar.AUGUST) {
            return "Agustus";
        } else if (bulan == Calendar.SEPTEMBER) {
            return "September";
        } else if (bulan == Calendar.OCTOBER) {
            return "Oktober";
        } else
            return "Desember";
    }

    public String setDays(int hari) {
        if (hari == 1)
            return "Minggu";
        else if (hari == 2) {
            return "Senin";
        } else if (hari == 3) {
            return "Selasa";
        } else if (hari == 4) {
            return "Rabu";
        } else if (hari == 5) {
            return "Kamis";
        } else if (hari == 6) {
            return "Jumat";
        } else
            return "Sabtu";

    }
}
