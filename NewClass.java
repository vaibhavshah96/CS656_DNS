import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class NewClass{
	static long previous = 0; 
	static int ipNo = 0;

	public static void main(String[] args) throws IOException {
		try {
			String website = "www.sreenidhi.edu.in";
			InetAddress[] a = InetAddress.getAllByName(website);
			int i = 0;
			int prefIp = 0;
			while(i<a.length) {
				System.out.println(a[i].getHostAddress());

				
//				try{
				if (a[i] instanceof Inet4Address) {
					Socket aaa = new Socket();
					long start = System.nanoTime();
					aaa.connect(new InetSocketAddress(a[i].getHostAddress().toString(), 80),5000) ;
					long stop = System.nanoTime();
					long total = stop - start;
					prefIp = selectIP(total, i);
					System.out.println(""+ total);
					System.out.println("wow");
					aaa.close();
				}
					
//				}
//				catch (IOException e){
//
//					System.out.println("ahh!");
//				}
				
				i++;
			}
			
			System.out.println("Preferred IP:" + a[prefIp].getHostAddress());


		}
		
		catch (UnknownHostException e) {
			System.out.println("Damnnnnnn!!!!!");
		}
		catch (IOException e){
			
			System.out.println("ahh!");
		}
		catch (Exception e) {
			System.out.println("Damn!!!!!");
		}
//		finally {
//			System.out.println("Bad Input");
//			System.exit(0);
//			
//		}



	}
	
	
	public static int selectIP(long totalTime, int i) {
		
		if (i == 0) {
			previous = totalTime;
			ipNo = i;
		 }
		 
		else {
			 if (previous > totalTime) {
				 previous = totalTime;
				 ipNo = i;
			 }
		 }
		 return ipNo;
		
		
		
	}
}
