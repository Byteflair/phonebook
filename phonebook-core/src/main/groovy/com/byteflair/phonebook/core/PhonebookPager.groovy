package com.byteflair.phonebook.core

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class PhonebookPager {

    private Integer page
    private Integer limit

    PhonebookPager() {}

    PhonebookPager(Integer page, Integer limit) {
        setPage page
        setLimit limit
    }

    void setPage (Integer page) {
        this.page = (page && page >= 0) ? page : null
    }

    int getPage () {
        page ? page : 0
    }

    void setLimit (Integer limit) {
        this.limit = (limit && limit >= 0) ? (limit <= PhonebookConstants.ITEMS_PER_PAGE) ? limit : PhonebookConstants.ITEMS_PER_PAGE : null
    }

    int getLimit() {
        limit ? limit : PhonebookConstants.ITEMS_PER_PAGE
    }

    PageRequest getPageSpecification (String... sortFields) {
        getPageSpecification (Sort.Direction.DESC, sortFields)
    }

    PageRequest getPageSpecification(Sort.Direction direction, String... sortFields) {
        getPageSpecification(new Sort(direction, sortFields))
    }

    PageRequest getPageSpecification (Sort sort) {
        return new PageRequest(getPage(), getLimit(), sort);
    }
}
