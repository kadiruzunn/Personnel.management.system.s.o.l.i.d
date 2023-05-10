package com.pms.erp.dal;

import java.util.ArrayList;
import java.util.List;

public interface IDAL<T> { 
	
	T ekle(T obj);
	List<T> listele();
	T guncelle(T obj);
	void sil(int id);
	T idIleGetir(int id);

}
