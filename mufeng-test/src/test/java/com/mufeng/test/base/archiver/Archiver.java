package com.mufeng.test.base.archiver;

import com.mufeng.utils.MathUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 归档器
 */
public class Archiver {
	public static void main(String[] args) throws Exception {
//		int[] a={1,2,3,4};
//		int[] b={5,6,7};
//		System.arraycopy(a,0,b,3,2);
//		System.out.println(Arrays.toString(b));
//		File f=new File("D:/transferStation/1.xls");
//		System.out.println(f.length());
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		FileInputStream fis = new FileInputStream(f);
//		byte[] buf = new byte[1024];
//		int len0 = 0 ;
//		while(((len0 = fis.read(buf)) != -1)){
//			baos.write(buf, 0, len0);
//		}
//		fis.close();
//		//得到文件内容
//		byte[] fileContentArr = baos.toByteArray();
//		System.out.println(fileContentArr.length);
//		FileOutputStream fos = new FileOutputStream("d:/transferStation/x.xar");
//		fos.write(addFile("D:/transferStation/1.xls"));
//		fos.write(addFile("D:/transferStation/settings.xml"));
//		fos.write(addFile("D:/transferStation/APP薪资预结首页.png"));
//		fos.close();
		Properties prop=new Properties();
		prop.load(Archiver.class.getClassLoader().getResourceAsStream("sign.properties"));
		System.out.println(prop.getProperty("accountType"));
	}

	/**
	 * 拼接字节数组：文件名长度+文件名本身+文件内容长度+文件内容
	 * @param s
	 * @return
	 */
	private static byte[] addFile(String s) throws Exception{
		File f=new File(s);
		String filename=f.getName();
		//文件内容长度int
		int flength=(int)f.length();
		//文件名长度int
		int fnlength=filename.length();
		byte[] fnattr= MathUtils.int2Bytes(fnlength);
		//初始化总数据
		int total=4+fnlength+4+flength;
		byte[] bytes=new byte[total];
		//拼接文件名长度
		System.arraycopy(fnattr,0,bytes,0,4);
		//拼接文件名本身
		int bfnlen=filename.getBytes().length;
		System.arraycopy(filename.getBytes(),0,bytes,4,bfnlen);
		//拼接文件内容长度
		byte[] flen= MathUtils.int2Bytes(flength);
		System.arraycopy(flen,0,bytes,4+bfnlen,4);
		//拼接文件内容
		FileInputStream fis=new FileInputStream(f);
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] buf=new byte[1024];
		int len;
		while((len=fis.read(buf))!=-1){
			baos.write(buf,0,len);
		}
		byte[] fattr=baos.toByteArray();
		System.arraycopy(fattr,0,bytes,4+bfnlen+4,fattr.length);
		return bytes;
	}
}
