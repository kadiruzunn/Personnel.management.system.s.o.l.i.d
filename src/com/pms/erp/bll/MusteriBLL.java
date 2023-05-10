package com.pms.erp.bll;

import com.pms.erp.dal.MusteriDAL;
import com.pms.erp.dal.PersonelDAL;
import com.pms.erp.model.concretes.Musteri;

public class MusteriBLL {

	public Musteri ekle(Musteri musteri) {

		MusteriDAL dal = new MusteriDAL();
		musteri = dal.ekle(musteri);
		return musteri;

	}

}
