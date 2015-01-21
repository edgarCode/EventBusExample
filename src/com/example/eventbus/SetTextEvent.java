package com.example.eventbus;

public class SetTextEvent {
    private String mText;

    public SetTextEvent() {
        super();
    }

    public SetTextEvent(String text) {
        super();
        this.mText = text;
    }

    public String getText() {
        return mText;
    }
}
