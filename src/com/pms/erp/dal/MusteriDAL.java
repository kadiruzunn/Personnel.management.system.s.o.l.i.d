package com.pms.erp.dal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.pms.erp.model.concretes.Musteri;

public class MusteriDAL implements IDAL<Musteri> {

	private final String PERSONEL_VERILERI_DOSYA_ADI = "musteriler.csv";

	private static int idCounter = 0;
	
	@Override
	public Musteri ekle(Musteri obj) {
		obj.setId(++idCounter);

		try {
			FileWriter myWriter = new FileWriter(PERSONEL_VERILERI_DOSYA_ADI, true);
			String csv = obj.toCSVString();
			myWriter.write(csv);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public List<Musteri> listele() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Musteri guncelle(Musteri obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sil(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Musteri idIleGetir(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
