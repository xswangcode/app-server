package com.wxs.code.core.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CompareUtil {


    /**
     * 比较两个对象的大小。
     * <p>
     * 若两个对象均为数值类型，则转换为 BigDecimal 后比较。<br>
     * 若两个对象均实现了 Comparable 接口并且类型兼容，则使用 compareTo 比较。<br>
     * 如果类型不兼容或无法比较，则抛出 IllegalArgumentException 异常。
     * </p>
     *
     * @param a 第一个对象
     * @param b 第二个对象
     * @return 如果 a 小于 b 返回负数，等于返回 0，大于返回正数
     * @throws IllegalArgumentException 如果两个对象无法比较
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static int compare(Object a, Object b) {
        // 处理 null 值
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }

        // 若都是数值类型，则统一转换为 BigDecimal 后比较
        if (a instanceof Number && b instanceof Number) {
            BigDecimal aVal = toBigDecimal((Number) a);
            BigDecimal bVal = toBigDecimal((Number) b);
            return aVal.compareTo(bVal);
        }

        // a位数值，b 为string
        if (a instanceof Number && b instanceof String) {
            BigDecimal aVal = toBigDecimal((Number) a);
            BigDecimal bVal = new BigDecimal(String.valueOf(b));
            return aVal.compareTo(bVal);
        }
        // a 为string，b位数值
        if (a instanceof String && b instanceof Number) {
            BigDecimal aVal = new BigDecimal(String.valueOf(a));
            BigDecimal bVal = toBigDecimal((Number) b);
            return aVal.compareTo(bVal);
        }


        // 若都是 Boolean 类型，直接使用 Boolean.compare
        if (a instanceof Boolean && b instanceof Boolean) {
            return Boolean.compare((Boolean) a, (Boolean) b);
        }

        // 若两个对象均实现 Comparable 接口，并且类型兼容，则使用 compareTo 比较
        if (a instanceof Comparable && b instanceof Comparable) {
            // 当类型兼容时，直接比较
            if (a.getClass().isAssignableFrom(b.getClass()) || b.getClass().isAssignableFrom(a.getClass())) {
                return ((Comparable) a).compareTo(b);
            }
        }


        // 类型不支持比较，抛出异常
        throw new IllegalArgumentException("无法比较的类型: " + a.getClass() + " 和 " + b.getClass());
    }

    /**
     * 将 Number 类型转换为 BigDecimal。
     * <p>
     * 支持的类型包括 BigDecimal、BigInteger、Byte、Short、Integer、Long、Float、Double。
     * 若遇到其它类型，则尝试通过 toString() 转换，若转换失败则抛出异常。
     * </p>
     *
     * @param number 数值对象
     * @return 转换后的 BigDecimal
     * @throws IllegalArgumentException 如果无法转换为 BigDecimal
     */
    private static BigDecimal toBigDecimal(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        } else if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger) number);
        } else if (number instanceof Byte || number instanceof Short || number instanceof Integer || number instanceof Long) {
            return BigDecimal.valueOf(number.longValue());
        } else if (number instanceof Float || number instanceof Double) {
            // 使用 BigDecimal.valueOf 可避免直接 new BigDecimal(double) 带来的精度问题
            return BigDecimal.valueOf(number.doubleValue());
        } else {
            try {
                return new BigDecimal(number.toString());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("无法将数字转换为 BigDecimal: " + number, e);
            }
        }
    }
}
