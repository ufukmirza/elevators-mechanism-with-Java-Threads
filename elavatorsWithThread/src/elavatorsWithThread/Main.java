package elavatorsWithThread;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class Zemin{
	
int	hedef_1;
int hedef_2;
int hedef_3;
int hedef_4;

int toplam_kuyruk;
	
	
	
	
	
}

class kat{

int kisi_sayisi;
int siradaki_sayisi;
ArrayList <Kuyruk> cikis_kuyrugu=new ArrayList<>();
int kuyrukta_olmayan;


}

class Cikis{
	
	int bulunan_kat;
	int cikis_sayisi;
	int hedef_kat=0;
	
	public Cikis(int siradaki) {
		
		cikis_sayisi=siradaki;
		
		
	}
}


class Kuyruk{

int hedef_kat;
int kisi_sayisi;

public Kuyruk(int kisi_sayisi,int hedef_kat) {
	
this.kisi_sayisi=kisi_sayisi;
this.hedef_kat=hedef_kat;
	
}

}

class Asansor{

ArrayList<Kuyruk>kuyruk=new ArrayList<>();
boolean yukari=true;
boolean hareket_edebilir=false;
int bulunan_kat;
int kisi_sayisi;

}


class Main extends JPanel{  
		
	String kat_0_s=new String("0.floor : queue:");
	String kat_1_s=new String("1.floor : queue:");
	String kat_2_s=new String("2.floor : queue:");
	String kat_3_s=new String("3.floor : queue:");
	String kat_4_s=new String("4.floor : queue:");
	static int exit_count;
	 final static AtomicBoolean asansor_2_durmali = new AtomicBoolean(true);
	 final static AtomicBoolean asansor_3_durmali = new AtomicBoolean(true);
	 final static AtomicBoolean asansor_4_durmali = new AtomicBoolean(true);
	 final static AtomicBoolean asansor_5_durmali = new AtomicBoolean(true);
	 
static	ArrayList<Kuyruk> zemin_kuyrugu=new ArrayList<>();
	static ArrayList<Cikis> cikis_kuyrugu=new ArrayList<>();
    static ArrayList<kat>katlar=new ArrayList<>();

 static  Asansor asansor=new Asansor();
   static Asansor asansor_2=new Asansor();
   static Asansor asansor_3=new Asansor();
   static Asansor asansor_4=new Asansor();
   static Asansor asansor_5=new Asansor();
			public static void main(String args[]){  
		
		        Main main=new Main();		
			    katlar.add(new kat());
			    katlar.add(new kat());
			    katlar.add(new kat());
			    katlar.add(new kat());
			    katlar.add(new kat());
			
				JFrame frame=new JFrame("asansor");
				JPanel panel=new JPanel();
				frame.setBounds(0, 0, 1500, 600);
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new Main());
				 frame.getContentPane().setBackground(Color.BLACK);
				frame.setVisible(true);
				
			
				
		
				
				
				
				
				
				
				
				
				
				
				//giris yapanlar
				
				int i=0;
				 //int asansor_2_durmali=0;
		
			    
				Thread giris = new Thread(new Runnable() {
			
				     
		            @Override
		            public void run() {
		           
		                while (true) {
		           
		              Random random=new Random();
		              int yenigelen=random.nextInt(10)+1;
		              int hedef_kat= random.nextInt(4)+1;	
		              zemin_kuyrugu.add(new Kuyruk(yenigelen,hedef_kat));
		              katlar.get(0).siradaki_sayisi+=yenigelen;
		              for(int i=0;i<zemin_kuyrugu.size();i++) {
		            	  
		            	  System.out.println("{"+zemin_kuyrugu.get(i).kisi_sayisi+","+zemin_kuyrugu.get(i).hedef_kat+"}");
		            	  
		              }
		                System.out.println("-------------------");
		            		try {
								Thread.sleep(500);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		               
		           
		                
		                }
		            }
		        });
				
				
				//asansor threadi
				Thread asansor_hareket = new Thread(new Runnable() {
					
				     
		            @Override
		            public void run() {
		            	
		                while (true) {
		                	
		                	while(!Thread.currentThread().isInterrupted()){
		                	
		                	try {
								Thread.sleep(200);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	
		                    System.out.println("-----------"+"\n asansorun bulundugu kat="+asansor.bulunan_kat);
		                	
		                	
		          if(asansor.bulunan_kat==0&&asansor.yukari==true) {
		        	  
		        	  boolean durdurma=true;
		        	  
		        	  while(durdurma) {
		        		  
		        		  
		        		  if(!zemin_kuyrugu.isEmpty()) {
			        			 
		        			  asansor.kuyruk.add(zemin_kuyrugu.get(0));
			        		  asansor.kisi_sayisi+=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(0).siradaki_sayisi-=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  zemin_kuyrugu.remove(0);
		        			  
		        		  }
		        		  
		        	
		        		  
		        		  System.out.println("girdi -s-----");
		        		  if(zemin_kuyrugu.isEmpty()) {
		        			 
		        			  asansor.hareket_edebilir=true;
		        			  durdurma=false;
		        			  
		        			  
		        		  }
		        			
		        		  else  if(asansor.kisi_sayisi==10||asansor.kisi_sayisi+zemin_kuyrugu.get(0).kisi_sayisi>10) {
		        			
		        			  asansor.hareket_edebilir=true;
		        			  durdurma=false;
		        		  }
		        		
		        		  
		        		  
		        	  }
		        	 
		         }
		          
		          if(asansor.bulunan_kat==0&&asansor.yukari==false) {
		        	  
		        	  while(!asansor.kuyruk.isEmpty()) {
		        		  exit_count+=asansor.kuyruk.get(0).kisi_sayisi;
		        		  asansor.kuyruk.remove(0);
		        	 
		        	    }
		        	  asansor.kisi_sayisi=0;
		        	  asansor.hareket_edebilir=false;
		        	  asansor.yukari=true;
		          }
		          
		          //0.kat bitisi
		          System.out.println("asansor yonu yukar:"+asansor.yukari);
		          if(asansor.bulunan_kat>0&&asansor.yukari==true) {
		        	  
		        	  for(int i=0;i<asansor.kuyruk.size();i++) {
		        		  
		        		  if(asansor.kuyruk.get(i).hedef_kat==asansor.bulunan_kat) {
		        			  
		        			  katlar.get(asansor.bulunan_kat).kisi_sayisi+=asansor.kuyruk.get(i).kisi_sayisi;
		        			  katlar.get(asansor.bulunan_kat).kuyrukta_olmayan+=asansor.kuyruk.get(i).kisi_sayisi;
		        			  asansor.kisi_sayisi-=asansor.kuyruk.get(i).kisi_sayisi;
		        			  asansor.kuyruk.remove(i);
		        			 
		        			  i--;
		        			  
		        		  }
		        			  
		        		  
		        	  }
		        	 
		        	  System.out.println("katta bulunan kisi sayisi :"+katlar.get(asansor.bulunan_kat).kisi_sayisi);
		        	  
		          }//1,2,3,4. yukari kat bitisi

		          
		        	 if(asansor.yukari==false&&asansor.bulunan_kat>0) {
		        		 
		        		 boolean durdurma=true;
			        	  
			        	  while(!katlar.get(asansor.bulunan_kat).cikis_kuyrugu.isEmpty()&&durdurma) {
			        		  
			        		  if(asansor.kisi_sayisi+katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi<=10) {
			        		  asansor.kuyruk.add(katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0));
			        		  asansor.kisi_sayisi+=katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor.bulunan_kat).kisi_sayisi-=katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor.bulunan_kat).siradaki_sayisi-=katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor.bulunan_kat).cikis_kuyrugu.remove(0);
			        		  }
			        		  if(asansor.kisi_sayisi>=10) {
			        			
			        			  durdurma=false;
			        			  asansor.hareket_edebilir=true;
			        			  break;
			        		  
			        		  }
			        		
			        		  
			        	
                      
			        		  
			        		  if(!katlar.get(asansor.bulunan_kat).cikis_kuyrugu.isEmpty()) {
			        			  
			        			  if(asansor.kisi_sayisi+katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi>10) {
				                      asansor.kuyruk.add(new Kuyruk(10-asansor.kisi_sayisi,0));
			        			      katlar.get(asansor.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi-=10-asansor.kisi_sayisi;
			        			      asansor.kisi_sayisi=10;
			        			      katlar.get(asansor.bulunan_kat).kisi_sayisi-=10-asansor.kisi_sayisi;
			        			      katlar.get(asansor.bulunan_kat).siradaki_sayisi-=10-asansor.kisi_sayisi;
			        				  durdurma=false;
			        			  asansor.hareket_edebilir=true;
			        			  break;
			        			  }
			        		  }
		        		 
		        	 }
		          
		        	 }
		  
		          for(int i=0;i<asansor.kuyruk.size();i++)
		        	  System.out.print("asansor_1:{"+asansor.kuyruk.get(i).kisi_sayisi+","+asansor.kuyruk.get(i).hedef_kat+"}");
		          System.out.println("\n----------\n");
		          
		                	if(asansor.yukari==true&&asansor.hareket_edebilir==true&&asansor.bulunan_kat<4&&!asansor.kuyruk.isEmpty()) {
		                		asansor.bulunan_kat++;
		                		
		               }
		            
		                	else if(asansor.yukari==false&&asansor.bulunan_kat>0)
		                		asansor.bulunan_kat--;
		                	//elseleri unutma
		                	
		                	 else if(asansor.bulunan_kat==4) {
		                	asansor.yukari=false;
		                	
		                	}
		                	
		                	 else if(asansor.bulunan_kat!=0&&asansor.kuyruk.isEmpty()) {
		                	 
		                	 int su_anki_kat=asansor.bulunan_kat;
		                	 int ust_kat=su_anki_kat++;
		                	 boolean yukari_cikmali=false;;
		                	 
		                	 while(ust_kat<=4) {
		                		 
		                		 if(!katlar.get(ust_kat).cikis_kuyrugu.isEmpty()) {
		                		 yukari_cikmali=true;
		                		 break;
		                		 }
		                		 
		                		 ust_kat++;
		                		 
		                	 }
		                	 
		                	 if(yukari_cikmali==true)
		                	 asansor.bulunan_kat++;
		                	 
		                	 if(yukari_cikmali==false)
		                		 asansor.yukari=false;
		                	 
		                 }
		                	
		                	} 
		                }
		            }
		        });
				
				Thread asansor_2_hareket = new Thread(new Runnable() {
					
		
				     
		            @Override
		            public void run() {
		            	
		            	
		            	
		                while (true) {
		                	
		        			while(asansor_2_durmali.get()==false){
		                
		                	System.out.println("girdi buraya -------------");
		                	try {
								Thread.sleep(200);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	
		                    System.out.println("-----------"+"\n asansor_2 bulundugu kat="+asansor_2.bulunan_kat);
		                	
		                	
		          if(asansor_2.bulunan_kat==0&&asansor_2.yukari==true) {
		        	  
		        	  boolean durdurma=true;
		        	  
		        	  while(durdurma) {
		        		  if(!zemin_kuyrugu.isEmpty()) {
		        			  
		        			  
		        			  asansor_2.kuyruk.add(zemin_kuyrugu.get(0));
			        		  asansor_2.kisi_sayisi+=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(0).siradaki_sayisi-=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  zemin_kuyrugu.remove(0);
		        			
		        			  
		        			  
		        		  }
		        	
		        		  
		        		  System.out.println("girdi -s-----");
		        		  if(zemin_kuyrugu.isEmpty()) {
		        			 
		        			  asansor_2.hareket_edebilir=true;
		        			  durdurma=false;
		        			  
		        			  
		        		  }
		        			
		        		  else  if(asansor_2.kisi_sayisi==10||asansor_2.kisi_sayisi+zemin_kuyrugu.get(0).kisi_sayisi>10) {
		        			
		        			  asansor_2.hareket_edebilir=true;
		        			  durdurma=false;
		        		  }
		        		
		        		  
		        		  
		        	  }
		        	 
		         }
		          
		          if(asansor_2.bulunan_kat==0&&asansor_2.yukari==false) {
		        	  
		        	  while(!asansor_2.kuyruk.isEmpty()) {
		        		  exit_count+=asansor_2.kuyruk.get(0).kisi_sayisi;
		        		  asansor_2.kuyruk.remove(0);
		        	  }
		        	 
		        	  asansor_2.kisi_sayisi=0;
		        	  asansor_2.hareket_edebilir=false;
		        	  asansor_2.yukari=true;
		          }
		          
		          //0.kat bitisi
		          System.out.println("asansor yonu yukar:"+asansor_2.yukari);
		          if(asansor_2.bulunan_kat>0&&asansor_2.yukari==true) {
		        	  
		        	  for(int i=0;i<asansor_2.kuyruk.size();i++) {
		        		  
		        		  if(asansor_2.kuyruk.get(i).hedef_kat==asansor_2.bulunan_kat) {
		        			  
		        			  katlar.get(asansor_2.bulunan_kat).kisi_sayisi+=asansor_2.kuyruk.get(i).kisi_sayisi;
		        			  katlar.get(asansor.bulunan_kat).kuyrukta_olmayan+=asansor_2.kuyruk.get(i).kisi_sayisi;
		        			  asansor_2.kisi_sayisi-=asansor_2.kuyruk.get(i).kisi_sayisi;
		        			  asansor_2.kuyruk.remove(i);
		        			 
		        			  i--;
		        			  
		        		  }
		        			  
		        		  
		        	  }
		        	 
		        	  System.out.println("katta bulunan kisi sayisi :"+katlar.get(asansor_2.bulunan_kat).kisi_sayisi);
		        	  
		          }//1,2,3,4. yukari kat bitisi

		          
		        	 if(asansor_2.yukari==false&&asansor_2.bulunan_kat>0) {
		        		 
		        		 boolean durdurma=true;
			        	  
			        	  while(!katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.isEmpty()&&durdurma) {
			        		  
			        		  if(asansor_2.kisi_sayisi+katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi<=10) {
			        		  asansor_2.kuyruk.add(katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0));
			        		  asansor_2.kisi_sayisi+=katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_2.bulunan_kat).kisi_sayisi-=katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_2.bulunan_kat).siradaki_sayisi-=katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.remove(0);
			        		  }
			        		  if(asansor_2.kisi_sayisi>=10) {
			        			
			        			  durdurma=false;
			        			  asansor_2.hareket_edebilir=true;
			        			  break;
			        		  
			        		  }
			        		
			        		  
			        	
                      
			        		  
			        		  if(!katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.isEmpty()) {
			        			  
			        			  if(asansor_2.kisi_sayisi+katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi>10) {
				                      asansor_2.kuyruk.add(new Kuyruk(10-asansor_2.kisi_sayisi,0));
			        			      katlar.get(asansor_2.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi-=10-asansor_2.kisi_sayisi;
			        			      asansor_2.kisi_sayisi=10;
			        			      katlar.get(2).kisi_sayisi-=10-asansor_2.kisi_sayisi;
			        			      katlar.get(asansor_2.bulunan_kat).siradaki_sayisi-=10-asansor_2.kisi_sayisi;
			        				  durdurma=false;
			        			  asansor_2.hareket_edebilir=true;
			        			  break;
			        			  }
			        		  }
		        		 
		        	 }
		          
		        	 }
		  
		          for(int i=0;i<asansor_2.kuyruk.size();i++)
		        	  System.out.print("asansor_2:{"+asansor_2.kuyruk.get(i).kisi_sayisi+","+asansor_2.kuyruk.get(i).hedef_kat+"}");
		          System.out.println("\n----------\n");
		          
		                	if(asansor_2.yukari==true&&asansor_2.hareket_edebilir==true&&asansor_2.bulunan_kat<4&&!asansor_2.kuyruk.isEmpty()) {
		                		asansor_2.bulunan_kat++;
		                		
		               }
		            
		                	else if(asansor_2.yukari==false&&asansor_2.bulunan_kat>0)
		                		asansor_2.bulunan_kat--;
		                	//elseleri unutma
		                	
		                	 else if(asansor_2.bulunan_kat==4) {
		                	asansor_2.yukari=false;
		                	
		                	}
		                	
		                	 else if(asansor_2.bulunan_kat!=0&&asansor_2.kuyruk.isEmpty()) {
		                	 
		                	 int su_anki_kat=asansor_2.bulunan_kat;
		                	 int ust_kat=su_anki_kat++;
		                	 boolean yukari_cikmali=false;;
		                	 
		                	 while(ust_kat<=4) {
		                		 
		                		 if(!katlar.get(ust_kat).cikis_kuyrugu.isEmpty()) {
		                		 yukari_cikmali=true;
		                		 break;
		                		 }
		                		 
		                		 ust_kat++;
		                		 
		                	 }
		                	 
		                	 if(yukari_cikmali==true)
		                	 asansor_2.bulunan_kat++;
		                	 
		                	 if(yukari_cikmali==false)
		                		 asansor_2.yukari=false;
		                	 
		                 }
		                	
		                	} 
		                }
		            }
		        });
				
				
				
				Thread asansor_3_hareket = new Thread(new Runnable() {
					
					
				     
		            @Override
		            public void run() {
		            	
		            	
		            	
		                while (true) {
		                	
		        			while(asansor_3_durmali.get()==false){
		                
		                	System.out.println("girdi buraya -------------");
		                	try {
								Thread.sleep(200);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	
		                    System.out.println("-----------"+"\n asansor_3 bulundugu kat="+asansor_3.bulunan_kat);
		                	
		                	
		          if(asansor_3.bulunan_kat==0&&asansor_3.yukari==true) {
		        	  
		        	  boolean durdurma=true;
		        	  
		        	  while(durdurma) {
		        		  if(!zemin_kuyrugu.isEmpty()) {
		        			  
		        			  
		        			  asansor_3.kuyruk.add(zemin_kuyrugu.get(0));
			        		  asansor_3.kisi_sayisi+=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(0).siradaki_sayisi-=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  zemin_kuyrugu.remove(0);
		        			
		        			  
		        			  
		        		  }
		        	
		        		  
		        		  System.out.println("girdi -s-----");
		        		  if(zemin_kuyrugu.isEmpty()) {
		        			 
		        			  asansor_3.hareket_edebilir=true;
		        			  durdurma=false;
		        			  
		        			  
		        		  }
		        			
		        		  else  if(asansor_3.kisi_sayisi==10||asansor_3.kisi_sayisi+zemin_kuyrugu.get(0).kisi_sayisi>10) {
		        			
		        			  asansor_3.hareket_edebilir=true;
		        			  durdurma=false;
		        		  }
		        		
		        		  
		        		  
		        	  }
		        	 
		         }
		          
		          if(asansor_3.bulunan_kat==0&&asansor_3.yukari==false) {
		        	  
		        	  while(!asansor_3.kuyruk.isEmpty()) {
		        		 
		        		  exit_count+=asansor_3.kuyruk.get(0).kisi_sayisi;
		        		  asansor_3.kuyruk.remove(0);
		        		  
		        	  }
		        	  
		        	  asansor_3.kisi_sayisi=0;
		        	  asansor_3.hareket_edebilir=false;
		        	  asansor_3.yukari=true;
		          }
		          
		          //0.kat bitisi
		          System.out.println("asansor yonu yukar:"+asansor_3.yukari);
		          if(asansor_3.bulunan_kat>0&&asansor_3.yukari==true) {
		        	  
		        	  for(int i=0;i<asansor_3.kuyruk.size();i++) {
		        		  
		        		  if(asansor_3.kuyruk.get(i).hedef_kat==asansor_3.bulunan_kat) {
		        			  
		        			  katlar.get(asansor_3.bulunan_kat).kisi_sayisi+=asansor_3.kuyruk.get(i).kisi_sayisi;
		        			  katlar.get(asansor.bulunan_kat).kuyrukta_olmayan+=asansor_3.kuyruk.get(i).kisi_sayisi;
		        			  asansor_3.kisi_sayisi-=asansor_3.kuyruk.get(i).kisi_sayisi;
		        			  asansor_3.kuyruk.remove(i);
		        			 
		        			  i--;
		        			  
		        		  }
		        			  
		        		  
		        	  }
		        	 
		        	  System.out.println("katta bulunan kisi sayisi :"+katlar.get(asansor_3.bulunan_kat).kisi_sayisi);
		        	  
		          }//1,2,3,4. yukari kat bitisi

		          
		        	 if(asansor_3.yukari==false&&asansor_3.bulunan_kat>0) {
		        		 
		        		 boolean durdurma=true;
			        	  
			        	  while(!katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.isEmpty()&&durdurma) {
			        		  
			        		  if(asansor_3.kisi_sayisi+katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi<=10) {
			        		  asansor_3.kuyruk.add(katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0));
			        		  asansor_3.kisi_sayisi+=katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_3.bulunan_kat).kisi_sayisi-=katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_3.bulunan_kat).siradaki_sayisi-=katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.remove(0);
			        		  }
			        		  if(asansor_3.kisi_sayisi>=10) {
			        			
			        			  durdurma=false;
			        			  asansor_3.hareket_edebilir=true;
			        			  break;
			        		  
			        		  }
			        		
			        		  
			        	
                      
			        		  
			        		  if(!katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.isEmpty()) {
			        			  
			        			  if(asansor_3.kisi_sayisi+katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi>10) {
				                      asansor_3.kuyruk.add(new Kuyruk(10-asansor_3.kisi_sayisi,0));
			        			      katlar.get(asansor_3.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi-=10-asansor_3.kisi_sayisi;
			        			      asansor_3.kisi_sayisi=10;
			        			      katlar.get(asansor_3.bulunan_kat).kisi_sayisi-=10-asansor_3.kisi_sayisi;
			        			      katlar.get(asansor_3.bulunan_kat).siradaki_sayisi-=10-asansor_3.kisi_sayisi;
			        				  durdurma=false;
			        			  asansor_3.hareket_edebilir=true;
			        			  break;
			        			  }
			        		  }
		        		 
		        	 }
		          
		        	 }
		  
		          for(int i=0;i<asansor_3.kuyruk.size();i++)
		        	  System.out.print("asansor_3:{"+asansor_3.kuyruk.get(i).kisi_sayisi+","+asansor_3.kuyruk.get(i).hedef_kat+"}");
		          System.out.println("\n----------\n");
		          
		                	if(asansor_3.yukari==true&&asansor_3.hareket_edebilir==true&&asansor_3.bulunan_kat<4&&!asansor_3.kuyruk.isEmpty()) {
		                		asansor_3.bulunan_kat++;
		                		
		               }
		            
		                	else if(asansor_3.yukari==false&&asansor_3.bulunan_kat>0)
		                		asansor_3.bulunan_kat--;
		                	//elseleri unutma
		                	
		                	 else if(asansor_3.bulunan_kat==4) {
		                	asansor_3.yukari=false;
		                	
		                	}
		                	
		                	 else if(asansor_3.bulunan_kat!=0&&asansor_3.kuyruk.isEmpty()) {
		                	 
		                	 int su_anki_kat=asansor_3.bulunan_kat;
		                	 int ust_kat=su_anki_kat++;
		                	 boolean yukari_cikmali=false;;
		                	 
		                	 while(ust_kat<=4) {
		                		 
		                		 if(!katlar.get(ust_kat).cikis_kuyrugu.isEmpty()) {
		                		 yukari_cikmali=true;
		                		 break;
		                		 }
		                		 
		                		 ust_kat++;
		                		 
		                	 }
		                	 
		                	 if(yukari_cikmali==true)
		                	 asansor_3.bulunan_kat++;
		                	 
		                	 if(yukari_cikmali==false)
		                		 asansor_3.yukari=false;
		                	 
		                 }
		                	
		                	} 
		                }
		            }
		        });
				
				Thread asansor_4_hareket = new Thread(new Runnable() {
					
					
				     
		            @Override
		            public void run() {
		            	
		            	
		            	
		                while (true) {
		                	
		        			while(asansor_4_durmali.get()==false){
		                
		                	System.out.println("girdi buraya -------------");
		                	try {
								Thread.sleep(200);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	
		                    System.out.println("-----------"+"\n asansor_4 bulundugu kat="+asansor_4.bulunan_kat);
		                	
		                	
		          if(asansor_4.bulunan_kat==0&&asansor_4.yukari==true) {
		        	  
		        	  boolean durdurma=true;
		        	  
		        	  while(durdurma) {
		        		  if(!zemin_kuyrugu.isEmpty()) {
		        			  
		        			  
		        			  asansor_4.kuyruk.add(zemin_kuyrugu.get(0));
			        		  asansor_4.kisi_sayisi+=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(0).siradaki_sayisi-=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  zemin_kuyrugu.remove(0);
		        			
		        			  
		        			  
		        		  }
		        	
		        		  
		        		  System.out.println("girdi -s-----");
		        		  if(zemin_kuyrugu.isEmpty()) {
		        			 
		        			  asansor_4.hareket_edebilir=true;
		        			  durdurma=false;
		        			  
		        			  
		        		  }
		        			
		        		  else  if(asansor_4.kisi_sayisi==10||asansor_4.kisi_sayisi+zemin_kuyrugu.get(0).kisi_sayisi>10) {
		        			
		        			  asansor_4.hareket_edebilir=true;
		        			  durdurma=false;
		        		  }
		        		
		        		  
		        		  
		        	  }
		        	 
		         }
		          
		          if(asansor_4.bulunan_kat==0&&asansor_4.yukari==false) {
		        	  
		        	  while(!asansor_4.kuyruk.isEmpty()) {
			        		 
		        		  exit_count+=asansor_4.kuyruk.get(0).kisi_sayisi;
		        		  asansor_4.kuyruk.remove(0);
		        		  
		        	  }
		        	  asansor_4.kisi_sayisi=0;
		        	  asansor_4.hareket_edebilir=false;
		        	  asansor_4.yukari=true;
		          }
		          
		          //0.kat bitisi
		          System.out.println("asansor yonu yukar:"+asansor_4.yukari);
		          if(asansor_4.bulunan_kat>0&&asansor_4.yukari==true) {
		        	  
		        	  for(int i=0;i<asansor_4.kuyruk.size();i++) {
		        		  
		        		  if(asansor_4.kuyruk.get(i).hedef_kat==asansor_4.bulunan_kat) {
		        			  
		        			  katlar.get(asansor_4.bulunan_kat).kisi_sayisi+=asansor_4.kuyruk.get(i).kisi_sayisi;
		        			  katlar.get(asansor.bulunan_kat).kuyrukta_olmayan+=asansor_4.kuyruk.get(i).kisi_sayisi;
		        			  asansor_4.kisi_sayisi-=asansor_4.kuyruk.get(i).kisi_sayisi;
		        			  asansor_4.kuyruk.remove(i);
		        			 
		        			  i--;
		        			  
		        		  }
		        			  
		        		  
		        	  }
		        	 
		        	  System.out.println("katta bulunan kisi sayisi :"+katlar.get(asansor_4.bulunan_kat).kisi_sayisi);
		        	  
		          }//1,2,3,4. yukari kat bitisi

		          
		        	 if(asansor_4.yukari==false&&asansor_4.bulunan_kat>0) {
		        		 
		        		 boolean durdurma=true;
			        	  
			        	  while(!katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.isEmpty()&&durdurma) {
			        		  
			        		  if(asansor_4.kisi_sayisi+katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi<=10) {
			        		  asansor_4.kuyruk.add(katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0));
			        		  asansor_4.kisi_sayisi+=katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_4.bulunan_kat).kisi_sayisi-=katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_4.bulunan_kat).siradaki_sayisi-=katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.remove(0);
			        		  }
			        		  if(asansor_4.kisi_sayisi>=10) {
			        			
			        			  durdurma=false;
			        			  asansor_4.hareket_edebilir=true;
			        			  break;
			        		  
			        		  }
			        		
			        		  
			        	
                      
			        		  
			        		  if(!katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.isEmpty()) {
			        			  
			        			  if(asansor_4.kisi_sayisi+katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi>10) {
				                      asansor_4.kuyruk.add(new Kuyruk(10-asansor_4.kisi_sayisi,0));
			        			      katlar.get(asansor_4.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi-=10-asansor_4.kisi_sayisi;
			        			      asansor_4.kisi_sayisi=10;
			        			      katlar.get(asansor_4.bulunan_kat).kisi_sayisi-=10-asansor_4.kisi_sayisi;
			        			      katlar.get(asansor_4.bulunan_kat).siradaki_sayisi-=10-asansor_4.kisi_sayisi;
			        				  durdurma=false;
			        			  asansor_4.hareket_edebilir=true;
			        			  break;
			        			  }
			        		  }
		        		 
		        	 }
		          
		        	 }
		  
		          for(int i=0;i<asansor_4.kuyruk.size();i++)
		        	  System.out.print("asansor_4:{"+asansor_4.kuyruk.get(i).kisi_sayisi+","+asansor_4.kuyruk.get(i).hedef_kat+"}");
		          System.out.println("\n----------\n");
		          
		                	if(asansor_4.yukari==true&&asansor_4.hareket_edebilir==true&&asansor_4.bulunan_kat<4&&!asansor_4.kuyruk.isEmpty()) {
		                		asansor_4.bulunan_kat++;
		                		
		               }
		            
		                	else if(asansor_4.yukari==false&&asansor_4.bulunan_kat>0)
		                		asansor_4.bulunan_kat--;
		                	//elseleri unutma
		                	
		                	 else if(asansor_4.bulunan_kat==4) {
		                	asansor_4.yukari=false;
		                	
		                	}
		                	
		                	 else if(asansor_4.bulunan_kat!=0&&asansor_4.kuyruk.isEmpty()) {
		                	 
		                	 int su_anki_kat=asansor_4.bulunan_kat;
		                	 int ust_kat=su_anki_kat++;
		                	 boolean yukari_cikmali=false;;
		                	 
		                	 while(ust_kat<=4) {
		                		 
		                		 if(!katlar.get(ust_kat).cikis_kuyrugu.isEmpty()) {
		                		 yukari_cikmali=true;
		                		 break;
		                		 }
		                		 
		                		 ust_kat++;
		                		 
		                	 }
		                	 
		                	 if(yukari_cikmali==true)
		                	 asansor_4.bulunan_kat++;
		                	 
		                	 if(yukari_cikmali==false)
		                		 asansor_4.yukari=false;
		                	 
		                 }
		                	
		                	} 
		                }
		            }
		        });
				
				Thread asansor_5_hareket = new Thread(new Runnable() {
					
					
				     
		            @Override
		            public void run() {
		            	
		            	
		            	
		                while (true) {
		                	
		        			while(asansor_5_durmali.get()==false){
		                
		                	System.out.println("girdi buraya -------------");
		                	try {
								Thread.sleep(200);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	
		                    System.out.println("-----------"+"\n asansor_5 bulundugu kat="+asansor_5.bulunan_kat);
		                	
		                	
		          if(asansor_5.bulunan_kat==0&&asansor_5.yukari==true) {
		        	  
		        	  boolean durdurma=true;
		        	  
		        	  while(durdurma) {
		        		  if(!zemin_kuyrugu.isEmpty()) {
		        			  
		        			  
		        			  asansor_5.kuyruk.add(zemin_kuyrugu.get(0));
			        		  asansor_5.kisi_sayisi+=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(0).siradaki_sayisi-=zemin_kuyrugu.get(0).kisi_sayisi;
			        		  zemin_kuyrugu.remove(0);
		        			
		        			  
		        			  
		        		  }
		        	
		        		  
		        		  System.out.println("girdi -s-----");
		        		  if(zemin_kuyrugu.isEmpty()) {
		        			 
		        			  asansor_5.hareket_edebilir=true;
		        			  durdurma=false;
		        			  
		        			  
		        		  }
		        			
		        		  else  if(asansor_5.kisi_sayisi==10||asansor_5.kisi_sayisi+zemin_kuyrugu.get(0).kisi_sayisi>10) {
		        			
		        			  asansor_5.hareket_edebilir=true;
		        			  durdurma=false;
		        		  }
		        		
		        		  
		        		  
		        	  }
		        	 
		         }
		          
		          if(asansor_5.bulunan_kat==0&&asansor_5.yukari==false) {
		        	  
		        	  while(!asansor_5.kuyruk.isEmpty()) {
			        		 
		        		  exit_count+=asansor_5.kuyruk.get(0).kisi_sayisi;
		        		  asansor_5.kuyruk.remove(0);
		        		  
		        	  }
		        	  asansor_5.kisi_sayisi=0;
		        	  asansor_5.hareket_edebilir=false;
		        	  asansor_5.yukari=true;
		          }
		          
		          //0.kat bitisi
		          System.out.println("asansor yonu yukar:"+asansor_5.yukari);
		          if(asansor_5.bulunan_kat>0&&asansor_5.yukari==true) {
		        	  
		        	  for(int i=0;i<asansor_5.kuyruk.size();i++) {
		        		  
		        		  if(asansor_5.kuyruk.get(i).hedef_kat==asansor_5.bulunan_kat) {
		        			  
		        			  katlar.get(asansor_5.bulunan_kat).kisi_sayisi+=asansor_5.kuyruk.get(i).kisi_sayisi;
		        			  katlar.get(asansor.bulunan_kat).kuyrukta_olmayan+=asansor_5.kuyruk.get(i).kisi_sayisi;
		        			  asansor_5.kisi_sayisi-=asansor_5.kuyruk.get(i).kisi_sayisi;
		        			  asansor_5.kuyruk.remove(i);
		        			 
		        			  i--;
		        			  
		        		  }
		        			  
		        		  
		        	  }
		        	 
		        	  System.out.println("katta bulunan kisi sayisi :"+katlar.get(asansor_5.bulunan_kat).kisi_sayisi);
		        	  
		          }//1,2,3,4. yukari kat bitisi

		          
		        	 if(asansor_5.yukari==false&&asansor_5.bulunan_kat>0) {
		        		 
		        		 boolean durdurma=true;
			        	  
			        	  while(!katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.isEmpty()&&durdurma) {
			        		  
			        		  if(asansor_5.kisi_sayisi+katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi<=10) {
			        		  asansor_5.kuyruk.add(katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0));
			        		  asansor_5.kisi_sayisi+=katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_5.bulunan_kat).kisi_sayisi-=katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_5.bulunan_kat).siradaki_sayisi-=katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi;
			        		  katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.remove(0);
			        		  }
			        		  if(asansor_5.kisi_sayisi>=10) {
			        			
			        			  durdurma=false;
			        			  asansor_5.hareket_edebilir=true;
			        			  break;
			        		  
			        		  }
			        		
			        		  
			        	
                      
			        		  
			        		  if(!katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.isEmpty()) {
			        			  
			        			  if(asansor_5.kisi_sayisi+katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi>10) {
				                      asansor_5.kuyruk.add(new Kuyruk(10-asansor_5.kisi_sayisi,0));
			        			      katlar.get(asansor_5.bulunan_kat).cikis_kuyrugu.get(0).kisi_sayisi-=10-asansor_5.kisi_sayisi;
			        			     katlar.get(asansor_5.bulunan_kat).kisi_sayisi-=10-asansor_5.kisi_sayisi;
			        			      asansor_5.kisi_sayisi=10;
			        			      katlar.get(asansor_5.bulunan_kat).siradaki_sayisi-=10-asansor_5.kisi_sayisi;
			        				  durdurma=false;
			        			  asansor_5.hareket_edebilir=true;
			        			  break;
			        			  }
			        		  }
		        		 
		        	 }
		          
		        	 }
		  
		          for(int i=0;i<asansor_5.kuyruk.size();i++)
		        	  System.out.print("asansor_5:{"+asansor_5.kuyruk.get(i).kisi_sayisi+","+asansor_5.kuyruk.get(i).hedef_kat+"}");
		          System.out.println("\n----------\n");
		          
		                	if(asansor_5.yukari==true&&asansor_5.hareket_edebilir==true&&asansor_5.bulunan_kat<4&&!asansor_5.kuyruk.isEmpty()) {
		                		asansor_5.bulunan_kat++;
		                		
		               }
		            
		                	else if(asansor_5.yukari==false&&asansor_5.bulunan_kat>0)
		                		asansor_5.bulunan_kat--;
		                	//elseleri unutma
		                	
		                	 else if(asansor_5.bulunan_kat==4) {
		                	asansor_5.yukari=false;
		                	
		                	}
		                	
		                	 else if(asansor_5.bulunan_kat!=0&&asansor_5.kuyruk.isEmpty()) {
		                	 
		                	 int su_anki_kat=asansor_5.bulunan_kat;
		                	 int ust_kat=su_anki_kat++;
		                	 boolean yukari_cikmali=false;;
		                	 
		                	 while(ust_kat<=4) {
		                		 
		                		 if(!katlar.get(ust_kat).cikis_kuyrugu.isEmpty()) {
		                		 yukari_cikmali=true;
		                		 break;
		                		 }
		                		 
		                		 ust_kat++;
		                		 
		                	 }
		                	 
		                	 if(yukari_cikmali==true)
		                	 asansor_5.bulunan_kat++;
		                	 
		                	 if(yukari_cikmali==false)
		                		 asansor_5.yukari=false;
		                	 
		                 }
		                	
		                	} 
		                }
		            }
		        });
				
				Thread cikis = new Thread(new Runnable() {
					
				     
		            @Override
		            public void run() {
		            	
		            	
		            	
		                while (true) {
		                	
		                
		                	 
		                	try {
								Thread.sleep(1000);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                	boolean gec=true;
		                	while(gec==true) {
		                	
		                	int max_kisi_sayisi = 0;
		                	Random random=new Random();
		                	 int hedef_kat= random.nextInt(4)+1;
		                /*	 while(katlar.get(hedef_kat).kuyrukta_olmayan==0) {
		                		 
		                		  hedef_kat= random.nextInt(4)+1;
		                		  max_kisi_sayisi=katlar.get(hedef_kat).kuyrukta_olmayan;
		                		 
		                		  if(max_kisi_sayisi>0)
		                			  break;
		                	 } yeni deneme*/
		                	 
		                	 if(katlar.get(hedef_kat).kuyrukta_olmayan==0)
		                		 gec=true;
		                	 else if(katlar.get(hedef_kat).kuyrukta_olmayan>0) {
		                		  max_kisi_sayisi=katlar.get(hedef_kat).kuyrukta_olmayan;
		                	 gec=false;
		                	 }
		                	if(gec==false) {
		                	
		                	 int cikis_yapmak_isteyen_kisi=0;
		                	 if(max_kisi_sayisi<=4)
		                	 cikis_yapmak_isteyen_kisi=random.nextInt(max_kisi_sayisi)+1;
		                	 else
		                		 cikis_yapmak_isteyen_kisi=random.nextInt(4)+1;
		                	 System.out.println("kat:"+hedef_kat+"kattaki kisi sayisi:"+katlar.get(hedef_kat).kisi_sayisi+" ,cikis yapmak isteyen kisi sayisi: "+cikis_yapmak_isteyen_kisi);
		                	 katlar.get(hedef_kat).siradaki_sayisi+=cikis_yapmak_isteyen_kisi;
		                    katlar.get(hedef_kat).cikis_kuyrugu.add(new Kuyruk(cikis_yapmak_isteyen_kisi,0));
		                    //katlar.get(hedef_kat).kuyrukta_olmayan=katlar.get(hedef_kat).kisi_sayisi-cikis_yapmak_isteyen_kisi;
		                	 
		                	}
		                	 
		                	 
		                	}
		                }
		            }
		        });
				
				
			
				
				
		
				
				
				
				
				Thread kontrol = new Thread(new Runnable() {
					
				     
		            @Override
		            public void run() {
		              	
		         
	                	
		            	
		            	
		                while (true) {
		                	
		                	
		                	/*
		                   	try {
								Thread.sleep(200);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
		                	
		                //	System.out.println("sýradaki kisi sayisi:"+(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi));
		                	
		                if((katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>10&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>20) {
						
								asansor_2_durmali.getAndSet(false);
							
		               //System.out.println("asansor_2 hareket ediyor:.."+asansor_2_durmali);
		                
		                }
		                	
		                else  if(asansor_2.kuyruk.isEmpty()&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)<=20) {
						
		                	asansor_2_durmali.getAndSet(true);
						
		             //  System.out.println("asansor_2 durduruldu");
		                
		                }
		                
		                if((katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>10&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>40) {
							
							asansor_3_durmali.getAndSet(false);
						
	             //  System.out.println("asansor_3 hareket ediyor:.."+asansor_3_durmali);
	                
	                }
	                	
		                else  if(asansor_3.kuyruk.isEmpty()&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)<=40) {
					
	                	asansor_3_durmali.getAndSet(true);
					
	            //   System.out.println("asansor_3 durduruldu");
	                
	                }
		                	
		                if((katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>10&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>60) {
							
		         							asansor_4_durmali.getAndSet(false);
		         						
		         	               //System.out.println("asansor_4 hareket ediyor:.."+asansor_4_durmali);
		         	                
		         	                }
		         	                	
		                else   if(asansor_4.kuyruk.isEmpty()&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)<=60) {
		         					
		         	                	asansor_4_durmali.getAndSet(true);
		         					
		         	              // System.out.println("asansor_4 durduruldu");
		         	                
		         	                }	 
		                	 
		                if((katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>10&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)>80) {
							
		         							asansor_5_durmali.getAndSet(false);
		         						
		         	             //  System.out.println("asansor_5 hareket ediyor:.."+asansor_5_durmali);
		         	                
		         	                }
		         	                	
		                else  if(asansor_5.kuyruk.isEmpty()&&(katlar.get(0).siradaki_sayisi+katlar.get(1).siradaki_sayisi+katlar.get(2).siradaki_sayisi+katlar.get(3).siradaki_sayisi+katlar.get(4).siradaki_sayisi)<=80) {
		         					
		         	                	asansor_5_durmali.getAndSet(true);
		         					
		         	           //    System.out.println("asansor_5 durduruldu");
		         	                
		         	                }
		                
		                
		                }
		            }
		        });
				
				
				
				giris.start();
				asansor_hareket.start();
				cikis.start();
				kontrol.start();
				asansor_2_hareket.start();
				asansor_3_hareket.start();
				asansor_4_hareket.start();
				asansor_5_hareket.start();

			
			
			
			
			}

			
			public void paintComponent(Graphics g){
				
				super.paintComponent(g);
				
				for(int i=1;i<=4;i++)
            		katlar.get(i).kuyrukta_olmayan=katlar.get(i).kisi_sayisi-katlar.get(i).siradaki_sayisi;
				
				g.setColor(Color.WHITE);
				ArrayList <JLabel> label_katlar=new ArrayList<>();
				for(int i=0;i<=4;i++) {
					if(i==0)
				g.drawString(i+":floor :queue :"+katlar.get(i).siradaki_sayisi,0,20);
					else
			 g.drawString(i+":floor :All:"+katlar.get(i).kisi_sayisi+" queue:"+katlar.get(i).siradaki_sayisi+" not queue:"+katlar.get(i).kuyrukta_olmayan,0,(i+1)*20);
					
				
				}
			g.drawString("exit count:"+exit_count, 0,6*20);
			
			//asansor_1
			g.drawString("active:True", 150, 7*20);
			g.drawString("mode:working", 150, 8*20);
			g.drawString("floor:"+asansor.bulunan_kat,150,9*20);
			if(asansor.yukari==true&&asansor.bulunan_kat<4)
				g.drawString("direction:"+(asansor.bulunan_kat+1),150,10*20);
			if(asansor.yukari==true&&asansor.bulunan_kat==4)
				g.drawString("direction:"+(asansor.bulunan_kat),150,10*20);
			if(asansor.yukari==false&&asansor.bulunan_kat>0)
				g.drawString("direction:"+(asansor.bulunan_kat-1),150,10*20);
			if(asansor.yukari==false&&asansor.bulunan_kat==0)
				g.drawString("direction:"+(asansor.bulunan_kat),150,10*20);
			if(asansor.yukari==true)
				g.drawString("direction: up",150,11*20);
			if(asansor.yukari==false)
				g.drawString("direction: down",150,11*20);
			g.drawString("capacity: 10",150,12*20);
			g.drawString("count inside :"+asansor.kisi_sayisi,150,13*20);
			g.drawString("inside:",150,14*20);
			for(int i=0;i<asansor.kuyruk.size();i++)
				g.drawString("["+asansor.kuyruk.get(i).kisi_sayisi+","+asansor.kuyruk.get(i).hedef_kat+"]",190+i*30,14*20);
			
			//asansor_2
			if(asansor_2_durmali.get()==false) {
				g.drawString("active:True", 300, 7*20);
				g.drawString("mode:working", 300, 8*20);
			}
			else if(asansor_2_durmali.get()==true) {
				g.drawString("active:False", 300, 7*20);
			g.drawString("mode:idle", 300, 8*20);
			}
			g.drawString("floor:"+asansor_2.bulunan_kat,300,9*20);
			if(asansor_2.yukari==true&&asansor_2.bulunan_kat<4)
				g.drawString("direction:"+(asansor_2.bulunan_kat+1),300,10*20);
			if(asansor_2.yukari==true&&asansor_2.bulunan_kat==4)
				g.drawString("direction:"+(asansor_2.bulunan_kat),300,10*20);
			if(asansor_2.yukari==false&&asansor_2.bulunan_kat>0)
				g.drawString("direction:"+(asansor_2.bulunan_kat-1),300,10*20);
			if(asansor_2.yukari==false&&asansor_2.bulunan_kat==0)
				g.drawString("direction:"+(asansor_2.bulunan_kat),300,10*20);
			if(asansor_2.yukari==true)
				g.drawString("direction: up",300,11*20);
			if(asansor_2.yukari==false)
				g.drawString("direction: down",300,11*20);
			g.drawString("capacity: 10",300,12*20);
			g.drawString("count inside :"+asansor_2.kisi_sayisi,300,13*20);
			g.drawString("inside:",300,14*20);
			for(int i=0;i<asansor_2.kuyruk.size();i++)
				g.drawString("["+asansor_2.kuyruk.get(i).kisi_sayisi+","+asansor_2.kuyruk.get(i).hedef_kat+"]",340+i*30,14*20);
			
			//asansor_3
			
			if(asansor_3_durmali.get()==false) {
				g.drawString("active:True", 450, 7*20);
				g.drawString("mode:working", 450, 8*20);
			}
			else if(asansor_3_durmali.get()==true) {
				g.drawString("active:False", 450, 7*20);
			g.drawString("mode:idle", 450, 8*20);
			}
			g.drawString("floor:"+asansor_3.bulunan_kat,450,9*20);
			if(asansor_3.yukari==true&&asansor_3.bulunan_kat<4)
				g.drawString("direction:"+(asansor_3.bulunan_kat+1),450,10*20);
			if(asansor_3.yukari==true&&asansor_3.bulunan_kat==4)
				g.drawString("direction:"+(asansor_3.bulunan_kat),450,10*20);
			if(asansor_3.yukari==false&&asansor_3.bulunan_kat>0)
				g.drawString("direction:"+(asansor_3.bulunan_kat-1),450,10*20);
			if(asansor_3.yukari==false&&asansor_3.bulunan_kat==0)
				g.drawString("direction:"+(asansor_3.bulunan_kat),450,10*20);
			if(asansor_3.yukari==true)
				g.drawString("direction: up",450,11*20);
			if(asansor_3.yukari==false)
				g.drawString("direction: down",450,11*20);
			g.drawString("capacity: 10",450,12*20);
			g.drawString("count inside :"+asansor_3.kisi_sayisi,450,13*20);
			g.drawString("inside:",450,14*20);
			for(int i=0;i<asansor_3.kuyruk.size();i++)
				g.drawString("["+asansor_3.kuyruk.get(i).kisi_sayisi+","+asansor_3.kuyruk.get(i).hedef_kat+"]",490+i*30,14*20);
			
			//asansor_4
			
			if(asansor_4_durmali.get()==false) {
				g.drawString("active:True", 600, 7*20);
				g.drawString("mode:working", 600, 8*20);
			}
			else if(asansor_4_durmali.get()==true) {
				g.drawString("active:False", 600, 7*20);
			g.drawString("mode:idle", 600, 8*20);
			}
			g.drawString("floor:"+asansor_4.bulunan_kat,600,9*20);
			if(asansor_4.yukari==true&&asansor_4.bulunan_kat<4)
				g.drawString("direction:"+(asansor_4.bulunan_kat+1),600,10*20);
			if(asansor_4.yukari==true&&asansor_4.bulunan_kat==4)
				g.drawString("direction:"+(asansor_4.bulunan_kat),600,10*20);
			if(asansor_4.yukari==false&&asansor_4.bulunan_kat>0)
				g.drawString("direction:"+(asansor_4.bulunan_kat-1),600,10*20);
			if(asansor_4.yukari==false&&asansor_4.bulunan_kat==0)
				g.drawString("direction:"+(asansor_4.bulunan_kat),600,10*20);
			if(asansor_4.yukari==true)
				g.drawString("direction: up",600,11*20);
			if(asansor_4.yukari==false)
				g.drawString("direction: down",600,11*20);
			g.drawString("capacity: 10",600,12*20);
			g.drawString("count inside :"+asansor_4.kisi_sayisi,600,13*20);
			g.drawString("inside:",600,14*20);
			for(int i=0;i<asansor_4.kuyruk.size();i++)
				g.drawString("["+asansor_4.kuyruk.get(i).kisi_sayisi+","+asansor_4.kuyruk.get(i).hedef_kat+"]",640+i*30,14*20);
			
			
			//asansor_5
			
			
			if(asansor_5_durmali.get()==false) {
				g.drawString("active:True", 750, 7*20);
				g.drawString("mode:working", 750, 8*20);
			}
			else if(asansor_5_durmali.get()==true) {
				g.drawString("active:False", 750, 7*20);
			g.drawString("mode:idle", 750, 8*20);
			}
			g.drawString("floor:"+asansor_5.bulunan_kat,750,9*20);
			if(asansor_5.yukari==true&&asansor_5.bulunan_kat<4)
				g.drawString("direction:"+(asansor_5.bulunan_kat+1),750,10*20);
			if(asansor_5.yukari==true&&asansor_5.bulunan_kat==4)
				g.drawString("direction:"+(asansor_5.bulunan_kat),750,10*20);
			if(asansor_5.yukari==false&&asansor_5.bulunan_kat>0)
				g.drawString("direction:"+(asansor_5.bulunan_kat-1),750,10*20);
			if(asansor_5.yukari==false&&asansor_5.bulunan_kat==0)
				g.drawString("direction:"+(asansor_5.bulunan_kat),750,10*20);
			if(asansor_5.yukari==true)
				g.drawString("direction: up",750,11*20);
			if(asansor_5.yukari==false)
				g.drawString("direction: down",750,11*20);
			g.drawString("capacity: 10",750,12*20);
			g.drawString("count inside :"+asansor_4.kisi_sayisi,750,13*20);
			g.drawString("inside:",750,14*20);
			for(int i=0;i<asansor_5.kuyruk.size();i++)
				g.drawString("["+asansor_5.kuyruk.get(i).kisi_sayisi+","+asansor_5.kuyruk.get(i).hedef_kat+"]",790+i*30,14*20);
			
			//katlar
			
			g.drawString("0.floor:",0,15*20);
			for(int i=0;i<zemin_kuyrugu.size();i++)
				g.drawString("["+zemin_kuyrugu.get(i).kisi_sayisi+","+zemin_kuyrugu.get(i).hedef_kat+"]",40+i*30,15*20);
			
			g.drawString("1.floor:",0,16*20);
			for(int i=0;i<katlar.get(1).cikis_kuyrugu.size();i++)
				g.drawString("["+katlar.get(1).cikis_kuyrugu.get(i).kisi_sayisi+","+katlar.get(1).cikis_kuyrugu.get(i).hedef_kat+"]",40+i*30,16*20);
			
			g.drawString("2.floor:",0,17*20);
			for(int i=0;i<katlar.get(2).cikis_kuyrugu.size();i++)
				g.drawString("["+katlar.get(2).cikis_kuyrugu.get(i).kisi_sayisi+","+katlar.get(2).cikis_kuyrugu.get(i).hedef_kat+"]",40+i*30,17*20);
			
			g.drawString("3.floor:",0,18*20);
			for(int i=0;i<katlar.get(3).cikis_kuyrugu.size();i++)
				g.drawString("["+katlar.get(3).cikis_kuyrugu.get(i).kisi_sayisi+","+katlar.get(3).cikis_kuyrugu.get(i).hedef_kat+"]",40+i*30,18*20);
			
			g.drawString("4.floor:",0,19*20);
			for(int i=0;i<katlar.get(4).cikis_kuyrugu.size();i++)
				g.drawString("["+katlar.get(4).cikis_kuyrugu.get(i).kisi_sayisi+","+katlar.get(4).cikis_kuyrugu.get(i).hedef_kat+"]",40+i*30,19*20);
			
			
			
			repaint();
			
			
			}
			
			
			
			
			
			}  
		
		

