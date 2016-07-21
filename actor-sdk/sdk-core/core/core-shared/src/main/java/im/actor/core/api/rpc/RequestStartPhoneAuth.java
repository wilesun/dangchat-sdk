package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class RequestStartPhoneAuth extends Request<ResponseStartPhoneAuth> {

    public static final int HEADER = 0xbf;
    public static RequestStartPhoneAuth fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestStartPhoneAuth(), data);
    }

    private long phoneNumber;
    private int appId;
    private String apiKey;
    private byte[] deviceHash;
    private String deviceTitle;
    private String timeZone;
    private List<String> preferredLanguages;

    public RequestStartPhoneAuth(long phoneNumber, int appId, @NotNull String apiKey, @NotNull byte[] deviceHash, @NotNull String deviceTitle, @Nullable String timeZone, @NotNull List<String> preferredLanguages) {
        this.phoneNumber = phoneNumber;
        this.appId = appId;
        this.apiKey = apiKey;
        this.deviceHash = deviceHash;
        this.deviceTitle = deviceTitle;
        this.timeZone = timeZone;
        this.preferredLanguages = preferredLanguages;
    }

    public RequestStartPhoneAuth() {

    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getAppId() {
        return this.appId;
    }

    @NotNull
    public String getApiKey() {
        return this.apiKey;
    }

    @NotNull
    public byte[] getDeviceHash() {
        return this.deviceHash;
    }

    @NotNull
    public String getDeviceTitle() {
        return this.deviceTitle;
    }

    @Nullable
    public String getTimeZone() {
        return this.timeZone;
    }

    @NotNull
    public List<String> getPreferredLanguages() {
        return this.preferredLanguages;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.phoneNumber = values.getLong(1);
        this.appId = values.getInt(2);
        this.apiKey = values.getString(3);
        this.deviceHash = values.getBytes(4);
        this.deviceTitle = values.getString(5);
        this.timeZone = values.optString(6);
        this.preferredLanguages = values.getRepeatedString(7);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeLong(1, this.phoneNumber);
        writer.writeInt(2, this.appId);
        if (this.apiKey == null) {
            throw new IOException();
        }
        writer.writeString(3, this.apiKey);
        if (this.deviceHash == null) {
            throw new IOException();
        }
        writer.writeBytes(4, this.deviceHash);
        if (this.deviceTitle == null) {
            throw new IOException();
        }
        writer.writeString(5, this.deviceTitle);
        if (this.timeZone != null) {
            writer.writeString(6, this.timeZone);
        }
        writer.writeRepeatedString(7, this.preferredLanguages);
    }

    @Override
    public String toString() {
        String res = "rpc StartPhoneAuth{";
        res += "phoneNumber=" + this.phoneNumber;
        res += ", deviceHash=" + byteArrayToString(this.deviceHash);
        res += ", deviceTitle=" + this.deviceTitle;
        res += ", timeZone=" + this.timeZone;
        res += ", preferredLanguages=" + this.preferredLanguages;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
