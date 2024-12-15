package repository;

import java.util.List;

import models.Address;

public interface IAddressRepo {
	Address addAddress(Address address);
	List<Address> getAddressesByUserID(int user_id);
}
