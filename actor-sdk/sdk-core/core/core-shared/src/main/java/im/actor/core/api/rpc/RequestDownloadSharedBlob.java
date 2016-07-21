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

public class RequestDownloadSharedBlob extends Request<ResponseDownloadSharedBlob> {

    public static final int HEADER = 0xa66;
    public static RequestDownloadSharedBlob fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestDownloadSharedBlob(), data);
    }

    private ApiUserOutPeer destPeer;
    private String bucket;
    private int objectId;

    public RequestDownloadSharedBlob(@NotNull ApiUserOutPeer destPeer, @NotNull String bucket, int objectId) {
        this.destPeer = destPeer;
        this.bucket = bucket;
        this.objectId = objectId;
    }

    public RequestDownloadSharedBlob() {

    }

    @NotNull
    public ApiUserOutPeer getDestPeer() {
        return this.destPeer;
    }

    @NotNull
    public String getBucket() {
        return this.bucket;
    }

    public int getObjectId() {
        return this.objectId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.destPeer = values.getObj(1, new ApiUserOutPeer());
        this.bucket = values.getString(2);
        this.objectId = values.getInt(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.destPeer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.destPeer);
        if (this.bucket == null) {
            throw new IOException();
        }
        writer.writeString(2, this.bucket);
        writer.writeInt(3, this.objectId);
    }

    @Override
    public String toString() {
        String res = "rpc DownloadSharedBlob{";
        res += "destPeer=" + this.destPeer;
        res += ", bucket=" + this.bucket;
        res += ", objectId=" + this.objectId;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
