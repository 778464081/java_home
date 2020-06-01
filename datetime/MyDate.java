package cn.edu.ecut;

/**
 * 通过 自己的 Date 类理解 java.util.Date 类的内部设计
 */
public class MyDate {
	
	private transient long fastTime ; // 用来存储毫秒值
	
	public MyDate() {
		this( System.currentTimeMillis() ); // 调用另外一个构造方法
	}

	public MyDate( long date ) {
		super();
		fastTime = date ;
	}
	
	public void setTime(long time) {
        fastTime = time;
    }
	
	public long getTime() {
        return this.fastTime ;
    }

}
