package com.example.demo.model

import com.github.avrokotlin.avro4k.AvroName
import com.github.avrokotlin.avro4k.AvroNamespace
import kotlinx.serialization.Serializable

@Serializable
@AvroNamespace("com.example.demo")
@AvroName("UserMutation")
data class UserMutation(
        val id: Long,
        val name: String,
        val contacts: List<Contact>,
        val address: Address,
        val birthday: String
)

@Serializable
@AvroNamespace("com.example.demo")
@AvroName("Contact")
data class Contact(
        val type: ContactType,
        val value: String
)

@Serializable
@AvroNamespace("com.example.demo")
@AvroName("ContactType")
enum class ContactType {

    EMAIL,
    PHONE
}

@Serializable
@AvroNamespace("com.example.demo")
@AvroName("Address")
data class Address(
        val street: String,
        val number: String,
        val zip: String,
        val city: String,
        val state: String
)

