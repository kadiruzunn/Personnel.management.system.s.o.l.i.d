package com.pms.erp.bll;

import java.util.ArrayList;
import java.util.List;

import com.pms.erp.dal.PersonelDAL;
import com.pms.erp.model.concretes.Personel;

public class PersonelBLL {
	
	PersonelDAL dal = new PersonelDAL();
	
	public Personel ekle(Personel personel) {
		
		
		return dal.ekle(personel);
		
	}
	
	public List<Personel> listele(){
		return dal.listele();
	}

	public void guncelle(Personel guncellenecekPersonel) {
		
		dal.guncelle(guncellenecekPersonel);
		
	}

}
