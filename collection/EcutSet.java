package demo02;

import java.util.*;

public class EcutSet<E> implements Set<E> {
    // 自己借助于 HashMap 实现 java.util.Set 接口

    private transient  HashMap<E,Object> map;
    private static final Object PRESENT = new Object();

    @Override
    public String toString() {
        Set<E> KeySet = map.keySet();
        StringBuilder oo =new StringBuilder();
        for (E a: KeySet){
            oo.append(a+"、");
        }
        return oo.toString();
    }

    public EcutSet(){
      map =  new HashMap<>();
    }
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.size()==0;
    }

    @Override
    public boolean contains(Object o) {
        return map.get(o)!=null;
    }

    @Override
    public Iterator<E> iterator() {
       return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return map.put(e,PRESENT)==null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if ( c instanceof EcutSet){
            EcutSet temp = (EcutSet) c;
            Iterator e = temp.iterator();
            while (e.hasNext()){
                if (!this.contains(e.next())){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c instanceof EcutSet){
            Iterator e = c.iterator();
            while (e.hasNext()){
              this.add((E)e.next());
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c instanceof EcutSet){

        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c instanceof EcutSet){
            Iterator e = c.iterator();
            while (e.hasNext()){

            }
        }
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }


}

