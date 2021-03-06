package fis.java.topic2.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;

import fis.java.topic2.common.XepLoai;

public class SinhVien implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mssv;
	private String ten;

	private Set<Diem> monDaHoc = new HashSet<Diem>();

	public SinhVien(String mssv, String ten) {
		this.mssv = mssv;
		this.ten = ten;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Set<Diem> getMonDaHoc() {
		return monDaHoc;
	}

	public void setMonDaHoc(Set<Diem> monDaHoc) {
		this.monDaHoc = monDaHoc;
	}

	public boolean themDiem(Diem diemMoi) {
		return this.monDaHoc.add(diemMoi);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof SinhVien) {
			return ((SinhVien)obj).mssv.equals(this.mssv);
		}
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public static List<SinhVien> createShortList(){
		List<MonHoc> monHoc = MonHoc.createShortList();
		List<SinhVien> list = new ArrayList<>();
		
		SinhVien sv1 = new SinhVien("SV01", "Văn Tèo");
		sv1.setMonDaHoc(new HashSet<Diem>(Arrays.asList(new Diem(monHoc.get(0), 6),
				new Diem(monHoc.get(1), 3),
				new Diem(monHoc.get(2), 7),
				new Diem(monHoc.get(3), 7))));
		list.add(sv1);
		
		SinhVien sv2 = new SinhVien("SV02", "Nguyễn Thị Nở");
		sv2.setMonDaHoc(new HashSet<Diem>(Arrays.asList(new Diem(monHoc.get(0), 4),
				new Diem(monHoc.get(1), 10),
				new Diem(monHoc.get(2), 4),
				new Diem(monHoc.get(3), 6))));
		list.add(sv2);
		
		
		SinhVien sv3 = new SinhVien("SV03", "Lê Chí Phèo");
		sv3.setMonDaHoc(new HashSet<Diem>(Arrays.asList(new Diem(monHoc.get(0), 2),
				new Diem(monHoc.get(1), 0),
				new Diem(monHoc.get(2), 7),
				new Diem(monHoc.get(3), 6))));
		list.add(sv3);
		
		
		SinhVien sv4 = new SinhVien("SV04", "Trần Văn Tí");
		sv4.setMonDaHoc(new HashSet<Diem>(Arrays.asList(new Diem(monHoc.get(0), 7),
				new Diem(monHoc.get(1), 10),
				new Diem(monHoc.get(2), 6),
				new Diem(monHoc.get(3), 6))));
		list.add(sv4);
		
		
		SinhVien sv5 = new SinhVien("SV05", "Quách Tĩnh");
		sv5.setMonDaHoc(new HashSet<Diem>(Arrays.asList(new Diem(monHoc.get(0), 10),
				new Diem(monHoc.get(1), 9),
				new Diem(monHoc.get(2), 8),
				new Diem(monHoc.get(3), 8))));
		list.add(sv5);
		
		return list;
	}

	// Cau 1
	public double tinhDiemTrungBinh() {
		// Giong nhu cach tinh hien tai cua truong
//		if (monDaHoc.size() != 0) {
//			double sum = monDaHoc.stream().map(item -> item.getDiem()).reduce((res, mark) -> res += mark).get();
//			return sum / monDaHoc.size();
//		}
		// ...
		return monDaHoc.stream().mapToInt(item -> item.getDiem()).average().orElse(0.0);
	}

	// Cau 2
	public String bangDiem() {
		/*
		 * MSSV : 0203044 Ten : Nguyen Van A Danh Sach Diem STT Ten Mon Diem So Tin Chi
		 * 1 Cau Truc Du Lieu 1 8 3 2 Cau Truc Du Lieu 2 8 3 Diem Trung Binh 8.0
		 */
		// ...
		int i = 0;
		String formatter = "\n%-55s | %-20s | %-10s | %-10s";
		StringBuilder sb = new StringBuilder("");
		sb.append("\tDanh sách bảng điểm:");
		sb.append("\nMSSV : " + this.mssv);
		sb.append("\nDanh sách điểm:");
		sb.append(String.format(formatter, "STT", "TÊN MÔN", "ĐIỂM", "SỐ TÍN CHỈ"));
		for (Diem diem : monDaHoc) {
			i++;
			sb.append(String.format(formatter, String.valueOf(1), diem.getMon().getTen(), diem.getDiem(), diem.getMon().tongTc()));
		}
		sb.append(String.format("\nĐiểm trung bình: %.2f", tinhDiemTrungBinh()));
		
		return sb.toString();
	}

	// Cau 3
	public String xepLoai() {
		/*
		 * Quy tac xep loai nhu sau DiemTB < 5 -> YEU DiemTB >= 5 va DiemTB < 6 -> TB
		 * DiemTB >= 6 va DiemTB < 7 -> TB-KHA DiemTB >= 7 va DiemTB < 8 -> KHA DiemTB
		 * >= 8 -> GIOI
		 */
		double avg = tinhDiemTrungBinh();
		if (avg < 5) {
			return XepLoai.YEU.toString();
		} else if (avg < 6) {
			return XepLoai.TRUNG_BINH.toString();
		} else if (avg < 7) {
			return XepLoai.TRUNG_BINH_KHA.toString();
		} else if (avg < 8) {
			return XepLoai.KHA.toString();
		} else {
			return XepLoai.GIOI.toString();
		}
		// ...
	}
	
	public void display() {
		System.out.println(new StringBuilder("MSSV: ")
				.append(this.mssv)
				.append("- TÊN: ")
				.append(this.ten)
				.append("- ĐIỂM TB: ")
				.append(tinhDiemTrungBinh())
				.append("- XẾP LOẠI: ")
				.append(xepLoai()));
	}
}
