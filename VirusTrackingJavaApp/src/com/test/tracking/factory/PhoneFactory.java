package com.test.tracking.factory;

import com.test.tracking.model.PhoneType;

public class PhoneFactory {

    public PhoneAPI getPhoneAPI(PhoneType type) {
         switch (type) {
            case SAMSUNG : return new ImpSamsung();
            case IPHONE : return new ImpIPhone();
        }
        return null;
    }
}
