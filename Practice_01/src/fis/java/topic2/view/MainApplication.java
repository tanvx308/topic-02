package fis.java.topic2.view;

import fis.java.topic2.model.LopHoc;
import fis.java.topic2.model.SinhVien;

public class MainApplication {
	public static void main(String[] args) {
		LopHoc lh = new LopHoc("FIS-Java", "Nguyen Thanh Phuoc");
		lh.setDsLop(SinhVien.createShortList());
		System.out.println(lh.inDiem());
		
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("Sinh viên yếu");
		System.out.println(lh.inDiem(lh.sinhVienYeu()));

		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("Top 10:");
		System.out.println(lh.inDiem(lh.top10()));
		
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("Bảng điểm sinh viên");		
		for(SinhVien sv: SinhVien.createShortList()) {			
			System.out.println(sv.bangDiem());
		}
				
		System.out.println("-------------------------------------------------------------------------------");	
		System.out.println("Sinh viên giỏi nhất: ");
		lh.gioiNhat().display();
		
		System.out.println("-------------------------------------------------------------------------------");	
		System.out.println("Sinh viên yếu nhất: ");
		lh.yeuNhat().display();
		
		
		System.out.println("-------------------------------------------------------------------------------");	
		System.out.println("Sinh viên tên dài nhất: ");
		lh.tenDaiNhat().display();
	}
}
