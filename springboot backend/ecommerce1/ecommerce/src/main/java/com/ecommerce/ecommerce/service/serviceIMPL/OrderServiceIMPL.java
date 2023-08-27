package com.ecommerce.ecommerce.service.serviceIMPL;

import com.ecommerce.ecommerce.Entity.*;
import com.ecommerce.ecommerce.dto.request.RequestOrderItemSaveDTO;
import com.ecommerce.ecommerce.dto.request.RequestOrderSaveDTO;
import com.ecommerce.ecommerce.exception.CustomerNotSavedException;
import com.ecommerce.ecommerce.exception.OrderListEmptyException;
import com.ecommerce.ecommerce.repositoy.*;
import com.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ShippingAddressRepo shippingAddressRepo;
    @Autowired
    private BillingAddressRepo billingAddressRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;

    public Long orderId;

    @Override
    public String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        try{
            Customer customer = new Customer(
                    requestOrderSaveDTO.getCustomer().getFirstName(),
                    requestOrderSaveDTO.getCustomer().getLastName(),
                    requestOrderSaveDTO.getCustomer().getEmail()
            );
            customerRepo.save(customer);
            if(customerRepo.findById(customer.getId()).isPresent()){
                ShippingAddress shippingAddress = new ShippingAddress(
                        requestOrderSaveDTO.getShipping_address().getStreet(),
                        requestOrderSaveDTO.getShipping_address().getCity(),
                        requestOrderSaveDTO.getShipping_address().getState(),
                        requestOrderSaveDTO.getShipping_address().getCountry(),
                        requestOrderSaveDTO.getShipping_address().getZipCode()
                );
                shippingAddressRepo.save(shippingAddress);
                BillingAddress billingAddress = new BillingAddress(
                        requestOrderSaveDTO.getBilling_address().getStreet(),
                        requestOrderSaveDTO.getBilling_address().getCity(),
                        requestOrderSaveDTO.getBilling_address().getState(),
                        requestOrderSaveDTO.getBilling_address().getCountry(),
                        requestOrderSaveDTO.getBilling_address().getZipCode()
                );
                billingAddressRepo.save(billingAddress);
                Date date = new Date();
                Order order = new Order(
                        UUID.randomUUID().toString(),
                        requestOrderSaveDTO.getTotalQuantity(),
                        requestOrderSaveDTO.getTotalPrice(),
                        shippingAddress,
                        billingAddress,
                        true,
                        date,
                        date,
                        customer
                );
                orderRepo.save(order);
                orderId = order.getOrder_id();
                String trackingNumber = order.getOrderTrackingNumber();
                if(requestOrderSaveDTO.getOrderItemSaveDTOList().size()>0){
                    try{
                        List<OrderItem> orderItemList = requestOrderSaveDTO
                                .getOrderItemSaveDTOList().stream()
                                .map(this::DTOTOEntity)
                                .collect(Collectors.toList());
                        orderItemRepo.saveAll(orderItemList);
                        return trackingNumber;
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }else{
                    throw new OrderListEmptyException();
                }
            }else {
                throw  new CustomerNotSavedException();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "order not saved";
    }
    private OrderItem DTOTOEntity(RequestOrderItemSaveDTO requestOrderItemSaveDTO) {
        Product product = productRepo.getById(requestOrderItemSaveDTO.getId());
        OrderItem orderItem = new OrderItem();
        orderItem.setImageURL(requestOrderItemSaveDTO.getImageURL());
        orderItem.setUnitPrice(requestOrderItemSaveDTO.getUnitPrice());
        orderItem.setQuantity(requestOrderItemSaveDTO.getQuantity());
        orderItem.setOrder(orderRepo.getById(orderId));
        orderItem.setProduct(product);
        return orderItem;
    }
}
