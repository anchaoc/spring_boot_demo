package com.ac;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @author anchao
 * @date 2019/12/23 16:02
 */
public class GuavaTest {

    //连接器
    private static final Joiner JOINER = Joiner.on(",").skipNulls();

    //分割器
    private static final Splitter SPLITTER = Splitter.on(",").trimResults().omitEmptyStrings();

    //字符匹配器
    private static final CharMatcher CHAR_MATCHER_DIGIT = CharMatcher.digit();
    private static final CharMatcher CHAR_MATCHER_ANY = CharMatcher.any();

    //guava提供了Bytes/Shorts/Ints/Iongs/Floats/Doubles/Chars/Booleans 扩展基本数据类型

    //guava提供了很多Immutable集合(不可变集合)，比如ImmutableList/ImmutableSet/ImmutableSortedSet/ImmutableMap/……

    //功能KEY一对多 Multimap的实现类有：ArrayListMultimap/HashMultimap/LinkedHashMultimap/TreeMultimap/ImmutableMultimap/……

    //BiMap接口 可根据value获取key的MAP iMap.inverse()

    //Table接口 可设置两个KEY(row,column) 组合 获取value



    public static void main(String[] args) {
//        String join = JOINER.join(Lists.newArrayList("a", null, "b"));
//        System.out.println(join);
//        String str ="a ,b,,c";
//        System.out.println(SPLITTER.split(str).toString());
        //System.out.println(CHAR_MATCHER_DIGIT.removeFrom("love:1314"));
        //System.out.println(CHAR_MATCHER_ANY.removeFrom("LOVE:1313131"));
        //List<String> list = ImmutableList.of("1", "2");
        //list.add("3");
//        ArrayListMultimap<Object, Object> map = ArrayListMultimap.create();
//        map.put("1",1);
//        map.put("1",2);
//        map.put("1",3);
//        //map.get("");
//       System.out.println(map);
//        HashBiMap<Object, Object> map = HashBiMap.create();
//        map.put("anchao",123);
//        map.put("xiaoming",456);
//        System.out.println(map.get(123));
//        HashBasedTable<Object, Object, Object> hashBasedTable = HashBasedTable.create();
//        hashBasedTable.put("row","column","anchaotest");
//        Map<Object, Object> column = hashBasedTable.column("column");
//        System.out.println(hashBasedTable.column("column"));
    }



}
