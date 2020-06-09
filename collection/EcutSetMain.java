package demo02;

import java.util.HashSet;

public class EcutSetMain {
    public static void main(String[] args) {
        EcutSet st =new EcutSet();
        EcutSet ss =new EcutSet();
        ss.add("zzz");
        ss.add("fff");
        st.add("aaa");
        st.add("bbb");
        st.add("ccc");
//        st.addAll(ss);
        ss.clear();
        System.out.println(ss);

    }
}
