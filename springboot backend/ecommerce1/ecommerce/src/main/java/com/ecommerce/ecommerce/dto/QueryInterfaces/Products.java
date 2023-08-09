package com.ecommerce.ecommerce.dto.QueryInterfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface Products {

     Long getproductID();
     String getsku();
     String getname();
     String getdescription();
     BigDecimal getunit_Price();
     String getimage_URL();
     int getcategory_id();
}
