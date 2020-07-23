package com.fabienjouanneau.sharemycar.website.webServices.carOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOptionRepository extends JpaRepository<CarOption, Long> {
}
