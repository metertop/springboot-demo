package com.example.demo.utils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 对象压缩及解压缩工具类
 * @author cailin
 *
 */
public final class CompressObject {
	/**
	 * 压缩
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static byte[] writeCompressObject(Object obj) throws IOException {
		byte[] byteDate = null;
		ByteArrayOutputStream o = new ByteArrayOutputStream();
		GZIPOutputStream gzout = new GZIPOutputStream(o);
		ObjectOutputStream out = new ObjectOutputStream(gzout);
		out.writeObject(obj);
		out.flush();
		out.close();
		gzout.close();
		byteDate = o.toByteArray();
		o.close();
		return byteDate;
	}

	/**
	 * 对象解压缩
	 * @return 加压后的对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object readCompressObject(byte[] byteData)
			throws IOException, ClassNotFoundException {
		if(byteData==null) return null;
		Object obj = null;
		ByteArrayInputStream i = new ByteArrayInputStream(byteData);
		GZIPInputStream gzin = new GZIPInputStream(i);
		ObjectInputStream in = new ObjectInputStream(gzin);
		obj = in.readObject();
		i.close();
		gzin.close();
		in.close();
		return obj;
	}
	
}
