
package com.osmzhttpserver.logger.messageobservers;

public interface MessageInterface {
    public String getText();

    public void setText(String text);

    public String getAuthor();

    public void setAuthor(String author);
}


package com.osmzhttpserver.logger.messageobservers;

import com.osmzhttpserver.generalhelpers;

public class Message implements MessageInterface {
    private String text;
    private String author;

    public Message(){}

    public Message(List<char> author, String text){
        setAuthor(generalhelpers.createString(author));
        setText(generalhelpers.createCharList(text));
    }

    public String getText() {
        return text;
    }

    public void setText(List<char> text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}



