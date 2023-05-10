package com.pms.erp.model.concretes;


public final class Personel extends Kisi {

		private double maas;
		
		public Personel() {
			// TODO Auto-generated constructor stub
		}
		
		public Personel(double maas) {
			this.maas = maas;
		}

		public void setMaas(double maas) {
			this.maas = maas;
		}

		public double getMaas() {
			return maas;
		}
		// serialization : serileştirme
		public String toCSVString() {
			// TODO Auto-generated method stub
			return String.format("%d;%s;%s;%s;%s;%.2f;\r", 
					getId(), getTcKimlikNo(), ad,soyad,getDogumTarihi().toString(), maas);
		}	
}
