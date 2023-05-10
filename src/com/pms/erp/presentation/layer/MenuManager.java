package com.pms.erp.presentation.layer;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.pms.erp.bll.MusteriBLL;
import com.pms.erp.bll.PersonelBLL;
import com.pms.erp.model.concretes.Kisi;
import com.pms.erp.model.concretes.Musteri;
import com.pms.erp.model.concretes.Personel;
import com.pms.erp.model.concretes.Tedarikci;


public class MenuManager implements IMenu {
	

	public static double PI = 3.14;
	

	private PersonelBLL personelBLL;
	private MusteriBLL musteriBLL;
	private Scanner scanner ;
	
	public MenuManager() {
		personelBLL  = new PersonelBLL();
		musteriBLL  = new MusteriBLL();
		scanner = new Scanner(System.in); 
	}
	
	
	
	@Override
	public void anaMenuGoster() {
		System.out.println("MENU");
		System.out.println("---------------");
		System.out.println("1 - Personel Menusu");
		System.out.println("2 - Müşteri Menusu");
		System.out.println("3 - Tedarikçi Menusu");
		System.out.print("Yapmak istediğiniz iş için menü no giriniz:");
	}

	@Override
	public void altMenuGoster(String secilenMenu) {

		System.out.println(secilenMenu + " MENUSU");
		System.out.println("---------------");

		System.out.println("1 - " + secilenMenu + " Listesi");
		System.out.println("2 - " + secilenMenu + " Ara");
		System.out.println("3 - " + secilenMenu + " Ekle");
		System.out.println("4 - " + secilenMenu + " Güncelle");
		System.out.println("5 - " + secilenMenu + " Sil");
		System.out.print("Yapmak istediğiniz iş için menü no giriniz:");

	}

	
	private void kisiOlusturAltMenuGoster(Kisi kisi) { 
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\nAdınız: ");
		String ad = scanner.nextLine(); 
		kisi.setAd(ad);
		
		System.out.print("Soyadınız: ");
		String soyad = scanner.nextLine();
		kisi.setSoyad(soyad);
		
		System.out.print("T.C. Kimlik No: ");
		String kimlikNo = scanner.nextLine();
		kisi.setTcKimlikNo(kimlikNo);
		
		System.out.print("Doğum Tarihiniz: ");
		String dogumTarihi = scanner.nextLine();
		kisi.setDogumTarihi(LocalDate.parse(dogumTarihi));
		
		
	}
	
	public Personel personelEkleMenusuAltMenuGoster() {
		
		Personel personel = new Personel(); 

		kisiOlusturAltMenuGoster(personel);

		System.out.print("Maaşı : ");
		String maas = scanner.nextLine();
		personel.setMaas(Double.valueOf(maas));
		
		
		return personelBLL.ekle(personel);
	}
	
	
	
	public List<Personel> personelListele() {
		
		List<Personel> liste = personelBLL.listele();

		System.out.println("PERSONEL LİSTESİ");
		System.out.println("---------------");
		System.out.println("ID\tTC Kimlik No\tAd\t\tSoyad\tMaaş");
		System.out.println("--\t------------\t--\t\t-----\t----");

		for (Personel personel : liste) {

			System.out.printf("%d\t%s\t%s\t\t%s\t%.2f\n", 
					personel.getId(), personel.getTcKimlikNo(),
					personel.getAd(), personel.getSoyad(), personel.getMaas());

		}
		
		return liste;
		
	}

	public Musteri musteriEkleMenusuAltMenuGoster() {

		Musteri musteri = new Musteri();

		kisiOlusturAltMenuGoster(musteri);

		System.out.print("Borcu : ");
		String borc = scanner.nextLine();
		musteri.setBorc(Double.valueOf(borc));
		
		musteri = musteriBLL.ekle(musteri);
		
		return musteri;
	}
	
	public Tedarikci tedarikciEkleMenusuAltMenuGoster() {

		Tedarikci tedarikci = new Tedarikci();
		
		kisiOlusturAltMenuGoster(tedarikci);
		
		System.out.print("Alacak : ");
		String alacak = scanner.nextLine();
		tedarikci.setAlacak(Double.valueOf(alacak));

		return tedarikci;
	}

	public void personelGuncelle() {
		
		List<Personel> liste = personelListele();
		 
		System.out.print("Güncellemek istediğiniz personelin Id bilgisini giriniz : ");
		
		int id = scanner.nextInt();
		
		Personel guncellenecekPersonel = null;
		
		for (Personel personel : liste) {
			
			if(personel.getId() == id) {
				guncellenecekPersonel = personel;
				break;
			}
		}
		
		kisiOlusturAltMenuGoster(guncellenecekPersonel);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Maaşı : ");
		String maas = scanner.nextLine();
		guncellenecekPersonel.setMaas(Double.valueOf(maas));
		
		personelBLL.guncelle(guncellenecekPersonel);
		
	}

}
