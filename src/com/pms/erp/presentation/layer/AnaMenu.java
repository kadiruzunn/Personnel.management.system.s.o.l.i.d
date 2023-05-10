package com.pms.erp.presentation.layer;

public enum AnaMenu {
	
	Personel(1),
	Musteri(2),
	Tedarikci(3);
	
	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	AnaMenu(int value) {
		this.value = value;
	}
	
}
