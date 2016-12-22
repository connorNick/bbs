package com.shareniu.bbs.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean isNotEmpty(Object[] objs) {
        return objs != null && objs.length != 0;
    }

    public static boolean isEmpty(Object[] objs) {
        return objs == null || objs.length == 0;
    }

    public static void removeNull(Collection c) {
        if(c != null) {
            ArrayList listnull = new ArrayList();
            listnull.add((Object)null);
            c.removeAll(listnull);
        }

    }

    public static boolean sameValueInList(List listValue, Object sample) throws Exception {
        boolean mark = true;
        Iterator i$ = listValue.iterator();

        while(i$.hasNext()) {
            Object oo = i$.next();
            if(!oo.equals(sample)) {
                mark = false;
                break;
            }
        }

        return mark;
    }

    public static boolean addUniqueObjList(List list, Object obj) {
        if(!list.contains(obj) && obj != null) {
            list.add(obj);
            return true;
        } else {
            return false;
        }
    }
}
