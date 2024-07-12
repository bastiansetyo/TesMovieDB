package com.project.tesMovie.common;

public enum Day {
    MINGGU("hari Minggu", 1),
    SENIN("hari Senin",2),
    SELASA("Hari Selasa",3),
    RABU("Hari Rabu",4),
    KAMIS("Hari Kamis",5),
    JUMAT("Hari Jumat",6),
    SABTU("Hari Sabtu",7);
    private final String day;
private final int num;
    Day(String day, int num) {
        this.day = day;
        this.num = num;
    }

    public String getday() {
        return day;
    }
    public int getnum(){
        return num;
    }

    public static Day ambil(int num) {
        for (Day diy : Day.values()) {
            if (diy.getnum() == num) {
                return diy;
            }
        }
        return null;
    }

}

