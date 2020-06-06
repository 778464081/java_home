##  Math

####  常用方法 

abs	计算并返回由参数 x 指定的数字的绝对值.	Math.abs(x)	 

ceil	返回指定数字或表达式的上限值.数字的上限值是大于等于该数字的最接近的整数.	Math.ceil(x)	 

cos	返回由参数 x 指定的角的余弦值(介于 -1.0 与 1.0 之间的值).必须以弧度为单位指定角度 x.	Math.cos(x)	x为弧度,换算公式为:1弧度=角度*180/Math.PI*

*
exp	返回 e 的 x 次方的值,其中 e 为自然对数的底 (e),x 为参数 x 中指定的指数.	Math.exp(x)	常数 Math.E 可以提供 e 的值

.
floor	返回参数 x 中指定的数字或表达式的下限值.下限值是小于等于指定数字或表达式的最接近的整数.	Math.floor(x)	表达式:Math.floor(12.5)将返回值:12  即向下取整

log	返回参数 x 的自然对数.	Math.log(x)	x>0

max	返回两个数中最大者	Math.max(x,y)	 

min	返回两个数中最小者	Math.min(x,y)	 

pow	计算x的y次幂	Math.pow(x，y)	 

random	返回n,其中 0 <= n < 1	Math.random()	获得a-b之间的随机整数的公式为:Math.floor(Math.random()*(b-a+1)+a)

round	将参数 x 的值向上或向下舍入为最接近的整数并返回值	Math.round(x)	即四舍五入 

sin	计算并返回以弧度为单位指定的角度的正弦值	Math.sin(x)	换算公式参见cos

sqrt	计算并返回指定数字的平方根	Math.sqrt(x)	x>=0

tan	计算并返回指定角度的正切值	Math.tan(x)	换算公式参见cos

acos	以弧度为单位计算并返回参数 x 中指定的数字的反余弦值.	Math.acos(x)	-1.0<=x<=1.0

asin	以弧度为单位计算并返回参数 x 中指定的数字的反正弦值.	Math.asin(x)	-1.0<=x<=1.0

atan	计算并返回参数 x 中指定的数字的反正切值.	Math.atan(x)	返回值介于负二分之 pi 与正二分之 pi 之间.

atan2	以弧度为单位计算并返回 y/x 的反正切值.返回值表示相对直角三角形对角的角,其中 x 是临边边长,而 y 是对边边长.	Math.atan2(y,x)	x/y分别指定点的x坐标和y坐标