package com.spaceape.betsnap.util

import play.api.libs.json._

object JsonUtil {
	def isType:  (JsValue => String => Boolean) = msg => expected_typename =>  {
        (msg \ "type") match {
            case JsString(typename) => {
                typename.equals(expected_typename)
            }
            case _ => {
                assert(false)
                false
            }
        }
    }
    
    def getStringValue: (JsValue => String => String) = msg => expected_attr => {
        (msg \ expected_attr) match {
            case JsString(actual_value) => {
                actual_value
            }
            case _ => {
                null
            }
        }
    } 
    
    def getNumberValue: (JsValue => String => BigDecimal) = msg => expected_attr => {
        (msg \ expected_attr) match {
            case JsNumber(actual_value) => {
                actual_value
            }
            case _ => {
                null
            }
        }
    } 
}