package fis.java.topic2.model;

import java.util.Objects;

public class SinhVien {

	private String masv;
	private String ten;
	private BangDiem bangDiem;

	private SinhVien() {

	}

	private SinhVien(SinhVien.Builder builder) {
		this.masv = builder.masv;
		this.ten = builder.ten;
		this.bangDiem = builder.bangDiem;
	}


	public BangDiem getBangDiem() {
		return bangDiem;
	}
	
	public String getMasv() {
		return masv;
	}

	public String getTen() {
		return ten;
	}

	public static class Builder {
		private String masv;
		private String ten;
		private BangDiem bangDiem;
		
		public SinhVien.Builder masv(String masv){
			this.masv = masv;
			return this;
		}
		public SinhVien.Builder ten(String ten){
			this.ten = ten;
			return this;
		}
		public SinhVien.Builder bangDiem(BangDiem bangDiem){
			this.bangDiem = bangDiem;
			return this;
		}
		
		public SinhVien build() {
			return new SinhVien(this);
		}
	}

	// Xem ky dinh nghia giong nhau
	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (!(that instanceof SinhVien))
			return false;
		SinhVien thatSinhVien = (SinhVien) that;
		return this.ten.equals(thatSinhVien.ten) && this.masv.equals(thatSinhVien.masv);
	}
	
	
	//
	// Cau 1 : Sinh vien chi co the dang ky hoc 1 mon hoc khi
	// - Mon hoc do nam trong chuong trinh.
	// - Sinh vien phai chua dau mon hoc do
	// - Phai dau tat ca cac mon tien quyet cua mon hoc do.
	// Chu y:
	// Mon hoc co nhieu diem diem cua mon do la diem cuoi cung
	// Doc yeu cau that ky nha neu ko thoa thi ko co diem dau do
	public boolean coTheDangKyHoc(MonHoc monHoc) {
		// TODO
		return monHoc.coTrongChuongTrinh(ChuongTrinhHoc.SINGLETON)
				&& !monHoc.daDauChua(this) && monHoc.daDauTienQuyetChua(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(masv, ten);
	}

	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", ten=" + ten + ", bangDiem=" + bangDiem + "]";
	}

	
}
