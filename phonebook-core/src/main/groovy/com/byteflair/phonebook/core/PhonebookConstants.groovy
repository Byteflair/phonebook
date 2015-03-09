package com.byteflair.phonebook.core

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class PhonebookConstants {

    public final static String HEADER_ITEM_COUNT = "vnd.byteflair.phonebook.count";
    public final static int ITEMS_PER_PAGE = 30;

    static PhonebookPager getPage (Integer page, Integer limit) {
        new PhonebookPager (page, limit)
    }
}
