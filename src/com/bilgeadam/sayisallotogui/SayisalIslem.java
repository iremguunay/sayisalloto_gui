package com.bilgeadam.sayisallotogui;

import java.util.Arrays;
import java.util.Random;

public class SayisalIslem {

    public static final int MAX_SAYI = 49;
    public static final int KAC_SAYI = 6;

    public int rastgeleSayiGetir() {
        Random rnd = new Random();
        int sayi = rnd.nextInt(MAX_SAYI)+1;
        return sayi;
    }

    public boolean arraydeVarMi(int[] sayilar, int sayi) {

        //Aramak için binarySearch kullanılır.
        //Onun şartı da önce sort edilmiş olması.

        Arrays.sort(sayilar);

        int sonuc = Arrays.binarySearch(sayilar, sayi);

        if (sonuc >= 0)
            return true;
        else
            return false;
    }

    public int[] arrayDoldur() {
        int[] sayilar = new int[KAC_SAYI];

        int rastgeleSayi = 0;

        for (int i = 0; i < sayilar.length; i++) {

            rastgeleSayi = rastgeleSayiGetir();

            boolean sonuc = arraydeVarMi(sayilar, rastgeleSayi);
            while (sonuc == true) {
                rastgeleSayi = rastgeleSayiGetir();
                sonuc = arraydeVarMi(sayilar, rastgeleSayi);
            }

            sayilar[0] = rastgeleSayi;
        }

        Arrays.sort(sayilar);

        return sayilar;
    }
}
