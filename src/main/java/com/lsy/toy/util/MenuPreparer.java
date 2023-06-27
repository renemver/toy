package com.lsy.toy.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsy.toy.dao.IDao;

public class MenuPreparer implements ViewPreparer {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
    public void execute(Request request, AttributeContext attributeContext) throws PreparerException {
    	System.out.println("test header");

    	List<String> menuList = new ArrayList<String>();
    	String main_cd ="01";

		IDao dao = sqlSession.getMapper(IDao.class);
//		menuList.addAll(dao.maincd_view(main_cd));
        
        attributeContext.putAttribute("menuList", new Attribute(menuList), true);
    }

 
}
