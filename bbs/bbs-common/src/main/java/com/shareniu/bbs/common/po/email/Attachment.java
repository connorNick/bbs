package com.shareniu.bbs.common.po.email;

import java.io.Serializable;
import java.net.URL;

public interface Attachment extends Serializable {
    String getPath();

    URL getUrl();

    byte[] getBytes();

    void writeBytesToFile();

    String getAttachName();

    String getDescription();
}
