package com.byteflair.phonebook.api.form.converter

import com.byteflair.phonebook.api.form.ContactPostForm
import com.byteflair.phonebook.core.model.Contact
import org.springframework.beans.BeanUtils
import org.springframework.core.convert.converter.Converter

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class ContactPostFormConverter implements Converter<ContactPostForm, Contact> {

    @Override
    Contact convert(ContactPostForm source) {
        Contact contact = new Contact()
        contact.name = source.name
        contact.email = source.email
        contact.phoneNumber = source.phoneNumber

        contact
    }
}
