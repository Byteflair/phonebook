package com.byteflair.phonebook.api.controller;

import com.byteflair.phonebook.api.exception.BadRequestException;
import com.byteflair.phonebook.api.exception.NotFoundException;
import com.byteflair.phonebook.api.form.ContactPostForm;
import com.byteflair.phonebook.api.form.validator.ContactPostFormValidator;
import com.byteflair.phonebook.api.hateoas.LinkCollection;
import com.byteflair.phonebook.core.PhonebookConstants;
import com.byteflair.phonebook.core.exception.BadArgumentException;
import com.byteflair.phonebook.core.exception.EntityNotFoundException;
import com.byteflair.phonebook.core.model.Contact;
import com.byteflair.phonebook.core.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
@RestController
@RequestMapping("/contacts")
class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactService contactService;
    @Autowired
    ConversionService conversionService;

    @InitBinder ("contactPostForm")
    protected static void initContactPostBinder(WebDataBinder binder) {
        binder.addValidators(new ContactPostFormValidator());
    }

    // GET /contacts?page=:page&limit=:limit
    @RequestMapping (method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity<List<Contact>> listContacts (
            @RequestParam (value = "page", required = false) Integer page,
            @RequestParam (value = "limit", required =  false) Integer limit) {
        Page<Contact> contactPage = contactService.listContacts(page, limit);

        // Build response headers
        HttpHeaders headers = new HttpHeaders();
        LinkCollection links = new LinkCollection();
            // Count
        headers.add(PhonebookConstants.HEADER_ITEM_COUNT, String.valueOf(contactPage.getNumberOfElements()));

            // First page
        if (!contactPage.isFirst()) {
            links.addLink(linkTo(
                            methodOn(ContactController.class).listContacts(0, limit)).withRel("first")
            );
        }
            // Previous page
        if (contactPage.hasPrevious()) {
            links.addLink(linkTo(
                            methodOn(ContactController.class).listContacts(contactPage.previousPageable().getPageNumber(), limit)).withRel("previous")
            );
        }
            // Next page
        if (contactPage.hasNext()) {
            links.addLink(linkTo(
                    methodOn(ContactController.class).listContacts(contactPage.nextPageable().getPageNumber(), limit)).withRel("next")
            );
        }
            // Last page
        if (!contactPage.isLast()) {
            links.addLink(linkTo(
                            methodOn(ContactController.class).listContacts(contactPage.getTotalPages(), limit)).withRel("last")
            );
        }

        headers.add("Link", links.asHeader());

        return new ResponseEntity<>(contactPage.getContent(), headers, HttpStatus.OK);
    }

    // HEAD /contacts?page=:page&limit=:limit
    @RequestMapping (method = RequestMethod.HEAD, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity<?> countContacts (
            @RequestParam (value = "page", required = false) Integer page,
            @RequestParam (value = "limit", required =  false) Integer limit) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(PhonebookConstants.HEADER_ITEM_COUNT, String.valueOf(contactService.countContacts(page, limit)));

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    // GET /contacts/:id
    @RequestMapping (value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity<Contact> getContact(
            @PathVariable (value = "id") String contactId) throws BadRequestException, NotFoundException {

        Contact contact;
        try {
            contact = contactService.getContact(contactId);
        } catch (BadArgumentException ba) {
            throw new BadRequestException(ba.getMessage(), ba);
        } catch (EntityNotFoundException enf) {
            throw new NotFoundException(enf.getMessage(), enf);
        }

        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    // POST /contacts
    @RequestMapping (method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity<Contact> createContact (
            @RequestBody ContactPostForm contactPostForm) throws BadRequestException, NotFoundException {

        Contact contact = conversionService.convert(contactPostForm, Contact.class);
        Contact saved = contactService.create(contact);

        // Build response headers
        HttpHeaders headers = new HttpHeaders();
        LinkCollection links = new LinkCollection();

            // Self link
        links.addLink(linkTo(
                methodOn(ContactController.class).getContact(saved.getId().toString())).withSelfRel()
        );

        headers.add("Link", links.asHeader());

        return new ResponseEntity<>(contact, headers, HttpStatus.CREATED);
    }

    // PUT /contacts/:id
    @RequestMapping (value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity<?> updateContact(
            @PathVariable (value = "id") String contactId,
            @RequestBody ContactPostForm contactPostForm) throws BadRequestException, NotFoundException {

        try {
            Contact contact = conversionService.convert(contactPostForm, Contact.class);
            contactService.update(contactId, contact);
        } catch (EntityNotFoundException enf) {
            throw new NotFoundException(enf.getMessage(), enf);
        } catch (BadArgumentException ba) {
            throw new BadRequestException(ba.getMessage(), ba);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DELETE /contacts/:id
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    ResponseEntity<?> deleteContact(
            @PathVariable (value = "id") String contactId) throws BadRequestException, NotFoundException {

        try {
            contactService.delete(contactId);
        } catch (EntityNotFoundException enf) {
            throw new NotFoundException(enf.getMessage(), enf);
        } catch (BadArgumentException ba) {
            throw new BadRequestException(ba.getMessage(), ba);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}