package com.pms.erp.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.pms.erp.model.concretes.Personel;

public class PersonelDAL implements IDAL<Personel> {

	private final String PERSONEL_VERILERI_DOSYA_ADI = "personeller.csv";

	private final String BASARI_MESAJI = "Successfully wrote to the file.";

	private static int idCounter = 0;

	@Override
	public Personel ekle(Personel personel) {

		List<Personel> personelListesi = listele();

		if (personelListesi.size() == 0) {
			idCounter++;
		} else {
			Personel listedekiSonPersonel = personelListesi.get(personelListesi.size() - 1);
			int sonId = listedekiSonPersonel.getId();
			idCounter = sonId + 1;
		}

		personel.setId(idCounter);

		dosyayaEkle(personel);

		return personel;

	}

	private void dosyayaEkle(Personel obj) {

		try {
			FileWriter myWriter = new FileWriter(PERSONEL_VERILERI_DOSYA_ADI, true);
			String csv = obj.toCSVString();
			myWriter.write(csv);
			myWriter.close();
			System.out.println(BASARI_MESAJI);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@Override
	public List<Personel> listele() {
		List<Personel> personeller = new ArrayList<>();

		try {

			File file = new File(PERSONEL_VERILERI_DOSYA_ADI);
			Scanner myReader = new Scanner(file);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] arr = data.split(";");

				Personel personel = new Personel();
				personel.setId(Integer.valueOf(arr[0]));
				personel.setTcKimlikNo(arr[1]);
				personel.setAd(arr[2]);
				personel.setSoyad(arr[3]);
				personel.setDogumTarihi(LocalDate.parse(arr[4]));
				String maas = arr[5];
				maas = maas.replace(",", ".");
				personel.setMaas(Double.valueOf(maas));

				personeller.add(personel);

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return personeller;
	}

	@Override
	public Personel guncelle(Personel obj) {

		List<Personel> liste = listele();

		int guncellenecekIndex = -1;
		
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getId() == obj.getId()) {
				guncellenecekIndex = i;
			}
		}
		
		if(guncellenecekIndex != -1) {
			
			liste.set(guncellenecekIndex, obj);
			
			dosyadakiVerileriSil();

			dosyayaTopluVeriEkle(liste);
		}
		
		return obj;
	}

	// batch 
	private void dosyayaTopluVeriEkle(List<Personel> liste) {

		try {
			FileWriter myWriter = new FileWriter(PERSONEL_VERILERI_DOSYA_ADI, true);
			
			for (Personel personel : liste) {
				String csv = personel.toCSVString();
				myWriter.write(csv);
			}

			
			myWriter.close();
			System.out.println(BASARI_MESAJI);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void dosyadakiVerileriSil() {

		try {
			FileWriter myWriter = new FileWriter(PERSONEL_VERILERI_DOSYA_ADI);
			myWriter.write("");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@Override
	public void sil(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Personel idIleGetir(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
