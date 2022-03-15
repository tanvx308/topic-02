package fis.java.topic2.controller;

import java.util.*;

import fis.java.topic2.model.MonHoc;
import fis.java.topic2.model.SinhVien;

public class PhieuDangKyHocPhan {
	private SinhVien sv;
	private List<MonHoc> dsMonHoc = new ArrayList<MonHoc>();

	private DotDangKyHocPhan dotDangKy;

	public PhieuDangKyHocPhan(SinhVien sv, DotDangKyHocPhan dotDangKy) {
		this.sv = sv;
		this.dotDangKy = dotDangKy;
		this.dotDangKy.themPhieuDangKyHocPhan(this);
	}

	public SinhVien getSv() {
		return sv;
	}

	public void setSv(SinhVien sv) {
		this.sv = sv;
	}

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	public DotDangKyHocPhan getDotDangKy() {
		return dotDangKy;
	}

	public void setDotDangKy(DotDangKyHocPhan dotDangKy) {
		this.dotDangKy = dotDangKy;
	}

	public boolean addMonHoc(MonHoc monHoc) {
		return dsMonHoc.add(monHoc);
	}

	// Cau 2 : Mot phieu dang ky hoc phan duoc xem la hop le
	// khi cac mon hoc do sinh vien chon hoc deu hop le.
	public boolean laHopLe() {
		for (MonHoc mh : dsMonHoc) {
			if (!sv.coTheDangKyHoc(mh)) {
				return false;
			}
		}
		// TODO
		return true;
	}

	@Override
	public String toString() {
		return "PhieuDangKyHocPhan [sv=" + sv + ", dsMonHoc=" + dsMonHoc.size() + "]";
	}
	
	
}
