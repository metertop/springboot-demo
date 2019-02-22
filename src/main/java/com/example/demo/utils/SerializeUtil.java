package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description:
 * @Author: haoyuexun
 * @Date: 2019/1/24 14:06
 */
public class SerializeUtil {
    public static byte[] serialize(Object object) {

        ObjectOutputStream oos = null;

        ByteArrayOutputStream baos = null;

        try {

//序列化

            baos = new ByteArrayOutputStream();

            oos = new ObjectOutputStream(baos);

            oos.writeObject(object);

            byte[] bytes = baos.toByteArray();

            return bytes;

        } catch (Exception e) {



        }

        return null;

    }



    public static Object unserialize(byte[] bytes) {

        ByteArrayInputStream bais = null;

        try {

//反序列化

            bais = new ByteArrayInputStream(bytes);

            ObjectInputStream ois = new ObjectInputStream(bais);

            return ois.readObject();

        } catch (Exception e) {


        }

        return null;

    }

    public static void main(String[] args) {

        String redisStr = "\\xac\\xed\\x00\\x05sr\\x00/com.talk51.modules.order.vo.StuAssetReduceNumVO\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x01\\x02\\x00\\x03I\\x00\\x12isAppointDateAfterI\\x00\\nisb2bOrderI\\x00\\treduceNumxp\\x00\\x00\\x00\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x05";
        // 反序列化
        byte[] person = redisStr.getBytes();




    }
}
