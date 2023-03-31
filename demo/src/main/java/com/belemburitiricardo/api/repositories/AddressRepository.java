package com.belemburitiricardo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belemburitiricardo.api.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
