package com.byteflair.phonebook.core.service

import com.byteflair.phonebook.core.PhonebookConstants
import com.byteflair.phonebook.core.exception.BadArgumentException
import com.byteflair.phonebook.core.exception.EntityNotFoundException
import com.byteflair.phonebook.core.model.Contact
import com.byteflair.phonebook.core.repository.mongo.ContactRepository
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
@Service
class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class)

    @Autowired
    ContactRepository contactRepository

    Page<Contact> listContacts (Integer page, Integer limit) {

        contactRepository.findAll(PhonebookConstants.getPage(page, limit).getPageSpecification(Sort.Direction.ASC, "name"))
    }

    Integer countContacts (Integer page, Integer limit) {

        contactRepository.findAll(PhonebookConstants.getPage(page, limit).getPageSpecification(Sort.Direction.ASC, "name")).numberOfElements
    }

    Contact getContact (String id) throws BadArgumentException, EntityNotFoundException {
        // Validate input
        if (!id || !ObjectId.isValid(id)) {
            logger.info(String.format("Requested contact with invalid id: %s", id))
            throw new BadArgumentException(String.format("%s is not a valid contact id", id))
        }

        Contact contact = contactRepository.findOne(new ObjectId(id))

        // Check that the contact exists
        if (!contact) {
            logger.info(String.format("Requested contact with id: %s does not exists", id))
            throw new EntityNotFoundException(String.format("The requested contact with id: %s does not exists", id))
        }

        contact
    }

    Contact create (Contact contact) {

        contactRepository.save(contact)
    }

    Contact update (String id, Contact contact) throws BadArgumentException, EntityNotFoundException {
        // Validate input
        if (!id || !ObjectId.isValid(id)) {
            logger.info(String.format("Requested contact with invalid id: %s", id))
            throw new BadArgumentException(String.format("%s is not a valid contact id", id))
        }

        contact.id = new ObjectId(id)
        if (!contactRepository.findOne(contact.id)) {
            logger.info(String.format("Requested contact with id: %s does not exists", contact.id))
            throw new EntityNotFoundException(String.format("The requested contact with id: %s does not exists", contact.id))
        }


        contactRepository.save(contact)
    }

    void delete (String id) throws BadArgumentException, EntityNotFoundException {
        // Validate input
        if (!id || !ObjectId.isValid(id)) {
            logger.info(String.format("Requested contact with invalid id: %s", id))
            throw new BadArgumentException(String.format("%s is not a valid contact id", id))
        }
        if (!contactRepository.findOne(new ObjectId(id))) {
            logger.info(String.format("Requested contact with id: %s does not exists", id))
            throw new EntityNotFoundException(String.format("The requested contact with id: %s does not exists", id))
        }

        contactRepository.delete(new ObjectId(id))
    }
}
