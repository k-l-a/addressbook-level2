package seedu.addressbook.ui;



import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Formatter, used to format the text of the application for display.
 */
public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    static final String LS = System.lineSeparator();

    static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    static final int DISPLAYED_INDEX_OFFSET = 1;


    public Formatter() {
    }
    
    /** Formats strings to be displayed by the UI */
    public String format(String...message) {
        StringBuilder sb = new StringBuilder();
        for (String m : message) {
            sb.append(LINE_PREFIX) ;
            sb.append(m.replace("\n", LS + LINE_PREFIX));
        }
        return sb.toString();
    }
    
    /** Formats a list of persons as an indexed list */
    public List<String> getPersonListForViewing(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formattedPersons;
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
