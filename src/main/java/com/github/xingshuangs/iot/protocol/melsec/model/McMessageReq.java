package com.github.xingshuangs.iot.protocol.melsec.model;


import com.github.xingshuangs.iot.protocol.common.IObjectByteArray;
import com.github.xingshuangs.iot.protocol.common.buff.ByteWriteBuff;
import lombok.Data;

/**
 * 请求消息
 *
 * @author xingshuang
 */
@Data
public class McMessageReq implements IObjectByteArray {

    /**
     * 请求头
     */
    private McHeaderReq header;

    /**
     * 请求体，数据
     */
    private McData data;

    @Override
    public int byteArrayLength() {
        return this.header.byteArrayLength() + this.data.byteArrayLength();
    }

    @Override
    public byte[] toByteArray() {
        return ByteWriteBuff.newInstance(this.byteArrayLength(), true)
                .putBytes(this.header.toByteArray())
                .putBytes(this.data.toByteArray())
                .getData();
    }
}
