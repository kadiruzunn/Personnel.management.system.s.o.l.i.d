package com.pms.erp;

import java.util.Scanner;

import com.pms.erp.model.concretes.Kisi;
import com.pms.erp.model.concretes.Musteri;
import com.pms.erp.model.concretes.Personel;
import com.pms.erp.presentation.layer.AltMenu;
import com.pms.erp.presentation.layer.AnaMenu;
import com.pms.erp.presentation.layer.MenuManager;

class Program {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		MenuManager menu = new MenuManager();
		// menu.bll.ekle(null);

		while (true) {
			menu.anaMenuGoster();

			int anaMenuSecim = scanner.nextInt();

			String anaMenu = AnaMenu.values()[anaMenuSecim - 1].toString();

			menu.altMenuGoster(anaMenu);

			int altMenuSecim = scanner.nextInt();

			String altMenu = AltMenu.values()[altMenuSecim - 1].toString();

			if (anaMenu.equals("Personel") && altMenu.equals("EKLE")) {
				Personel personel = menu.personelEkleMenusuAltMenuGoster();
				System.out.println(personel.toCSVString());
			} else if (anaMenu.equals("Musteri") && altMenu.equals("EKLE")) {
				Musteri musteri = menu.musteriEkleMenusuAltMenuGoster();
				System.out.println(musteri.toCSVString());
			} else if (anaMenu.equals("Tedarikci") && altMenu.equals("EKLE")) {
				menu.tedarikciEkleMenusuAltMenuGoster();
			} else if (anaMenu.equals("Personel") && altMenu.equals("LISTELE")) {
				menu.personelListele();
			} else if (anaMenu.equals("Personel") && altMenu.equals("GUNCELLE")) {
				menu.personelGuncelle();
			}
		}
	}
}
