package framelessAloha;

import java.util.Random;
import java.util.Scanner;
public class test {
	public static void main(String[] args) {
		Random generator = new Random();
		Scanner sc = new Scanner(System.in) ;
		double sumH = 0;
		double average = 0 ;
		System.out.println("so lan chay ");
		int nloop = sc.nextInt() ;
		for( int x = 0 ; x < nloop ; x++) {
			int n = 1000; 
			double a = 1.1 ;
//			System.out.println("số bản sao tối đa của mỗi trạm ");
			int Pmax = 5 ;
			int countOfuser = 0 ;
			int countOFpacketResolve = 0 ;
			Station listStation[] = new Station[n];
		// tạo ra các trạm 
			for( int i = 0 ; i < n ; i++) {
				listStation[i] = new Station(i) ;
			}
			// tìm số trạm muốn truyền
			for(Station station : listStation) {
				int countOfCopy = generator.nextInt(Pmax+1) ;
				if(countOfCopy > 0)
					countOfuser++ ;
				station.setCountOFCopy(countOfCopy);
			}
		// tạo ma trận gồm n hàng và a*n cột ( khe )
			int countOfSlot = (int) Math.ceil(countOfuser*a) ;
			int matrix[][] = new int[n][countOfSlot] ;
		// tạo các bản sao và chọn khe (random)
			for(Station station : listStation) {
				for(int i = 0 ; i < station.getCountOFCopy() ; i++) {
					int slotRandom = generator.nextInt(countOfSlot) ;
					while(matrix[station.getIdStation()][slotRandom] == 1 ) {
						slotRandom = generator.nextInt(countOfSlot) ;
					}
					matrix[station.getIdStation()][slotRandom] = 1 ;
				}
				
			}
//		// In  ra ma trận 
//			for (int i = 0 ; i < n ; i++) {
//				for(int j = 0 ; j < countOfSlot ; j++) {
//					System.out.print("  " + matrix[i][j]);
//				}
//				System.out.println();
//			}
		//Xử lí xung đột 
			int countOfLoop = countOfSlot ;
			while(countOfLoop > 0 ) {
				for(int i = 0 ; i < countOfSlot ; i++ ) {
					int count = 0 ;
					for (int j = 0 ; j < n ; j++) {
						if(matrix[j][i] == 1)
							count++ ;
					}
					if(count == 1) {
						countOFpacketResolve++ ;
						for(int k = 0 ; k < n ; k++) {
							if(matrix[k][i]==1) {
								for(int h = 0 ; h < countOfSlot ; h++) {
									matrix[k][h] = 0;
								}
							}
						}
					}
				}
				countOfLoop-- ;
			}
//		// in lại ma trận một lần nữa 
//			System.out.println("----------------");
//			for (int i = 0 ; i < n ; i++) {
//				for(int j = 0 ; j < countOfSlot ; j++) {
//					System.out.print("  " + matrix[i][j]);
//				}
//				System.out.println();
//			}
		// tính hiệu suất 
//			System.out.println("Số gói tin đã gửi " + countOfuser);
//			System.out.println("Số gói được giải quyết " + countOFpacketResolve);
			double H = ((double)countOFpacketResolve )/((double)countOfuser)  ;
//			System.out.println("Hiệu suất người dùng là " + H );
			sumH += H ;
		}
		average = sumH /nloop ;
		System.out.println("hieu suat trung binh la : " + average);
	}
}

