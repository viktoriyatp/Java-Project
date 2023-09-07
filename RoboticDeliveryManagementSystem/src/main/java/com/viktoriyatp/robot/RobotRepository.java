package com.viktoriyatp.robot;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends ListCrudRepository<Robot, Integer> {

}
