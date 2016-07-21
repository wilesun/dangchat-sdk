package im.actor.core.entity.signals;

import java.io.IOException;

import im.actor.runtime.bser.BserValues;
import im.actor.runtime.bser.BserWriter;

public class AnswerSignal extends AbsSignal {

    public static final String TYPE = "answer";

    private String sdp;

    public AnswerSignal(String sdp) {
        this.sdp = sdp;
    }

    public AnswerSignal() {
    }

    public String getSdp() {
        return sdp;
    }

    @Override
    public void parseSignal(BserValues values) throws IOException {
        this.sdp = values.getString(2);
    }

    @Override
    public void serializeSignal(BserWriter writer) throws IOException {
        writer.writeString(2, sdp);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "{type: " + TYPE + ", sdp: " + sdp + "}";
    }
}
