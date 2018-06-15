package com.wj.jsonlib;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;


public class TimestampMorpherTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String []args){
		String jsonString = "[{'id':'test','vdate':'2018-06-14T17:08:44'}]";
		
		JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(Timestamp.class));
		
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
        List objectList = new ArrayList();
        for (Iterator iter = jsonArray.iterator(); iter.hasNext();) {
            JSONObject jsonObject = (JSONObject) iter.next();
            objectList.add(JSONObject.toBean(jsonObject, People.class));
        }
        
        for(Object obj : objectList){
        	People p = (People) obj;
        	System.out.println(p.getVdate());
        }
	}
}
