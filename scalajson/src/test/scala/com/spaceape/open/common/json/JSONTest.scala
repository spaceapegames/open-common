package com.spaceape.open.common.json

import scala.math.BigDecimal.int2bigDecimal

import org.junit.Assert.assertTrue
import org.junit.Test

import play.api.libs.json._
import org.junit._
import Assert._

class JSONTest {
	@Test def test_add_field(){
		var str = "{\"name\": \"PP\"}"
		var jsonO = Json.parse(str).as[JsObject]
		jsonO = jsonO.++(JsObject(List("time" -> JsNumber(190))))
		
		var expecting = """{"name":"PP","time":190}"""
		assertEquals(expecting, Json.stringify(jsonO))
	}
	
	@Test def test_query_optional_field(){
		var str = "{\"name\": \"PP\"}"
		var jsonO = Json.parse(str)
		var result = jsonO \ "time"
		assertTrue(result.isInstanceOf[JsUndefined])
		
		result = jsonO \ "name"
		assertTrue(result.isInstanceOf[JsString])
	}
	
	@Test def test_deserialize(){
		var str = """ {"token":"2","groupname":"default","message":{"username":"Lu","@type":"UserSignIn"},"@type":"BroadcastRequest"} """
	    var jsonO = Json.parse(str)
	    
	    assertEquals(JsString("default"), jsonO \ "groupname")
	    
		var result = jsonO \ "message"
		
		assertEquals(JsString("Lu"), result \ "username")
	}
	
	@Test def test_set_value(){
	    var str = """ {"token":"2","groupname":"default"} """
	    var jsonO = Json.parse(str).asInstanceOf[JsObject]
	    
	    jsonO = jsonO.++ (JsObject(List("groupname" -> JsString("newname"))))
	    
	    assertEquals(JsString("newname"), jsonO \ "groupname")
	}
}