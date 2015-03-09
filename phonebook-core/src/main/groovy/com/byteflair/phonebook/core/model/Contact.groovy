package com.byteflair.phonebook.core.model

import com.byteflair.phonebook.core.serializer.ObjectIdDeserializer
import com.byteflair.phonebook.core.serializer.ObjectIdSerializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
@Document(collection = "contacts")
class Contact {

    @Id
    @Field("_id")
    @JsonSerialize(using = ObjectIdSerializer.class)
    @JsonDeserialize(using = ObjectIdDeserializer.class)
    private ObjectId id
    private String name
    private String phoneNumber
    private String email


    void setId (ObjectId id) {
        this.id = id
    }

    ObjectId getId () {
        id
    }

    void setName (String name) {
        this.name = name
    }

    String getName () {
        name
    }

    void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getPhoneNumber () {
        phoneNumber
    }

    void setEmail (String email) {
        this.email = email
    }

    String getEmail () {
        email
    }
}
