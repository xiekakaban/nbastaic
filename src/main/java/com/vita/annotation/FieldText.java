package com.vita.annotation;

import java.lang.annotation.*;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldText {

    // 获取的 value
    String value();
}
