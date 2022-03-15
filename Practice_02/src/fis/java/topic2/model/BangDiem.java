package fis.java.topic2.model;

import java.util.ArrayList;
import java.util.List;

public class BangDiem {
    private List<Diem> dsDiem = new ArrayList<Diem>();

    public void themDiem(Diem diem){
        this.dsDiem.add(diem);
    }

	public List<Diem> getDsDiem() {
		return dsDiem;
	}

	@Override
	public String toString() {
		return "BangDiem [dsDiem=" + dsDiem + "]";
	}  
	
	
    
}
