package fis.java.topic2.controller;

import java.util.*;

import fis.java.topic2.model.MonHoc;
import fis.java.topic2.model.SinhVien;

public class DotDangKyHocPhan {
    private String ma;
    private Calendar ngayBatDau;
    private Calendar ngayKetThuc;
    private List<PhieuDangKyHocPhan> dsPhieuDangKy = new ArrayList<PhieuDangKyHocPhan>();

    public DotDangKyHocPhan(String ma, Calendar ngayBatDau, Calendar ngayKetThuc){
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    
    public List<PhieuDangKyHocPhan> getDsPhieuDangKy() {
		return dsPhieuDangKy;
	}


	public void setDsPhieuDangKy(List<PhieuDangKyHocPhan> dsPhieuDangKy) {
		this.dsPhieuDangKy = dsPhieuDangKy;
	}


	//Cau 3: Lay ra danh sach sinh vien dang ky nhieu mon hoc nhat
    //Chu y : chi quan tam den nhung phieu dang ky hop le
    public List<SinhVien> getDsSinhVien(MonHoc monHoc){
    	List<SinhVien> list = new ArrayList<>();
    	for(PhieuDangKyHocPhan p: dsPhieuDangKy) {
    		if(p.laHopLe()) {
    			for(MonHoc mh: p.getDsMonHoc()) {
    				if(mh.equals(monHoc)) {
    					list.add(p.getSv());
    				}
    			}
    		}
    	}
        return list;
    }

    //Cau 4:Lay ra danh sach cac mon hoc co the mo lop. Mon do co the mo lop
    //khi so luong dang ky hoc mon hoc do lon hon hoac bang soSinhVienToiThieu
    //Chu y : chi quan tam den nhung phieu dang ky hop le
    public List<MonHoc> getDsMonHoc(int soSinhVienToiThieu){
    	List<MonHoc> list = new ArrayList<>();
    	
    	Set<MonHoc> set = new HashSet<>();
    	
    	for(PhieuDangKyHocPhan p: dsPhieuDangKy) {
    		if(p.laHopLe()) {
    			set.addAll(p.getDsMonHoc());
    		}
    	}
    	
    	for(MonHoc monHoc: set) {
    		if(this.getDsSinhVien(monHoc).size() >= soSinhVienToiThieu) {
    			list.add(monHoc);
    		}
    	}
        return list;
    }

    public void themPhieuDangKyHocPhan(PhieuDangKyHocPhan phieuDangKyHocPhan) {
        this.dsPhieuDangKy.add(phieuDangKyHocPhan);
    }
}
