package com.pms.erp.presentation.layer;

public enum AltMenu{
	LISTELE(1),
	ARA(2),
	EKLE(3),
	GUNCELLE(4),
	SIL(5);
	
	private int value;
	
	AltMenu(int value) {
		this.value = value;
	}

	
	public int getValue() {
		return value;
	}
}