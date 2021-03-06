package fis.java.topic2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonHoc {
	private String ma;
	private String ten;
	private int soTclt;
	private int soTcth;

	private MonHoc() {
	}

	private MonHoc(MonHoc.Builder builder) {
		this.ma = builder.ma;
		this.ten = builder.ten;
		this.soTclt = builder.soTclt;
		this.soTcth = builder.soTcth;
	}

	public String getMa() {
		return ma;
	}

	public String getTen() {
		return ten;
	}

	public int getSoTclt() {
		return soTclt;
	}

	public int getSoTcth() {
		return soTcth;
	}

	public static class Builder {
		private String ma = "";
		private String ten = "";
		private int soTclt = 0;
		private int soTcth = 0;

		public MonHoc.Builder ma(String ma) {
			this.ma = ma;
			return this;
		}

		public MonHoc.Builder ten(String ten) {
			this.ten = ten;
			return this;
		}

		public MonHoc.Builder soTclt(int soTclt) {
			this.soTclt = soTclt;
			return this;
		}

		public MonHoc.Builder soTcth(int soTcth) {
			this.soTcth = soTcth;
			return this;
		}

		public MonHoc build() {
			return new MonHoc(this);
		}

	}

	// Mon hoc tien quyet la mon bat buoc phai dau
	private List<MonHoc> dsMonTienQuyet = new ArrayList<MonHoc>();

	// Xem ky dinh nghia giong nhau
	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (!(that instanceof MonHoc))
			return false;
		MonHoc thatMonHoc = (MonHoc) that;
		return this.ma.equals(thatMonHoc.ma);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ma);
	}

	public void addMonTienQuyet(MonHoc monTienQuyet) {
		this.dsMonTienQuyet.add(monTienQuyet);
	}

	public List<MonHoc> getDsMonTienQuyet() {
		return dsMonTienQuyet;
	}
	
	//public method
	
	//hàm kiểm tra môn học có trong cth hay không
	public boolean coTrongChuongTrinh(ChuongTrinhHoc cth) {
		for(MonHoc mh: cth.getDsMonHoc()) {
			if(this.equals(mh)) {
				return true;
			}
		}
		return false;
	}
	
	//hàm kiểm tra sinh viên đã pass môn này hay chưa
	public boolean daDauChua(SinhVien sv) {
		//lấy về danh sách điểm của sinh viên
		List<Diem> dsDiem = sv.getBangDiem().getDsDiem();
		
		//kiểm tra sinh viên có điểm môn học này chưa
		Diem diem = null;
		for(Diem d: dsDiem) {
			if(d.isMonHoc(this)) {
				diem = d;
				break;
			}
		}
		if(diem == null) {
			return false;
		}else {
			return diem.getDiemCuoiCung() > 5;
		}
	}

	
	//hàm kiểm tra sinh viên đã đâu môn tiên quyết của môn này chưa
	public boolean daDauTienQuyetChua(SinhVien sv) {
		for(MonHoc mh: dsMonTienQuyet) {
			if(!mh.daDauChua(sv)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "MonHoc [ma=" + ma + ", ten=" + ten + ", soTclt=" + soTclt + ", soTcth=" + soTcth + ", dsMonTienQuyet="
				+ dsMonTienQuyet.size() + "]";
	}
	
	
}
