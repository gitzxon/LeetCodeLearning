package study.playground.AccessOrderedMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccessOrdererMapDemo {

    public static void main(String[] args) {

        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) { // 实现自定义删除策略，否则行为就和普遍 Map 没有区别
                return size() > 3;
            }
        };

        accessOrderedMap.put("1", "Valhalla");
        accessOrderedMap.put("2", "Panama");
        accessOrderedMap.put("3", "Loom");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        // 模拟访问
        accessOrderedMap.get("2");
        accessOrderedMap.get("3");
        accessOrderedMap.get("1");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach( (k,v) -> {
            System.out.println(k +":" + v);
        });

        // 触发删除
        accessOrderedMap.put("4", "Mission Control");
        System.out.println("Oldest entry should be removed:");
        accessOrderedMap.forEach( (k,v) -> {// 遍历顺序不变
            System.out.println(k +":" + v);
        });
    }

}
