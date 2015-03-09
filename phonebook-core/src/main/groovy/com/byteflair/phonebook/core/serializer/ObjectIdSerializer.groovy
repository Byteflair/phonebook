package com.byteflair.phonebook.core.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.bson.types.ObjectId

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class ObjectIdSerializer extends JsonSerializer<ObjectId> {

    @Override
    void serialize(ObjectId value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if (value) {
            jsonGenerator.writeString(value.toString())
        } else {
            jsonGenerator.writeNull()
        }
    }
}
