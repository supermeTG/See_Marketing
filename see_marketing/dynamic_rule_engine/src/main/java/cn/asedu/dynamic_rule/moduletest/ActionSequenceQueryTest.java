package cn.asedu.dynamic_rule.moduletest;

import cn.asedu.dynamic_rule.pojo.LogBean;
import cn.asedu.dynamic_rule.service.UserActionSequenceQueryServiceStateImpl;
import cn.asedu.dynamic_rule.pojo.RuleAtomicParam;

import java.util.ArrayList;
import java.util.HashMap;

public class ActionSequenceQueryTest {
    public static void main(String[] args) {

        // 构造一些事件
        LogBean logBean1 = new LogBean();
        logBean1.setEventId("000010");
        HashMap<String, String> props1 = new HashMap<>();
        props1.put("p1","v1");
        logBean1.setProperties(props1);

        LogBean logBean5 = new LogBean();
        logBean5.setEventId("000020");
        HashMap<String, String> props5 = new HashMap<>();
        props5.put("p2","v3");
        logBean5.setProperties(props5);


        LogBean logBean2 = new LogBean();
        logBean2.setEventId("000310");
        HashMap<String, String> props2 = new HashMap<>();
        props2.put("p1","v2");
        logBean2.setProperties(props2);


        LogBean logBean3 = new LogBean();
        logBean3.setEventId("000020");
        HashMap<String, String> props3 = new HashMap<>();
        props3.put("p2","v3");
        props3.put("p4","v5");
        logBean3.setProperties(props3);


        LogBean logBean4 = new LogBean();
        logBean4.setEventId("000022");
        HashMap<String, String> props4 = new HashMap<>();
        props4.put("p2","v3");
        props4.put("p3","v4");
        logBean4.setProperties(props4);


        ArrayList<LogBean> eventList = new ArrayList<>();
        eventList.add(logBean1);
        eventList.add(logBean5);
        eventList.add(logBean2);
        eventList.add(logBean3);
        eventList.add(logBean4);

        // 构造一个序列条件
        RuleAtomicParam param1 = new RuleAtomicParam();
        param1.setEventId("000010");
        HashMap<String, String> paramProps1 = new HashMap<>();
        paramProps1.put("p1","v1");
        param1.setProperties(paramProps1);

        RuleAtomicParam param2 = new RuleAtomicParam();
        param2.setEventId("000020");
        HashMap<String, String> paramProps2 = new HashMap<>();
        paramProps2.put("p2","v3");
        param2.setProperties(paramProps2);

        RuleAtomicParam param3 = new RuleAtomicParam();
        param3.setEventId("000020");
        HashMap<String, String> paramProps3 = new HashMap<>();
        paramProps3.put("p4","v6");
        param3.setProperties(paramProps3);

        ArrayList<RuleAtomicParam> ruleParams = new ArrayList<>();
        ruleParams.add(param1);
        ruleParams.add(param2);
        ruleParams.add(param3);


        // 调用sevice计算
        UserActionSequenceQueryServiceStateImpl service = new UserActionSequenceQueryServiceStateImpl(null);
        int maxStep = service.queryActionSequenceHelper2(eventList, ruleParams);
        System.out.println(maxStep);


    }
}
