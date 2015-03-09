package com.byteflair.phonebook.api.form.validator

import com.byteflair.phonebook.api.form.ContactPostForm
import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class ContactPostFormValidator implements Validator{

    @Override
    boolean supports(Class<?> clazz) {
        ContactPostForm.class.isAssignableFrom(clazz)
    }

    @Override
    void validate(Object target, Errors errors) {
        ContactPostForm contactPostForm = (ContactPostForm) target

        if (!contactPostForm.name) {
            errors.reject("contact.name",
                    "Contact name cannot be empty")
        }
    }
}
