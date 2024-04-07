/*
 * MIT License
 *
 * Copyright (c) 2021-2099 Oscura (xingshuang) <xingshuang_cool@163.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.xingshuangs.iot.protocol.rtsp.model.sdp;


import com.github.xingshuangs.iot.exceptions.RtspCommException;
import lombok.Data;

import static com.github.xingshuangs.iot.protocol.rtsp.constant.RtspCommonKey.SP;

/**
 * 连接信息
 * IN IP4 0.0.0.0
 *
 * @author xingshuang
 */
@Data
public class RtspSdpConnection {
    /**
     * 网络类型，IN，表示internet
     */
    private String networkType;

    /**
     * 地址类型，IP4，表示ipv4
     */
    private String addressType;

    /**
     * 连接地址，192.168.31.115，表示服务器的地址
     */
    private String connectionAddress;

    public static RtspSdpConnection fromString(String src) {
        if (src == null || src.equals("")) {
            throw new IllegalArgumentException("The SDP, src is null or empty");
        }

        RtspSdpConnection connection = new RtspSdpConnection();
        String[] split = src.split(SP);
        if (split.length != 3) {
            throw new RtspCommException("The RtspSdpConnection data is incorrect and cannot be resolved");
        }
        connection.networkType = split[0];
        connection.addressType = split[1];
        connection.connectionAddress = split[2];
        return connection;
    }
}
