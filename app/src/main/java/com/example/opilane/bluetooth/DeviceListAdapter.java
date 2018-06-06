package com.example.opilane.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by opilane on 6/6/2018.
 */

public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<BluetoothDevice> mDevices;
    private int mViewRecourseId;

    public DeviceListAdapter(Context context, int tvRecourseId, ArrayList<BluetoothDevice> devices){
        super(context, tvRecourseId, devices);
        this.mDevices = devices;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewRecourseId = tvRecourseId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        convertView = mLayoutInflater.inflate(mViewRecourseId, null);
        BluetoothDevice device = mDevices.get(position);
        if (device !=null){
            TextView deviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
            TextView deviceAddress = (TextView) convertView.findViewById(R.id.tvDeviceAddress);

            if (deviceName !=null){
                deviceName.setText(device.getName());
            }
            if (deviceAddress !=null){
                deviceAddress.setText(device.getAddress());
            }
        }
        return  convertView;
    }
}
