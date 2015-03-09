package com.byteflair.phonebook.core.repository.mongo

import com.byteflair.phonebook.core.model.Contact
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
interface ContactRepository extends CrudRepository<Contact, ObjectId> {

    Page<Contact> findAll (Pageable pageable)
}