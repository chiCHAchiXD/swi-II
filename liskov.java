
//good liskov




package com.osmzhttpserver.logger.messageobservers;

import com.osmzhttpserver.generalhelpers;
public class ObjectifulText{
    private String text;
    
    public ObjectifulText(List<char> text){
        this.text = generalhelpers.createString(text);
    }
    
    public ObjectifulText(String text){
        this.text = text;
    }
    
    public this getString(){
        return this.text;
    }
    
}

public interface MessageInterface {
    public String getText();

    public void setText(ObjectifulText text);

    public String getAuthor();

    public void setAuthor(ObjectifulText author);
}




public class Message implements MessageInterface {
    private ObjectifulText text;
    private ObjectifulText author;

    public Message(){}

    public Message(ObjectifulText author, ObjectifulText text){
        setAuthor(author);
        setText(text);
    }

    public String getText() {
        return text.getString();
    }

    public void setText(ObjectifulText text) {
        this.text = text;
    }

    public String getAuthor() {
        return author.getString();
    }

    public void setAuthor(ObjectifulText author) {
        this.author = author;
    }
}

