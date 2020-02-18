package com.ac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author anchao
 * @date 2020/2/17 14:44
 */
@Getter
@ToString
@AllArgsConstructor
public enum BookTypeEnum {

    /**
     * 书籍类型
     */
    A("体育",1),
    B("军事",2),
    C("生活",3);

    private String msg;
    private Integer code;


    public static BookTypeEnum getEnum(String name){

        switch (name){
            case "A":
                return BookTypeEnum.A;

            case "B":
                return BookTypeEnum.B;

            case "C":
                return BookTypeEnum.C;

                default:
                    return null;
        }
    }


    public static void main(String[] args) {
        BookTypeEnum c = BookTypeEnum.valueOf("C");
        System.out.println(c);

    }

}
