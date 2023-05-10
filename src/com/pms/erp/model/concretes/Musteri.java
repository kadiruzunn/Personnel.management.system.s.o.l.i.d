package com.pms.erp.model.concretes;

import com.pms.erp.model.abstracts.IOdeme;

public class Musteri extends Kisi implements IOdeme{
	
	private double borc;

	public double getBorc() {
		return borc;
	}

	public void setBorc(double borc) {
		this.borc = borc;
	}

	@Override
	public boolean odemeYap(double miktar) {
		// TODO Auto-generated method stub
		return true;
	}

	public String toCSVString() {
			// TODO Auto-generated method stub
			return String.format("%d;%s;%s;%s;%s;%.2f;\r", 
					getId(), getTcKimlikNo(), ad,soyad,getDogumTarihi().toString(), borc);
		}	
	
	
}
