package org.paingan.boot.repository;

import java.util.List;

import org.paingan.boot.dto.ChartDTO;
import org.paingan.boot.model.Chart4G;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Chart4GRepository extends JpaRepository<Chart4G, Long>, JpaSpecificationExecutor<Chart4G>    {

    public List<ChartDTO> findAllChart4G();
}
