package fis.java.topic2.model;

import java.util.*;
import java.util.stream.Collectors;

public class LopHoc {
	private String ten;
	private String giaoVien;
	private List<SinhVien> dsLop = new ArrayList<SinhVien>();

	public LopHoc(String ten, String giaoVien) {
		this.ten = ten;
		this.giaoVien = giaoVien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(String giaoVien) {
		this.giaoVien = giaoVien;
	}

	public List<SinhVien> getDsLop() {
		return dsLop;
	}

	public void setDsLop(List<SinhVien> dsLop) {
		this.dsLop = dsLop;
	}

	public boolean them(SinhVien svMoi) {
		return dsLop.add(svMoi);
	}

	// Cau 4
	public String inDiem() {
		/*
		 * Danh Sach Diem Lop : ten Giao Vien Chu Nhiem : giaoVien STT MSSV Ten Diem TB
		 * XepLoai 1 123456 Nguyen Van A 8.4 GIOI 2 678919 Nguyen Van B 6 TB-KHA 3
		 * 112456 Nguyen Van C 7 KHA
		 */
		// ...
		String fommatter = "\n%-5s | %-10s | %-20s | %-10s | %-10s";
		StringBuilder sb = new StringBuilder("");
		sb.append("\tDanh sách điểm lớp ").append(this.ten);
		sb.append("\nGiáo viên chủ nhiệm : ").append(this.giaoVien);
		sb.append(String.format(fommatter, "STT", "MSSV", "TÊN", "ĐIỂM TB", "XẾP LOẠI"));
		for (int i = 0; i < dsLop.size(); i++) {
			SinhVien sv = dsLop.get(i);
			sb.append(String.format(fommatter, String.valueOf(i + 1), sv.getMssv(), sv.getTen(),
					sv.tinhDiemTrungBinh(), sv.xepLoai()));
		}
		return sb.toString();
	}
	
	public String inDiem(List<SinhVien> list) {
		/*
		 * Danh Sach Diem Lop : ten Giao Vien Chu Nhiem : giaoVien STT MSSV Ten Diem TB
		 * XepLoai 1 123456 Nguyen Van A 8.4 GIOI 2 678919 Nguyen Van B 6 TB-KHA 3
		 * 112456 Nguyen Van C 7 KHA
		 */
		// ...
		String fommatter = "\n %-5s | %-10s | %-20s | %-10s | %-10s ";
		StringBuilder sb = new StringBuilder("");
		sb.append("\tDanh sách điểm lớp ").append(this.ten);
		sb.append("\n Giáo viên chủ nhiệm : ").append(this.giaoVien);
		sb.append(String.format(fommatter, "STT", "MSSV", "TÊN", "ĐIỂM TB", "XẾP LOẠI"));
		for (int i = 0; i < list.size(); i++) {
			SinhVien sv = dsLop.get(i);
			sb.append(String.format(fommatter, String.valueOf(i + 1), sv.getMssv(), sv.getTen(),
					sv.tinhDiemTrungBinh(), sv.xepLoai()));
		}
		return sb.toString();
	}

	// Cau 5
	public List<SinhVien> top10() {
		// Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
		// ...
		Collections.sort(dsLop, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return Double.compare(o2.tinhDiemTrungBinh(), o1.tinhDiemTrungBinh());
			}
		});
		int len = this.dsLop.size();
		if (len <= 10) {
			return dsLop;
		}
		return dsLop.subList(0, 10);
	}

	// Cau 6
	public List<SinhVien> sinhVienYeu() {
		List<SinhVien> result = dsLop.stream().filter(item -> item.xepLoai().equals("YẾU"))
				.collect(Collectors.toList());
		return result;
	}
	
	
	//câu 7
	public SinhVien gioiNhat() {
		return dsLop.stream().max(new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return Double.compare(o1.tinhDiemTrungBinh(), o2.tinhDiemTrungBinh());
			}
			
		}).get();
	}
	
	
	//câu 8
	public SinhVien yeuNhat() {
		return dsLop.stream().min(new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return Double.compare(o1.tinhDiemTrungBinh(), o2.tinhDiemTrungBinh());
			}
			
		}).get();
	}
	
	
	public SinhVien tenDaiNhat() {
		return dsLop.stream().max(new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return Double.compare(o1.getTen().length(), o2.getTen().length());
			}
			
		}).get();
	}
}
