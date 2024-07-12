package com.project.tesMovie.service;

import com.project.tesMovie.common.Day;
import com.project.tesMovie.dto.HariDto;
import com.project.tesMovie.dto.TestDto;
import com.project.tesMovie.dto.concatDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.project.tesMovie.util.CalenderServiceUtil.dateToString;
import static com.project.tesMovie.util.CalenderServiceUtil.setMonth;
import static java.lang.Integer.parseInt;

@Slf4j
@Service
public class CalenderServiceImpl implements CalenderService {

    @Override
    @SneakyThrows
    public String DateHidden(String hehe) {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        rightNow.setTime(formatter.parse(hehe));
        int hari = rightNow.get(Calendar.DAY_OF_WEEK);
        int bulan = rightNow.get(Calendar.MONTH);
        int tahun = rightNow.get(Calendar.YEAR);
        int Hari = rightNow.get(Calendar.DAY_OF_MONTH);
        int Bulan = bulan + 1;
        // Day num = num.getnum();
        Day diy = Day.ambil(hari); //pada enum hari diy sama dengan day enum dari hari sesuai tanggal sekarang
        return ("hari : " + diy + " " + "bulan : " + setMonth(bulan) + " " + "Calendar : " + Hari + " " + " - " + Bulan + " " + " - " + tahun + " ");

    }

    public Integer kalkuHidden() {
        int hasil = 0;
        int angka1 = 20;
        int angka2 = 10;
        int kasus = 4;
        switch (kasus) {
            case 1:
                hasil = (angka1 + angka2);
                break;
            case 2:
                hasil = (angka1 - angka2);
                break;
            case 3:
                hasil = (angka1 * angka2);
                break;
            case 4:
                hasil = (angka1 / angka2);
                break;
        }
        return hasil;
    }

    public String hasilHidden(TestDto input) {
        int angka1 = input.getIsNum1();
        int angka2 = input.getIsNum2();
        int proses = input.getIsProses();
        int hasil = 0;
        switch (proses) {
            case 1:
                hasil = (angka1 + angka2);
                break;
            case 2:
                hasil = (angka1 - angka2);
                break;
            case 3:
                hasil = (angka1 * angka2);
                break;
            case 4:
                hasil = (angka1 / angka2);
                break;


        }
        return ("hasilnya adalah " + hasil);

    }

    public String HasilHidden(String input) {
        int karakter = 0;
        int bilangan = 0;
        int spasi = 0;
        int lainnya = 0;
        for (int i = 0; i < input.length(); i++) {
            char nilai = input.charAt(i);
            if (Character.isLetter(nilai))
                karakter++;
            else if (Character.isDigit(nilai)) {
                bilangan++;
            } else if (Character.isSpaceChar(nilai)) {
                spasi++;
            } else
                lainnya++;
        }
        return ("Hasil dari inputan : " + input + " " + "Karakter : " + karakter + " " + "Bilangan : " + bilangan + " " + "Spasi : " + spasi + " " + "Karakter Lain : " + lainnya);
    }

    public String ManipulasiTanggal(HariDto input) throws ParseException {
        int Hari;
        int Bulan;
        int Tahun;
        int tambah;
        int minDay;
        int maxDay;
        int tambahan;
        int minday;
        int bulan;


        List<String> date = List.of(input.getDate().split("-")); // menampung data dinamis dengan array dgn nama date = list dari request input untuk mengambil date dengan split atau pemisah data dengan tanda -
        tambah = input.getBulan(); //tambah digunakan untuk menambah bulan
        Calendar now = Calendar.getInstance();
        Calendar next = Calendar.getInstance();

        now.setLenient(false);

        minDay = next.getActualMinimum(Calendar.DAY_OF_MONTH);
        now.set(parseInt(date.get(0)), parseInt(date.get(1)), parseInt(date.get(2)));//parseint untuk mengubah sebuah string ke bilangan bulat

        sesuaikanTanggal(now);
        minday = now.getActualMinimum(Calendar.DAY_OF_MONTH);
        /*if ((now.get(Calendar.MONTH) == Calendar.JANUARY) && (now.get(Calendar.DAY_OF_MONTH) == 30) && (tambah == 1 || tambah == 13 || tambah == 24))  {
            now.set(Calendar.DAY_OF_MONTH, minday);
        }*/

        tambahan = now.get(Calendar.MONTH) + tambah;
        if (tambahan % 12 == Calendar.FEBRUARY && now.get(Calendar.DAY_OF_MONTH) == 30 || tambahan % 12 == Calendar.FEBRUARY && now.get(Calendar.DAY_OF_MONTH) == 29 || tambahan % 12
                == Calendar.FEBRUARY && now.get(Calendar.DAY_OF_MONTH) == 28) {
            now.set(Calendar.DAY_OF_MONTH, minday);
        }

        next.set(now.get(Calendar.YEAR), tambahan, now.get(Calendar.DAY_OF_MONTH));
        maxDay = next.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (next.get(Calendar.DAY_OF_MONTH) == minDay) {
            next.set(Calendar.DAY_OF_MONTH, maxDay);
        }
        Hari = next.get(Calendar.DAY_OF_MONTH);
        Bulan = next.get(Calendar.MONTH);
        Tahun = next.get(Calendar.YEAR);

//        while(next.get(Calendar.YEAR) > next.get(Calendar.YEAR)-1 || next.get(Calendar.YEAR)-1 == next.get(Calendar.YEAR) && bulan <= next.get(Calendar.MONTH)) {
//            return "tanggal yang di input: " +  + " - " + setMonth(bulan) + " - " + (next.get(Calendar.YEAR)-1) + ;
//        }


        return "tanggal yang di input: " + Hari + " - " + setMonth(Bulan) + " - " + Tahun;
    }

    public static void sesuaikanTanggal(Calendar now) {
        // Mendapatkan jumlah hari maksimal dalam bulan tersebut
        int maxDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
        int minDay = now.getActualMinimum(Calendar.DAY_OF_MONTH);
        // Memeriksa dan menyesuaikan tanggal jika melebihi jumlah hari dalam bulan tersebut
        if (now.get(Calendar.DAY_OF_MONTH) == maxDay) {
            now.set(Calendar.DAY_OF_MONTH, minDay);
        }
    }


    public String concat(concatDto input) {
        String s1;
        String s2;
        String s3;
        s1 = input.getInput1();
        s2 = input.getInput2();
        s3 = input.getInput3();
        return s1.concat(s2).concat(s3);
    }

    public List<String> manipulasiBulan(HariDto input) {
        int Hari;
        int Bulan;
        int Tahun;
        int maxday;
        List<String> Date = new ArrayList<>();
        List<String> date = List.of(input.getDate().split("-")); // menampung data dinamis dengan array dgn nama date = list dari request input untuk mengambil date dengan split atau pemisah data dengan tanda -
        Calendar now = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.set(now.get(Calendar.YEAR)-1, Calendar.DECEMBER, 1);
        maxday = start.getActualMaximum(Calendar.DAY_OF_MONTH);
        start.set(Calendar.DAY_OF_MONTH,maxday);
        Date.add(start.getTime().toString());
        now.set(parseInt(date.get(0)), parseInt(date.get(1)), parseInt(date.get(2)));//parseint untuk mengubah sebuah string ke bilangan bulat
        Hari = now.get(Calendar.DAY_OF_MONTH);
        Bulan = now.get(Calendar.MONTH);
        Tahun = now.get(Calendar.YEAR);
        for (int i = 0; i <= Bulan ;) {
            now.set(Tahun, 0 + i , Hari);
            Date.add(dateToString(now.getTime(),"dd-MM-yyyy"));
            i++;
        }
        return Date;
    }

}
