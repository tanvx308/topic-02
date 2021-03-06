package fis.java.topic2.model;

import java.util.*;

public class ChuongTrinhHoc {
	
    private String ten;
    
    private Calendar ngayDuocDuyet;
    
    private List<MonHoc> dsMonHoc = new ArrayList<MonHoc>();
    
    public static ChuongTrinhHoc SINGLETON = new ChuongTrinhHoc("Cong nghe thong tin", new GregorianCalendar(2000,0,1));

    private ChuongTrinhHoc(String ten, Calendar ngayDuocDuyet) {
        this.ten = ten;
        this.ngayDuocDuyet = ngayDuocDuyet;
    }

    public boolean addMonHoc(MonHoc monHoc){
        return this.dsMonHoc.add(monHoc);
    }

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Calendar getNgayDuocDuyet() {
		return ngayDuocDuyet;
	}

	public void setNgayDuocDuyet(Calendar ngayDuocDuyet) {
		this.ngayDuocDuyet = ngayDuocDuyet;
	}

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	@Override
	public String toString() {
		return "ChuongTrinhHoc [ten=" + ten + ", dsMonHoc=" + dsMonHoc + "]";
	}
    
	
    
}
