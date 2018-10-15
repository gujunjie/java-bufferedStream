package project14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;







public class Text {

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		
		//1.创建相应的要操作的文件
		File file=new File("d:\\abc\\1.mp4");
		File file2=new File("d:\\abc\\2.mp4");
		
		//2.创建要使用的节点流以及缓冲流,把字节流当作形参传入缓冲流的构造器中
		FileInputStream fis=null;
		FileOutputStream fos =null;
		
		BufferedInputStream bis =null;
		BufferedOutputStream bos =null;
        try {
			 fis=new FileInputStream(file);
			 fos =new FileOutputStream(file2);
			
			 bis =new BufferedInputStream(fis);
			 bos =new BufferedOutputStream(fos);
			
			byte[] b=new byte[1024];//每次读取1024个字节到byte数组中
			int len=0;//实际读取到的字节长度
			
			while((len=bis.read(b))!=-1)
			{
				bos.write(b,0,len);//写入文件
				bos.flush();//缓冲流
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bis!=null)
			{
				try {
					bis.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(bos!=null)
			{
				try {
					bos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}//关闭对应的缓冲流就可以自动关闭字节流
			}
		}
        
        long endTime=System.currentTimeMillis();
        
        System.out.println(new Date(startTime));
        System.out.println(new Date(endTime));
        
        
        File file3=new File("d:\\abc\\abc.txt");
        File file4=new File("d:\\abc\\abc7.txt");
        
        
        FileReader  fr=null;
        FileWriter   fw=null;
        
        BufferedReader br =null;
        BufferedWriter bw=null;
        
        try {
        	fr=new FileReader(file3);
        	fw=new FileWriter(file4);
        	
        	br=new BufferedReader(fr);
        	bw=new BufferedWriter(fw);
        	
        	String s;
        	while((s=br.readLine())!=null)
        	{
        		bw.write(s);
        		bw.flush();
        	}
        	
        	
        }catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        
	}

}
}
