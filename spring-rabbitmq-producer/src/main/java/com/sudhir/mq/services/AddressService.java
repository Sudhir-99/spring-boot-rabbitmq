package com.sudhir.mq.services;

import com.sudhir.mq.entity.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address updateAddress(Long id, Address address);
    Address getAddressById(Long id);
    List<Address> getAllAddresses();
    void deleteAddress(Long id);
}
