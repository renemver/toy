package com.lsy.toy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

public class EcmUtil {

//	private static Logger log = Logger.getLogger("main");
	public static asysConnectData con = new asysConnectData("192.168.100.35", 50011, "Toy", "SUPER", "SUPER");

	public static void download(String path, String elementId) throws Exception {
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_archive = "MAIN";
		uePage1.m_elementId = "XTORM_MAIN::"+elementId+"::IMAGE";
		int ret = uePage1.getContent(path+"/"+elementId, "", "");
		if (ret != 0) {
			System.out.println("["+Thread.currentThread().getName() +"] Error - download, " + uePage1.m_lastError);
//			log.error("["+Thread.currentThread().getName() +"] Error - download, " + uePage1.m_lastError);
		}
		else {
//			log.debug("["+Thread.currentThread().getName() +"] Success - download, " + uePage1.m_elementId);
		}
	}

	public static void download_view(String path, String elementId, String ext) throws Exception {
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_archive = "MAIN";
		uePage1.m_elementId = "XTORM_MAIN::"+elementId+"::IMAGE";
		int ret = uePage1.getContent(path+"/"+elementId + "." + ext, "", "");
		if (ret != 0) {
			System.out.println("["+Thread.currentThread().getName() +"] Error - download, " + uePage1.m_lastError);
//			log.error("["+Thread.currentThread().getName() +"] Error - download, " + uePage1.m_lastError);
		}
		else {
//			log.debug("["+Thread.currentThread().getName() +"] Success - download, " + uePage1.m_elementId);
		}
	}
	
	public static String create(String filename, String classid ) throws Exception{
		asysUsrElement uePage1 = new asysUsrElement(con);
	//	uePage1.m_fileIn = is;
		uePage1.m_localFile = filename;
		uePage1.m_cClassId = classid; // .m_archive = "CAS_ARC";
		uePage1.m_userSClass = "SUPER";
		uePage1.m_eClassId = "IMAGE";
		uePage1.m_descr= "TEST";
		// 사용자 인덱스 지정
//		uePage1.addIndexValue("DOC", "f1", "1");
//		uePage1.addIndexValue("DOC", "f2", "1");

		int ret = uePage1.create("XTORM_MAIN");	
		// Check for errors - last message always in API object
		if (ret != 0) {
			System.out.println("["+Thread.currentThread().getName() +"] Error - create, " + uePage1.m_lastError);
//			log.error("["+Thread.currentThread().getName() +"] Error - create, " + uePage1.getLastError());
		}
		else {
//			log.debug("["+Thread.currentThread().getName() +"] Success - create, " + uePage1.m_elementId);
		}
		
		String str[] = uePage1.m_elementId.split("::");
		String result = str[1];
		
		return result;
	}

	public static void delete(String elementId) throws Exception {
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
		
		int ret = uePage1.delete();
		
		if (ret != 0) {
			System.out.println("["+Thread.currentThread().getName() +"] Error - delete, " + uePage1.m_lastError);
//			log.error("Error - delete, " + uePage1.getLastError());
		}
		else {
//			log.debug("Success - delete, " + elementId);
		}
	}

	public static void replace(String path, String elementId, String fnm, String fparm) throws Exception {
		int ret = 0;
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
		if(fnm!=null&&fparm!=null) {
			ret = uePage1.replaceContent(path, fnm, fparm);
		}
		else {
			ret = uePage1.replaceContent(path, "", "");
		}
		
		if (ret != 0) {
			System.out.println("["+Thread.currentThread().getName() +"] Error - replace, " + uePage1.m_lastError);
//			log.error("Error - replace, " + uePage1.getLastError());
		}
//		else
//			log.debug("Success - replace, " + uePage1.m_elementId);

	}
}