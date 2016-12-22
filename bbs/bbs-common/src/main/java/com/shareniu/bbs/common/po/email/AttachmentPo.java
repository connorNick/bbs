package com.shareniu.bbs.common.po.email;

import java.net.URL;

/**
 * 附件po
 *
 * Created by wzy on 2015/5/12.
 */
public class AttachmentPo {

    private static final long serialVersionUID = 3177990807368404123L;
    private String path;

    private URL url;

    private byte[] bytes;

    private String attachName;

    private String description;

    /**
     * 获取附件地址
     * <p/>
     * <p>优先级别高于<code>getUrl()</code></p>
     *
     * @return 附件地址
     */
    public String getPath() {
        return this.path;
    }

    /**
     * 获取附件地址
     *
     * @return 附件地址
     */
    public URL getUrl() {
        return this.url;
    }

    /**
     * 获取文件的byte数组
     *
     * @return 附件
     */
    public byte[] getBytes() {
        return this.bytes;
    }



    /**
     * 获取附件名称
     * <p/>
     * <p>附件名称必须带后缀名</p>
     *
     * @return 附件名称
     */
    public String getAttachName() {
        return this.attachName;
    }

    /**
     * 获取附件描述
     *
     * @return 附件描述
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets new attachName.
     *
     * @param attachName New value of attachName.
     */
    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    /**
     * Sets new path.
     *
     * @param path New value of path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets new url.
     *
     * @param url New value of url.
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * Sets new bytes.
     *
     * @param bytes New value of bytes.
     */
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
