package com.shareniu.bbs.common.po.email;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

/**
 * 附件
 *
 * Created by wzy on 2015/5/12.
 */
public class AttachmentBean implements Attachment {
    private static final long serialVersionUID = 7064296119821191762L;

    private AttachmentPo attachmentPo;

    public AttachmentBean (AttachmentPo attachmentPo) {
        this.attachmentPo = attachmentPo;
    }

    @Override
    public String getPath() {
        return attachmentPo.getPath();
    }

    @Override
    public URL getUrl() {
        return attachmentPo.getUrl();
    }

    @Override
    public byte[] getBytes() {
        return attachmentPo.getBytes();
    }

    /**
     * 将文件的byte数组写入文件
     * <p/>
     * <p>当使用<code>getBytes()</code>方法获取文件，进行邮件发送失败时候，调用此方法，将文件写入文件，以备重发使用</p>
     */
    @Override
    public void writeBytesToFile() {
        if (this.attachmentPo.getBytes() != null) {
            File file = new File("", UUID.randomUUID().toString());
            try {
                FileUtils.writeByteArrayToFile(file, this.attachmentPo.getBytes());
                this.attachmentPo.setPath(file.getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getAttachName() {
        return attachmentPo.getAttachName();
    }

    @Override
    public String getDescription() {
        return attachmentPo.getDescription();
    }

    /**
     * Sets new attachmentPo.
     *
     * @param attachmentPo New value of attachmentPo.
     */
    public void setAttachmentPo(AttachmentPo attachmentPo) {
        this.attachmentPo = attachmentPo;
    }

    /**
     * Gets attachmentPo.
     *
     * @return Value of attachmentPo.
     */
    public AttachmentPo getAttachmentPo() {
        return attachmentPo;
    }
}
