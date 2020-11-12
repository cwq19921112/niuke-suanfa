package com.chenwuqiang;

public class TestSign {
    public static void main(String[] args) {
        String xaeptimeStamp = SHAUtil.getTimeStamp();
        String xaepnonce = SHAUtil.getNonceStr();
        String xaepappkey = "chenwuqiang";
        String signature = SHAUtil.generateSign(xaeptimeStamp, xaepnonce, xaepappkey);
        System.out.println(signature);
    }
}
