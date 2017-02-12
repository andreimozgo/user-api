package by.beatdev.repository;

import by.beatdev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2015-2017 JLife Systems. All rights reserved.
 *
 * @author Andrei Mozgo
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
