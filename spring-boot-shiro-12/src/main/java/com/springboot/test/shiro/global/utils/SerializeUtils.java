package com.springboot.test.shiro.global.utils;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;

/**
 * @author: wangsaichao
 * @date: 2018/6/20
 * @description: redis的value序列化工具
 */
public class SerializeUtils implements RedisSerializer {

    private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    public static boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }

//    /**
//     * 纯hessian序列化
//     * @param object
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public  byte[] serialize(Object object) throws SerializationException {
//
//        if (object == null) {
//            throw new NullPointerException();
//        }
//        byte[] results = null;
//        ByteArrayOutputStream os = null;
//        HessianSerializerOutput hessianOutput = null;
//        try {
//            os = new ByteArrayOutputStream();
//            hessianOutput = new HessianSerializerOutput(os);
//            //write本身是线程安全的
//            hessianOutput.writeObject(object);
//            results = os.toByteArray();
//        } catch (Exception e) {
//            throw new SerializationException("Could not serialize: " + e.getMessage(), e);
//        } finally {
//            try {
//                if (os != null){
//                    os.close();
//                }
//                if(hessianOutput != null){
//                    hessianOutput.close();
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        }
//        return results;
//    }
//
//
//
//    /**
//     * 纯hessian反序列化
//     * @param bytes
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public Object deserialize(byte[] bytes) throws SerializationException {
//
//        if (bytes == null) {
//            throw new NullPointerException();
//        }
//
//        Object obj= null;
//        ByteArrayInputStream is = null;
//
//        try {
//            is = new ByteArrayInputStream(bytes);
//            HessianSerializerInput hessianInput = new HessianSerializerInput(is);
//            obj =  hessianInput.readObject();
//
//        } catch (Exception e) {
//            throw new SerializationException("Could not deserialize: " + e.getMessage(), e);
//        } finally {
//            try {
//                if (is != null){
//                    is.close();
//                }
//            } catch (IOException e) {
//                throw new SerializationException("Could not deserialize: " + e.getMessage(), e);
//            }
//        }
//        return obj;
//
//
//
//    }

    /**
     * 序列化
     * @param object
     * @return
     * @throws SerializationException
     */
    @Override
    public byte[] serialize(Object object) throws SerializationException {
        byte[] result = null;

        if (object == null) {
            return new byte[0];
        }
        try (
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream)
        ){

            if (!(object instanceof Serializable)) {
                throw new IllegalArgumentException(SerializeUtils.class.getSimpleName() + " requires a Serializable payload " +
                        "but received an object of type [" + object.getClass().getName() + "]");
            }
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            result =  byteStream.toByteArray();
        } catch (Exception ex) {
            logger.error("Failed to serialize",ex);
        }
        return result;
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     * @throws SerializationException
     */
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {

        Object result = null;

        if (isEmpty(bytes)) {
            return null;
        }

        try (
                ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteStream)
        ){
            result = objectInputStream.readObject();
        } catch (Exception e) {
            logger.error("Failed to deserialize",e);
        }
        return result;
    }

}
