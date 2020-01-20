package com.ac;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2019/10/9 14:42
 */
@Slf4j
public class MainTest {

    public static void main(String[] args) throws Exception {
        test15();
    }



    private static void test15(){


    }















    /**
     * javabean to map
     */
    private static void test14() throws IllegalAccessException {
        UserBean userBean2 = new UserBean(4L, "haha");
        Class<? extends UserBean> aClass = userBean2.getClass();
        Field[] fields = aClass.getDeclaredFields();
        LinkedHashMap<String, Object> map = Maps.newLinkedHashMap();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(userBean2);
            map.put(name,value);
        }
        System.out.println(map);
    }









    /**
     * 日期周期
     */
    private static void test13(){
        Period between = Period.between(LocalDate.now(), LocalDate.now());
        System.out.println(between.getDays());
    }



    /**
     *
     */
    private static void test12() {
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(4L, "haha");
        UserBean userBean3 = new UserBean(2L, "hehe");
        UserBean userBean4 = new UserBean(1L, "weihongda");
        UserBean userBean5 = new UserBean(1L, "anchao");
        ArrayList<UserBean> userBeanArrayList = Lists.newArrayList(userBean, userBean2, userBean3, userBean4,userBean5);
    }


    /**
     * 按字符读取文件
     */
    private static void test11() {
        File file = new File("D:/tt.txt");
        File file2 = new File("D:/TEST_FILE/tt3.txt");
        if (!file2.exists()) {
            file2.mkdir();
        }

        try {
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream(file2), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String a;
            while ((a = bufferedReader.readLine()) != null) {
                bufferedWriter.write(a);
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 原生读写文件
     */
    private static void test10(){

        BufferedInputStream bufferedInputStream =null;
        BufferedOutputStream bufferedOutputStream = null;

        File file = new File("D:/tt.txt");
        File file2 = new File("D:\\TEST_FILE\\");
        if(!file2.exists()){
            file2.mkdir();
        }
        try {

             bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            String fil = file2.getPath()+"t1.txt";
             bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fil));

            int a;
            byte[] bytes = new byte[100*1024];

            while((a =bufferedInputStream.read(bytes,0,bytes.length)) !=-1){
                bufferedOutputStream.write(bytes,0,a);
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    /**
     * 读取自定义配置文件
     */
    private static void test9(){
        ClassPathResource classPathResource = new ClassPathResource("proper.properties");
        log.warn("读取自定义配置文件,classPathResource={}",classPathResource);
        Properties properties = new Properties();
        try {
            properties.load(classPathResource.getInputStream());
            log.warn("读取自定义配置文件,properties={}",properties);
            String key = properties.getProperty("key");
            log.warn("读取自定义配置文件,key={}",key);
        } catch (IOException e) {
            log.error("",e);
        }
    }


    /**
     * 解决KEY相同时问题
     */
    private static void test8(){
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(4L, "haha");
        UserBean userBean3 = new UserBean(2L, "hehe");
        UserBean userBean4 = new UserBean(1L, "weihongda");
        UserBean userBean5 = new UserBean(1L, "anchao");
        ArrayList<UserBean> userBeanArrayList = Lists.newArrayList(userBean, userBean2, userBean3, userBean4,userBean5);
        HashMap<Long, String> collect = userBeanArrayList.stream().collect(Collectors.toMap(UserBean::getId
                ,u -> u.getName(),(v1,v2) -> v1+","+v2
                , Maps::newHashMap));
        System.out.println(collect);
    }


    /**
     * 实体 集合 参数值 比对
     */
    private static void test7(){
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(1L, "anchao");
        userBean.setUserBeans(Arrays.asList(userBean));
        userBean2.setUserBeans(Arrays.asList(userBean2));
        System.out.println("实体比对"+userBean.equals(userBean2));
        System.out.println("集合比对"+Arrays.equals(userBean.getUserBeans().toArray(),userBean2.getUserBeans().toArray()));
    }


    /**
     * localDate 转 date
     */
    private static void test6(){
        //localDate 转 date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(simpleDateFormat.format(date));
    }


   /**
     * 并发保证原子性
     */
    private static void testAtomic(){
        AtomicReference<Integer> one = new AtomicReference<>(1);
        Integer oneGet = one.get();
        one.compareAndSet(oneGet,2);
        System.out.println(one.get());
    }


    /**
     * 取最大
     */
    public static void test(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));
        max.ifPresent(t ->{
            System.out.println(t);
        });
    }



    /**
     * 部分去重
     */
    private static void test4(){
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(4L, "haha");
        UserBean userBean3 = new UserBean(2L, "hehe");
        UserBean userBean4 = new UserBean(1L, "weihongda");
        List<UserBean> userBeans = Arrays.asList(userBean, userBean2, userBean3, userBean4);
        TreeSet<UserBean> treeSet = userBeans.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserBean::getId))));

        ArrayList<UserBean> collect = userBeans.stream().collect(Collectors.collectingAndThen(Collectors.
                toCollection(() -> new TreeSet<>(Comparator.comparing(UserBean::getId))), Lists::newArrayList));

        System.out.println(treeSet);
        System.out.println(collect);
        System.out.println(userBean);
    }


}
