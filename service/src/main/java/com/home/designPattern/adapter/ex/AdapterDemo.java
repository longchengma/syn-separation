package com.home.designPattern.adapter.ex;

/**
 * Created by li.ma on 2019/3/4.
 */
public class AdapterDemo {
    public static void main(String[] args) {
        VoltageAdapterIm voltageAdapterIm = new VoltageAdapter();

        Phone phone = new Phone();
        phone.setAdapter(voltageAdapterIm);

        phone.charge();
    }
}

interface VoltageAdapterIm {
    void changeVoltage();  // 改变电压的功能
}

class VoltageAdapter implements VoltageAdapterIm {

    @Override
    public void changeVoltage() {
        System.out.println("正在充电...");
        System.out.println("原始电压：" + Phone.V + "V");
        System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
    }
}

class Phone {
    public static final int V = 220;// 正常电压220v，是一个常量

    private VoltageAdapterIm adapter;

    // 充电
    public void charge() {
        adapter.changeVoltage();
    }


    public void setAdapter(VoltageAdapterIm adapter) {
        this.adapter = adapter;
    }
}