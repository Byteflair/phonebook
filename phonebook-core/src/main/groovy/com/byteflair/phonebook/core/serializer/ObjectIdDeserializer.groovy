package com.byteflair.phonebook.core.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.bson.types.ObjectId

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class ObjectIdDeserializer extends JsonDeserializer<ObjectId> {

    @Override
    ObjectId deserialize (JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {

        new ObjectId(jsonParser.getValueAsString());
    }
}
