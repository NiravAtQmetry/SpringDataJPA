package com.example.sdj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sdj.entity.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Long> {

}
