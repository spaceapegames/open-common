package com.spaceape.betsnap.util

import com.spaceape.betsnap.util.JsonUtil._
import org.junit.Test
import org.junit.Assert._
import play.api.libs.json.Json
import play.api.libs.json.JsObject

class JsonUtilTest {
	@Test def test_getStringValue_whenFieldExists(){
	    var str = "{\"name\": \"PP\"}"
		var jsonO = Json.parse(str).as[JsObject]
	    
	    assertEquals("PP", getStringValue(jsonO)("name"))
	}
	
	@Test def test_getStringValue_whenFieldNotExist(){
	    var str = "{\"name\": \"PP\"}"
		var jsonO = Json.parse(str).as[JsObject]
	    
	    assertEquals(null, getStringValue(jsonO)("id"))
	}
	
	@Test def test_getNumberValue_whenFieldExists(){
	    var str = "{\"name\": 99}"
		var jsonO = Json.parse(str).as[JsObject]
	    
	    assertEquals(99, getNumberValue(jsonO)("name").intValue)
	}
	
	@Test def test_getNumberValue_whenFieldNotExist(){
	    var str = "{\"name\": \"PP\"}"
		var jsonO = Json.parse(str).as[JsObject]
	    
	    assertEquals(null, getNumberValue(jsonO)("id"))
	}
}