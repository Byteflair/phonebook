package com.byteflair.phonebook.api.hateoas

import org.springframework.hateoas.Link

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class LinkCollection {

    private final List<Link> links = new ArrayList<Link>();

    LinkCollection addLink (Link link) {
        this.links.add(link)
        this
    }

    static String toHeaderString(Link link) {
        StringBuilder buffer = new StringBuilder()
        buffer.append("<").append(link.getHref()).append(">").append("; ")
                .append("rel=").append(link.getRel())
        buffer.toString()
    }

    String asHeader() {
        StringBuilder buffer = new StringBuilder();

        boolean first = true;
        for (Link link : this.links) {
            if (first) {
                first = false;
            } else {
                buffer.append(" : ")
            }
            buffer.append(toHeaderString(link))
        }

        buffer.toString()
    }
}
