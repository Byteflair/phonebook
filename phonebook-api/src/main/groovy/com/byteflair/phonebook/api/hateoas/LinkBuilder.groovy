package com.byteflair.phonebook.api.hateoas

import org.springframework.hateoas.Link


/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class LinkBuilder {

    static LinkCollection addLink(Link link) {
        new LinkCollection().addLink(link)
    }
}
