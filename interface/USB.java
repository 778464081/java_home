package org.malajava;

/**
 * 1、在 Java 语言中一个接口 可以同时继承多个 父接口 
 * 2、当一个接口继承多个父接口时，父接口名称 之间使用 逗号 隔开
 */
public interface USB extends Chargeable , Transfer { // USB : Universal Serial Bus ( 通用串行总线 )
	// USB 接口继承了 Chargeable , Transfer 接口中的抽象方法
}
