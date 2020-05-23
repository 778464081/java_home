package laptop;

public class Laptop {
    public void powerOff(){
        System.out.println("笔记本关机");
    }
    public void powerOn(){
        System.out.println("笔记本开机");
    }
    public void useDevice(USB usb){
            usb.open();
            if(usb instanceof Mouse){
                Mouse mouse =(Mouse) usb;
                mouse.type();
            }else if (usb instanceof Keyboard){
                Keyboard keyboard =(Keyboard)usb;
                keyboard.type();
            }
            usb.close();
    }
}
