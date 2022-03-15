package fis.java.topic2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diem {
    private MonHoc monHoc;
    //Phan tu dau tien trong dsDiem la diem lan 1;
    //Phan tu thu hai trong dsDiem la diem lan 2;
    //Phan tu thu ... trong dsDiem la diem lan ...;
    private List<Double> dsDiem = new ArrayList<Double>();

    public Diem(MonHoc monHoc, Double diemLan1) {
        this.monHoc = monHoc;
        this.dsDiem.add(diemLan1);
    }

    public boolean addDiem(Double diem){
        return this.dsDiem.add(diem);
    }

//    Xem ky dinh nghia giong nhau
    @Override
    public boolean equals(Object that){
        if(that == null) return false;
        if (!(that instanceof Diem))
            return false;
        Diem thatMonHoc = (Diem) that;
        return this.monHoc.equals(thatMonHoc.monHoc);
    }
    
    public boolean isMonHoc(MonHoc monHoc) {
        return this.monHoc.equals(monHoc);
    }

    @Override
	public int hashCode() {
		return Objects.hash(dsDiem, monHoc);
	}


	public double getDiemCuoiCung() {
        return this.dsDiem.get(this.dsDiem.size() - 1);
    }

	@Override
	public String toString() {
		return "Diem [monHoc=" + monHoc + ", dsDiem=" + dsDiem + "]";
	}
	
	
}
