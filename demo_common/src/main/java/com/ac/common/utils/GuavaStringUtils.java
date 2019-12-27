package com.ac.common.utils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @author anchao
 * @date 2019/12/27 16:30
 */
public class GuavaStringUtils {

    /**
     * 连接器
     */
    public static final Joiner JOINER = Joiner.on(".").skipNulls();

    //分割器
    public static final Splitter SPLITTER = Splitter.on(",").trimResults().omitEmptyStrings();

    //字符匹配器
    public static final CharMatcher CHAR_MATCHER_DIGIT = CharMatcher.digit();
    public static final CharMatcher CHAR_MATCHER_ANY = CharMatcher.any();


}
