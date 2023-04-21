package com.github.xingshuangs.iot.protocol.rtsp.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class RtspTransportTest {

    @Test
    public void extractFrom() {
        String src = "RTP/AVP;unicast;client_port=60802-60803;server_port=8216-8217;ssrc=4f92ef4b;mode=\"play\"";
        RtspTransport transport = RtspTransport.fromString(src);
        assertEquals("RTP/AVP", transport.getProtocol());
        assertEquals("unicast", transport.getCastMode());
        assertEquals(60802, transport.getRtpClientPort().intValue());
        assertEquals(60803, transport.getRtcpClientPort().intValue());
        assertEquals(8216, transport.getRtpServerPort().intValue());
        assertEquals(8217, transport.getRtcpServerPort().intValue());
        assertEquals("4f92ef4b", transport.getSsrc());
        assertEquals("play", transport.getMode());
        assertEquals(src, transport.toString());
    }

    @Test
    public void toString1() {
        String expect = "RTP/AVP;unicast;client_port=60802-60803";
        RtspTransport transport = new RtspTransport();
        transport.setProtocol("RTP/AVP");
        transport.setCastMode("unicast");
        transport.setRtpClientPort(60802);
        transport.setRtcpClientPort(60803);
        assertEquals(expect, transport.toString());
    }
}