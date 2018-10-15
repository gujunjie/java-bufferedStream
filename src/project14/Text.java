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
		
		//1.������Ӧ��Ҫ�������ļ�
		File file=new File("d:\\abc\\1.mp4");
		File file2=new File("d:\\abc\\2.mp4");
		
		//2.����Ҫʹ�õĽڵ����Լ�������,���ֽ��������βδ��뻺�����Ĺ�������
		FileInputStream fis=null;
		FileOutputStream fos =null;
		
		BufferedInputStream bis =null;
		BufferedOutputStream bos =null;
        try {
			 fis=new FileInputStream(file);
			 fos =new FileOutputStream(file2);
			
			 bis =new BufferedInputStream(fis);
			 bos =new BufferedOutputStream(fos);
			
			byte[] b=new byte[1024];//ÿ�ζ�ȡ1024���ֽڵ�byte������
			int len=0;//ʵ�ʶ�ȡ�����ֽڳ���
			
			while((len=bis.read(b))!=-1)
			{
				bos.write(b,0,len);//д���ļ�
				bos.flush();//������
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
				}//�رն�Ӧ�Ļ������Ϳ����Զ��ر��ֽ���
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
