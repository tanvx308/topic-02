package fis.java.topic2.common;

import java.util.*;

import fis.java.topic2.model.BangDiem;
import fis.java.topic2.model.ChuongTrinhHoc;
import fis.java.topic2.model.Diem;
import fis.java.topic2.model.MonHoc;
import fis.java.topic2.model.SinhVien;

public class DataForTest {
	//data monhoc
	MonHoc ltrA1 = new MonHoc.Builder()
			.ma("01")
			.ten("Lap Trinh A1")
			.soTclt(3)
			.soTcth(2)
			.build();
	MonHoc ltrA2 = new MonHoc.Builder()
			.ma("02")
			.ten("Lap Trinh A2")
			.soTclt(3)
			.soTcth(2)
			.build();
	MonHoc ktctri = new MonHoc.Builder()
			.ma("03")
			.ten("Kinh Te Chinh Tri")
			.soTclt(5)
			.soTcth(0)
			.build();
	MonHoc mmt = new MonHoc.Builder()
			.ma("04")
			.ten("Mang May Tinh")
			.soTclt(3)
			.soTcth(1)
			.build();
	MonHoc ctdl1 = new MonHoc.Builder()
			.ma("05")
			.ten("Cau Truc Du Lieu 1")
			.soTclt(3)
			.soTcth(2)
			.build();
	MonHoc ctdl2 = new MonHoc.Builder()
			.ma("06")
			.ten("Cau Truc Du Lieu 2")
			.soTclt(2)
			.soTcth(1)
			.build();

	//data sinhvien
	SinhVien ntphuoc = new SinhVien.Builder()
			.masv("0001")
			.ten("Nguyen Thanh Phuoc")
			.bangDiem(new BangDiem())
			.build();
	SinhVien ntphuc = new SinhVien.Builder()
			.masv("0002")
			.ten("Nguyen Thanh Phuc")
			.bangDiem(new BangDiem())
			.build();
	SinhVien dvhthong = new SinhVien.Builder()
			.masv("0003")
			.ten("Dang Van Hoang Thong")
			.bangDiem(new BangDiem())
			.build();
	SinhVien tptam = new SinhVien.Builder()
			.masv("0004")
			.ten("Truong Phong Tam")
			.bangDiem(new BangDiem())
			.build();
	SinhVien ntnguyet = new SinhVien.Builder()
			.masv("0005")
			.ten("Nguyen Thu Nguyet")
			.bangDiem(new BangDiem())
			.build();
	SinhVien lttloc = new SinhVien.Builder()
			.masv("0006")
			.ten("Lam Tran Thien Loc")
			.bangDiem(new BangDiem())
			.build();
	
	public List<SinhVien> createListSinhVien(){
		List<SinhVien> sv = new ArrayList<>();
		sv.add(ntphuoc);
		sv.add(ntnguyet);
		sv.add(dvhthong);
		sv.add(lttloc);
		sv.add(ntphuc);
		sv.add(tptam);
		return sv;
	}
	
	public List<MonHoc> createListMonHoc(){
		List<MonHoc> mh = new ArrayList<>();
//		mh.add(ctdl1);
		mh.add(ctdl2);
		mh.add(ktctri);
//		mh.add(ltrA1);
//		mh.add(ltrA2);
//		mh.add(mmt);
		return mh;
	}

    public DataForTest(){
        ltrA2.addMonTienQuyet(ltrA1);
        ctdl1.addMonTienQuyet(ltrA2);
        ctdl1.addMonTienQuyet(mmt);
        ctdl2.addMonTienQuyet(ctdl1);

        ChuongTrinhHoc.SINGLETON.addMonHoc(ltrA1);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ltrA2);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ktctri);
        ChuongTrinhHoc.SINGLETON.addMonHoc(mmt);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ctdl1);
        ChuongTrinhHoc.SINGLETON.addMonHoc(ctdl2);

        ntphuoc.getBangDiem().themDiem(new Diem(ltrA1, 5.5));
        ntphuoc.getBangDiem().themDiem(new Diem(ltrA2, 5.5));
        ntphuoc.getBangDiem().themDiem(new Diem(ktctri, 4.));
        ntphuoc.getBangDiem().themDiem(new Diem(mmt, 7.));
        ntphuoc.getBangDiem().themDiem(new Diem(ctdl1, 7.));

        ntphuc.getBangDiem().themDiem(new Diem(ltrA1, 5.));
        ntphuc.getBangDiem().themDiem(new Diem(ktctri, 6.));
        ntphuc.getBangDiem().themDiem(new Diem(mmt, 7.));

        dvhthong.getBangDiem().themDiem(new Diem(ltrA1, 7.));
        dvhthong.getBangDiem().themDiem(new Diem(ktctri, 6.));
        dvhthong.getBangDiem().themDiem(new Diem(mmt, 4.));

        tptam.getBangDiem().themDiem(new Diem(ltrA1, 5.));
        tptam.getBangDiem().themDiem(new Diem(ktctri, 9.));
        tptam.getBangDiem().themDiem(new Diem(mmt, 7.));

        ntnguyet.getBangDiem().themDiem(new Diem(ltrA1, 4.));
        ntnguyet.getBangDiem().themDiem(new Diem(ktctri, 6.));
        ntnguyet.getBangDiem().themDiem(new Diem(mmt, 1.));

        lttloc.getBangDiem().themDiem(new Diem(ltrA1, 5.));
        lttloc.getBangDiem().themDiem(new Diem(ktctri, 4.));
        lttloc.getBangDiem().themDiem(new Diem(mmt, 7.));
    }
}
