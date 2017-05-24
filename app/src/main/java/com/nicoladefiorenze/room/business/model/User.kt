package com.nicoladefiorenze.room.business.model

/**
 * Project: Room<br/>
 * created on: 2017-05-24
 *
 * @author Nicola De Fiorenze
 */
data class User(val id: Int, val name:String, val  emails: List<Email>)