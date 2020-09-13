package com.huangda7.provider.infrastructure.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanCopierUtils {
  private BeanCopierUtils(){}
  private static Map<String, BeanCopier> copierMap = new ConcurrentHashMap<>();
  public static BeanCopier getBeanCopier(Class sourceClazz, Class targetClazz) {
    String key = sourceClazz.getCanonicalName() + "_" + targetClazz.getCanonicalName();
    if (!copierMap.containsKey(key)) {
      BeanCopier beanCopier = BeanCopier.create(sourceClazz, targetClazz, false);
      copierMap.put(key, beanCopier);
    }
    return copierMap.get(key);
  }

  public static<T, K> void copy(T orig, K dest) {
    getBeanCopier(orig.getClass(), dest.getClass()).copy(orig, dest, null);
  }
}
