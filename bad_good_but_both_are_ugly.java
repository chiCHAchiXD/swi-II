
//bad liskov

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


/*
this is an example over an actual project to a subject of mine.
this is very bad implementation of the solution and also feels weak.
on the other hand this shows as disregard for Overriding of methods from interface, which in casual java IDE would not want to compile :L 

The problem is obvious, the interface creates methods for setting Author and Text as a string. Programmer is lazy and weird though and wanted to make an amazing overhaul of a code with tinkering with lightweight List of Characters instead of complicated and highlevel String class. Programmer also made some unreasonable decisions which lead to a unreasonable usages of complicated methods in background.
The solution of a programmer was simply abstracting the whole String and List problematics in order to unify these two complex and extremely different approaches. 

Liskov was hereby violated with not overriding methods.
Liskov was hereby solved with another class on top of simple List of Characters or String.

*/
